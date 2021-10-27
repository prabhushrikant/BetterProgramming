package com.shrikant.problems.RestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class MatchResponse {
    @JsonProperty("page")
    public int page;
    @JsonProperty("per_page")
    public int perPage;
    @JsonProperty("total")
    public int total;
    @JsonProperty("total_pages")
    public int totalPages;
    @JsonProperty("data")
    public List<MatchData> data;

    public MatchResponse() {}; 
}