package com.shrikant.problems.RestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestOpenHours {
    @JsonProperty("start")
    public int start;

    @JsonProperty("end")
    public int end;

    @JsonProperty("day")
    public int day;

    public RestOpenHours() {}; 
}
