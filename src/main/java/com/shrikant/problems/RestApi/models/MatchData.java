package com.shrikant.problems.RestApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchData {
    
    @JsonProperty("competition")
    public String competition;
    @JsonProperty("year")
    public int year;
    @JsonProperty("round")
    public String round;
    @JsonProperty("team1")
    public String team1;
    @JsonProperty("team2")
    public String team2;
    @JsonProperty("team1goals")
    public int team1Goals;
    @JsonProperty("team2goals")
    private int team2Goals;

    public MatchData(){};
    
    public int getTeam1Goals()
    {
        return team1Goals;
    }

    public int getTeam2Goals()
    {
        return team2Goals;
    }
}
