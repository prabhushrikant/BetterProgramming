package com.shrikant.problems.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.shrikant.problems.utils.Pair;

public class Graph {

    public int v;
    public ArrayList<ArrayList<Integer>> adj;

    public Graph(int v) {
        this.v = v;
        adj = new ArrayList<ArrayList<Integer>>(this.v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // directed edge from s to d
    void addEdge(int s, int d) {
        adj.get(s).add(d);
    }

    // input example: ["4 5", "0 1", "0 2", "0 3", "2 4"]
    // first pair contains the number of edges and number of nodes
    // nodes are numbered from 0 to n-1
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

    // Depth First Search - Recursive
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

    // Depth First Search - Iterative
    public ArrayList<Integer> dfsIterative() {
        boolean[] visited = new boolean[this.v];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < visited.length; i++) {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=0 ; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                stack.push(i);
            }

            while(!stack.isEmpty()) {
                var n = stack.pop();
                if (!visited[n]) {
                    visited[n] = true;
                    result.add(n);
                }
                // because it's DFS we should proceed with leftmost child the next, we want to push that on the stack last. (optional)
                // you can also do it without this reversal, that dfs order will be different though.
                List<Integer> children = adj.get(n);
                for (int j = children.size() - 1; j >= 0; j--) {
                    int child = children.get(j);
                    if (!visited[child]) {
                        stack.push(child);
                    }
                }
            }

        }
        return result;
    }

    // Breadth First Search - Iterative
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

    // BFS using recursion is not very common, but here is an implementation
    // it's more easy to understand using iterative approach because it goes level by level.
    public ArrayList<Integer> bfsRecursive() {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i < visited.length; i++) {
            visited[i] = false;
        }
        Queue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                q.add(i);
                bfsHelper(visited, result, q);
            }            
        }
        return result;
    }

    private void bfsHelper(boolean[] visited, ArrayList<Integer> result, Queue<Integer> q) {
        if (q.isEmpty()) {
            return;
        }
        var node = q.remove();
        result.add(node);
        for(int n : adj.get(node)) {
            if (!visited[n]) {
                visited[n] = true;
                q.add(n);
                bfsHelper(visited, result, q);
            }                            
        }  
    }
    
}
