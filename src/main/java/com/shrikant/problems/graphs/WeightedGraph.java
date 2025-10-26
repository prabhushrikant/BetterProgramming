package com.shrikant.problems.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.shrikant.problems.utils.Pair;

public class WeightedGraph {
    public int v;
    public ArrayList<ArrayList<Pair>> adj;

    public WeightedGraph(int v) {
        this.v = v;
        this.adj = new ArrayList<ArrayList<Pair>>(this.v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Pair>());
    }

    // directed edge from s to d with weight w
    void addEdge(int s, int d, int w) {
        adj.get(s).add(new Pair(d, w));
    }

    // input example: ["4 5", "0 1 8", "0 2 10", "0 3 6", "2 4 -1"]
    // first pair contains the number of edges and number of nodes
    // rest of the tuples contain source, destination and weight(+/-)
    // nodes are numbered from 0 to n-1
    // stores a weighted directed graph
    public static WeightedGraph Build(ArrayList<String> input) {
        WeightedGraph g = null;
        for(int i = 0; i < input.size(); i++) {
            String arr[] = input.get(i).split(" ");
            if (i == 0) {
                g = new WeightedGraph(Integer.parseInt(arr[1]));
            } else {
                g.addEdge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            }
        } 
        return g;
    }

    // Dijkstra's algorithm to get the shortest path from source to destination
    // returns an array pairs with first entry is the source, value 0 
    // similarly last entry is the destination node and value shortest distance from source
    // intermediate nodes have their shortest distance from source as value
    // e.g. for source = 0 and destination = 4
    // [(0,0), (1,8), (2,10), (3,6), (4,9)]
    // Cons: It will work with cycles in the graph but not negative cycles. Or graph with -ve weight for the edge.
    public ArrayList<Pair> getShortestPath(int source, int destination) {
        // Dijkstra's algorithm
        ArrayList<Pair> result = new ArrayList<Pair>(); 
        for (int i = 0; i < this.v; i++) {
            result.add(new Pair(i, Integer.MAX_VALUE));
        }
        result.get(source).second = 0;

        Pair start = new Pair(source, 0);
        //priority queue is a min-heap of pair(node, distance from source), so that we pick up the 
        //node with shortest distance to process next.  
        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.second));
        q.add(start);

        //put into queue only if   
        //d[v] < d[u] + weight[u,v] 
        while(!q.isEmpty()) {
            Pair popped = q.poll();
            int u = popped.first;
            int distanceOfU = popped.second;
            for(Pair neighbor : this.adj.get(u)) {
                int v = neighbor.first;
                int weight = neighbor.second;
                // this is the current distance of v from source.
                int distanceOfV = result.get(v).second;
                if (distanceOfV > (distanceOfU + weight)) {
                    //update the distance and add pair to the queue.
                    result.get(v).second = distanceOfU + weight;
                    q.add(new Pair(v, distanceOfU + weight));
                }
            }
        }
        return result;
    }
}
