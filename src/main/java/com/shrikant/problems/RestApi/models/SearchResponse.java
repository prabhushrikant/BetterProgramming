package com.shrikant.problems.RestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResponse {
    
    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    public String name;

    public SearchResponse() {}; 
    
}
