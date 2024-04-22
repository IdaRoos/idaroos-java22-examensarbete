package com.idaroos.theglobalnewsarchive.dto;

import java.util.List;

public class ArticlesDTO {

    List<ArticleDTO> articles;

    private int searchResult;

    private int totalPages;
    private int currentPage;

    public ArticlesDTO(List<ArticleDTO> articles) {
        this.articles = articles;
    }


    public ArticlesDTO() {
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }

    public int getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(int searchResult) {
        this.searchResult = searchResult;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
