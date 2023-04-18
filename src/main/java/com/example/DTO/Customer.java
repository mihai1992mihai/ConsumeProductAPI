package com.example.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("category_url")
    private String categoryUrl;

    @Override
    public String toString() {
        return "Category{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", categoryUrl='" + categoryUrl + '\'' +
                '}';
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }


}
