package com.idaroos.theglobalnewsarchive.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Source {

    @JsonProperty("name")
    private String name;

    public Source(String name) {
        this.name = name;
    }

    public Source() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
