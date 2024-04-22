package com.idaroos.theglobalnewsarchive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ArticleResponse {

    @JsonProperty("totalResults")
    private String totalResults;
    @JsonProperty("articles")
    private List<Article> articles;

    public ArticleResponse() {
    }

    public ArticleResponse(String totalResults, List<Article> articles) {
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public ArticleResponse(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
