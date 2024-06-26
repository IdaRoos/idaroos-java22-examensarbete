package com.idaroos.theglobalnewsarchive.service;

import com.idaroos.theglobalnewsarchive.dto.ArticleDTO;
import com.idaroos.theglobalnewsarchive.dto.ArticlesDTO;
import com.idaroos.theglobalnewsarchive.external.NewsApiClient;
import com.idaroos.theglobalnewsarchive.model.ArticleResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final NewsApiClient newsApiClient;

    public ArticleService(NewsApiClient newsApiClient) {
        this.newsApiClient = newsApiClient;
    }


    // Calls "fetchArticles"-method in the NewsApiClient class and handles the fetched data
    @Cacheable(value = "articleCache", key = "{#query, #language, #from, #to, #page, #sortBy}")
    public Mono<ArticlesDTO> getArticles(String query, String language, String from, String to, Integer page, String sortBy) {
        return newsApiClient.fetchArticles(query, language, from, to, page, sortBy)

                // If error occurs within the API call, catch and throw custom exception
                .onErrorMap(e -> new CustomException("An error occurred while fetching articles", e))
                .map(articleResponse -> {

                    int totalResults = Integer.parseInt(articleResponse.getTotalResults());
                    // Calculate total pages needed
                    int totalPages = (int) Math.ceil((double) totalResults / 100);

                    ArticlesDTO articlesDTO = convertToArticlesDTO(articleResponse);
                    articlesDTO.setTotalPages(totalPages);
                    articlesDTO.setCurrentPage(page);
                    return articlesDTO;
                })
                // If error occurs , return empty list
                .onErrorResume(e -> Mono.just(new ArticlesDTO(Collections.emptyList())));
    }


    // Converts ArticleResponse object to ArticlesDTO object
    private ArticlesDTO convertToArticlesDTO(ArticleResponse articleResponse) {

        if (articleResponse.getArticles() == null) {
            return new ArticlesDTO(Collections.emptyList());
        }

        List<ArticleDTO> articleDTOList = articleResponse.getArticles().stream()
                .filter(article -> !(article.getTitle().equals("[Removed]") || article.getSource().getName().equals("[Removed]") || article.getPublishedAt().equals("1970-01-01T00:00:00Z")))
                .map(article -> new ArticleDTO(
                        article.getTitle(),
                        article.getDescription(),
                        article.getArticleUrl(),
                        article.getImageUrl(),
                        article.getPublishedAt(),
                        article.getSource().getName()
                ))
                // Collect filtered articles into a list
                .collect(Collectors.toList());

        return new ArticlesDTO(articleDTOList);
    }


    // Custom exception class
    public static class CustomException extends RuntimeException {
        public CustomException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
