package com.shrikant.problems.graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    
    private Graph g;

    public TopologicalSort(Graph g) {
        this.g = g;
    }
    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    public ArrayList<Integer> topologicalSort()
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
 
        // Mark all the vertices as not visited
        var V = g.v;
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
 
        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty() == false)
            result.add(stack.pop());
            // System.out.print(stack.pop() + " ");
        return result;
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;

        // Recur for all the vertices adjacent
        // to thisvertex
        for(int i : g.adj.get(v)) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        
        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }
}
