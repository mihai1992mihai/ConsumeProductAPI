package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta{
    public int count;
    public int limit;
    public int page;
    @JsonProperty("next_url")
    public String nextUrl;



    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "count=" + count +
                ", limit=" + limit +
                ", page=" + page +
                ", nextUrl='" + nextUrl + '\'' +
                '}';
    }
}