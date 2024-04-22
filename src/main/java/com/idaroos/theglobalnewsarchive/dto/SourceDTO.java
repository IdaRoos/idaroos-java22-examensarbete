package com.idaroos.theglobalnewsarchive.dto;

public class SourceDTO {

    private String name;

    public SourceDTO(String name) {
        this.name = name;
    }

    public SourceDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
