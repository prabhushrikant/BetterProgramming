package com.shrikant.problems.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

    public int v;
    public ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(this.v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    void addEdge(int s, int d) {
        adj.get(s).add(d);
    }

    static Graph Build(List<String> input) {

        List<Pair> processedInput = processInput(input);
        Graph g = null;
        for(int i = 0; i < processedInput.size(); i++) {
            if (i == 0) {
                g = new Graph(processedInput.get(i).second);
            } else {
                g.addEdge(processedInput.get(i).first, processedInput.get(i).second);
            }
        } 

        return g;
    }

    private static List<Pair> processInput(List<String> input) {
        List<Pair> result = new ArrayList<Pair>();
        for(int i=0; i < input.size(); i++) {
            String arr[] = input.get(i).split(" ");
            Pair p = new Pair(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            result.add(p);
        }

        return result;
    }

    private ArrayList<Integer> dfs(int head, boolean visited[], ArrayList<Integer> result) {
                   
        for(int n : adj.get(head)) {
            if (!visited[n]) {
                visited[n] = true;
                result.add(n);
                dfs(n, visited, result);
            }     
        }
        
        return result;
    }
    public ArrayList<Integer> dfs() {
        
        boolean[] visited = new boolean[this.v];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < visited.length; i++) {
            visited[i] = false;
        }

        for (int i = 0; i < v; ++i) {
            int head = i;
            if (!visited[head]) {
                visited[head] = true;
                result.add(head);
                dfs(head, visited, result);
            }            
        }
        
        return result;
    }

    public ArrayList<Integer> bfs() {
        
        boolean[] visited = new boolean[v];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < visited.length; i++) {
            visited[i] = false;
        }

        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < v; ++i) 
        {  
            if (!visited[i]) {
                visited[i] = true;
                q.add(i);
            } 
 
            while(!q.isEmpty())   
            {
                var currV = q.remove();
                result.add(currV);
                for(int n : adj.get(currV)) {
                    if (!visited[n]) {
                        visited[n] = true;
                        q.add(n);
                    }                            
                }                
            }              
        }         
        
        return result;
    }
    
}
