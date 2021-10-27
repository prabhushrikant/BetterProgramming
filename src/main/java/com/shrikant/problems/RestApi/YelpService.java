package com.shrikant.problems.RestApi;

import java.util.List;
import java.util.ArrayList;

import com.shrikant.problems.RestApi.clients.YelpClient;
import com.shrikant.problems.RestApi.models.SearchResponse;
import com.shrikant.problems.RestApi.models.RestOpenHours;

public class YelpService {

    public List<String> openRestaurants(String searchTerm, String location, int radius, int startTime, int endTime, int day)
    {
        List<String> result = new ArrayList<>();

        //YelpClient
        YelpClient client = new YelpClient();
        List<SearchResponse> responses = client.searchBusinesses(searchTerm, location, radius);

        for(SearchResponse response : responses)
        {
            RestOpenHours openHours = client.getOpenHours(response.id, day);
            if (openHours != null)
            {
                if (openHours.start <= startTime && openHours.end >= endTime)
                {
                    result.add(response.name);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        YelpService service = new YelpService();
        List<String> openRestaurants = service.openRestaurants("pizza", "San Jose", 1500, 1300, 1700, 0);

        System.out.println(openRestaurants);

    }

}


