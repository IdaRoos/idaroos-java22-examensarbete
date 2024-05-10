package com.idaroos.theglobalnewsarchive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String articleUrl;
    @JsonProperty("urlToImage")
    private String imageUrl;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("source")
    private Source source;
    @JsonProperty("content")
    private String content;

    public Article(String title, String description, String articleUrl, String imageUrl, String publishedAt, Source source) {
        this.title = title;
        this.description = description;
        this.articleUrl = articleUrl;
        this.imageUrl = imageUrl;
        this.publishedAt = publishedAt;
        this.source = source;
    }

    public Article() {
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
