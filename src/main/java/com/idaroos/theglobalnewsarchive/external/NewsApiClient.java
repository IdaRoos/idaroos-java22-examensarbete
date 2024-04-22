package com.idaroos.theglobalnewsarchive.external;

import com.idaroos.theglobalnewsarchive.model.ArticleResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class NewsApiClient {

    private final WebClient webClient;
    private final String apiKey = "28c090110d644334a258c0d19b10a9ff";

    public NewsApiClient() {
        // Set the base URL to News API
        this.webClient = WebClient.builder()
                .baseUrl("https://newsapi.org/v2")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public Mono<ArticleResponse> fetchArticles(String query, String language, String from, String to, int page, String sortBy) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/everything")
                        .queryParam("q", query)
                        .queryParam("language", language)
                        .queryParam("from", from)
                        .queryParam("to", to)
                        .queryParam("sortBy", sortBy)
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(ArticleResponse.class);
    }


}

