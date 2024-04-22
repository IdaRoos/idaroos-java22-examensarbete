package com.idaroos.theglobalnewsarchive.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleDTO {

    private String title;

    private String description;

    private String articleUrl;

    private String imageUrl;

    private String publishedAt;

    private String sourceName;


    public ArticleDTO(String title, String description, String articleUrl, String imageUrl, String publishedAt, String sourceName) {
        this.title = title;
        this.description = description;
        this.articleUrl = articleUrl;
        this.imageUrl = imageUrl;
        this.publishedAt = publishedAt;
        this.sourceName = sourceName;
    }

    public ArticleDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceDTO) {
        this.sourceName = sourceName;
    }
}
