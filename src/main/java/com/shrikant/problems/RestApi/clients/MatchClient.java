package com.shrikant.problems.RestApi.clients;

import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.shrikant.problems.RestApi.models.MatchResponse;

import java.net.HttpURLConnection;
import java.io.InputStream;

public class MatchClient {
    
    private ObjectMapper mapper = new ObjectMapper();

    public MatchResponse getMatchDetailsAsHomeTeam(String team, int year, int page)
    {
        try {
            URL MATCH_URL = new URL("https://jsonmock.hackerrank.com/api/football_matches?team1="+team+"&year="+year+"&page="+page);
            HttpURLConnection connection = (HttpURLConnection) MATCH_URL.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
        
            MatchResponse response = mapper.readValue(responseStream, MatchResponse.class);
                        
            return response; 
        } 
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        
        return null;
    }
        
    public MatchResponse getMatchDetailsAsVisitingTeam(String team, int year, int page)
    {
        try {
            URL MATCH_URL = new URL("https://jsonmock.hackerrank.com/api/football_matches?team2="+team+"&year="+year+"&page="+page);
            HttpURLConnection connection = (HttpURLConnection) MATCH_URL.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
        
            MatchResponse response = mapper.readValue(responseStream, MatchResponse.class);
                        
            return response; 
        } 
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
