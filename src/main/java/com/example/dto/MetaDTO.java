package com.example.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetaDTO {

    private Long count;
    private Long start;
    private Long limit;

    @JsonProperty("next_link")
    private String nextLink;

    @JsonProperty("previous_link")
    private String previousLink;;






}