package com.shrikant.problems.RestApi;

import com.shrikant.problems.RestApi.models.MatchData;
import com.shrikant.problems.RestApi.clients.MatchClient;
import com.shrikant.problems.RestApi.models.MatchResponse;

public class FootBallMatchesApi {
    
    /*
        * Complete the 'getTotalGoals' function below.
        *
        * The function is expected to return an INTEGER.
        * The function accepts following parameters:
        *  1. STRING team
        *  2. INTEGER year
    */
    public int getTotalGoals(String team, int year) {
            
        Integer totalGoals = 0;
        MatchClient client = new MatchClient();
        MatchResponse response = client.getMatchDetailsAsHomeTeam(team, year, 1);
        totalGoals += response.data.stream().mapToInt(MatchData::getTeam1Goals).sum();
        
        //get remaining pages if any.
        int pageCount = 2; 
        while(pageCount < response.totalPages)
        {
            response = client.getMatchDetailsAsHomeTeam(team, year, pageCount);
            totalGoals += response.data.stream().mapToInt(MatchData::getTeam1Goals).sum();
            pageCount++;
        }
        
        response = client.getMatchDetailsAsVisitingTeam(team, year, 1);
        totalGoals += response.data.stream().mapToInt(MatchData::getTeam2Goals).sum();
        
        //get remaining pages if any.
        pageCount = 2; 
        while(pageCount < response.totalPages)
        {
            response = client.getMatchDetailsAsVisitingTeam(team, year, pageCount);
            totalGoals += response.data.stream().mapToInt(MatchData::getTeam2Goals).sum();
            pageCount++;
        }

        return totalGoals;
    }
        
    public static void main(String[] args) {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // String team = bufferedReader.readLine();

        // int year = Integer.parseInt(bufferedReader.readLine().trim());

        FootBallMatchesApi api = new FootBallMatchesApi();
        int totalGoals = api.getTotalGoals("Barcelona", 2011);

        System.out.println(totalGoals);
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedReader.close();
        // bufferedWriter.close();
    }
    
}
