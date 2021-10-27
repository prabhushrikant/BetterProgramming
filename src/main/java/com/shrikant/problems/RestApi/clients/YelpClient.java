package com.shrikant.problems.RestApi.clients;

import com.shrikant.problems.RestApi.models.RestOpenHours;
import com.shrikant.problems.RestApi.models.YelpBusinessDetails;
import com.shrikant.problems.RestApi.models.YelpSearchResponse;
import com.shrikant.problems.RestApi.models.SearchResponse;

import java.net.URL;
import java.util.List;
import java.net.HttpURLConnection;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
public class YelpClient {

    private String token = "fCjCdiW3txpZLdD128irAiqbuCWgP4pVlL0BHORomzzruqfOSdBf4qNtHx6UaDnMgsqy1hBQWWNL6lDkWvJwpHKDmf29bV5-DddGgEe-Bf6XAvOA_rVcGA7r7vEfYXYx";

    private String search_endpoint = "https://api.yelp.com/v3/businesses/search";

    private String details_endpoint = "https://api.yelp.com/v3/businesses/";

    private ObjectMapper mapper = new ObjectMapper();

    public List<SearchResponse> searchBusinesses(String searchTerm, String location, int radius)
    {
        try {
            URL url = new URL(search_endpoint + "?term="+searchTerm+"&location="+location+"&radius="+radius);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("authorization", "Bearer "+ token);
            InputStream responseStream = connection.getInputStream();
        
            YelpSearchResponse response = mapper.readValue(responseStream, YelpSearchResponse.class);
                        
            return response.businesses; 
        } 
        catch(Exception exception)
        {
            exception.printStackTrace();
        }

        return null;
    }

    public RestOpenHours getOpenHours(String id, int day)
    {
        RestOpenHours result = null;
        try {
            URL url = new URL(details_endpoint + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            connection.setRequestProperty("authorization", "Bearer "+ token);
            InputStream responseStream = connection.getInputStream();
        
            YelpBusinessDetails response = mapper.readValue(responseStream, YelpBusinessDetails.class);
            for(RestOpenHours openHours : response.hours)
            {
                if (openHours.day == day)
                {
                    result = openHours;
                    break;
                }
            }
        } 
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return result;
    }
    
}
