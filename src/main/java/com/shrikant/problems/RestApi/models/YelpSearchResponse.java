package com.shrikant.problems.RestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class YelpSearchResponse {
    
    @JsonProperty("businesses")
    public List<SearchResponse> businesses;

    public YelpSearchResponse() {}; 
    
}
