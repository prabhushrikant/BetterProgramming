package com.shrikant.problems.RestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class YelpBusinessDetails {

    @JsonProperty("hours.open")
    public List<RestOpenHours> hours;

    public YelpBusinessDetails() {}; 
}
