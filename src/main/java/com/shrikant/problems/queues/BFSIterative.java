package com.shrikant.problems.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.shrikant.problems.trees.Node;

public class BFSIterative {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return result;
        }
        
        List<Integer> subResult = new ArrayList<>();     
        q.add(root);
        int iteration = 0;
        int nodesThisLevel = 1;
        int nodesNextLevel = 0;        
        while(!q.isEmpty())
        {
            Node popped = q.remove();
            subResult.add(popped.data);
            
            if (popped.left != null) 
            {
                q.add(popped.left);
                nodesNextLevel++;
            } 
            
            if (popped.right != null) 
            {
                q.add(popped.right);
                nodesNextLevel++;
            }
            
            iteration += 2; //because for each node there are two possible children.
            
            if (iteration == 2 * nodesThisLevel) {
                result.add(subResult);
                subResult = new ArrayList<>();
                iteration=0;
                nodesThisLevel = nodesNextLevel;
                nodesNextLevel = 0;
            }
        }

        return result;
    }
}
