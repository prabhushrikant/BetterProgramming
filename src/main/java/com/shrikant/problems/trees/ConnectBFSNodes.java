package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Connect nodes at the same level when traveresed the tree in BFS order.
//From left to right.
//https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
//Slight modification here to also connect levels with each other.

class SplNode extends Node {

    SplNode nextRight; 
    SplNode(int item) {
        super(item);
    }

    SplNode(Node node) {
        super(node.data);
        this.data = node.data;
        this.left = node.left;
        this.right = node.right;
        this.nextRight = null;
    }

    public static SplNode createEmpty() {
        return new SplNode(-1);       
    }

    public boolean isEmpty() {
        return this.data == -1 && this.left == null && this.right == null && this.nextRight == null;
    }

}

public class ConnectBFSNodes {
    
    //recursive method for BFS
    public List<Integer> connectNodesOnSameLevel(Node root) {

        //starting tree height at 0
        int d = 0;
        Stack<SplNode> connectedNodesStack = new Stack<SplNode>();
        HeightOfTree obj = new HeightOfTree();
        int heighOfTheTree = obj.getHeight(root); 
        while(d <= heighOfTheTree) {
            connectNodesOnGivenLevel(root, d, connectedNodesStack);
            d++;
        }

        //generating the result list by following nextRight pointers only.
        List<Integer> result = new ArrayList<>();
        if (connectedNodesStack.isEmpty()) 
            return result;
        SplNode next = connectedNodesStack.get(0);
        while(next != null) {
            result.add(next.data);
            next = next.nextRight;
        }

        return result;
    }

    private void connectNodesOnGivenLevel(Node node, int level, Stack<SplNode> result)
    {      
        if (level == 0) {
            SplNode splNode = new SplNode(node);
            if (!result.isEmpty()) {
                result.peek().nextRight = splNode;
            } 
            result.push(splNode);
        }

        if (node.left != null)
        {
            connectNodesOnGivenLevel(node.left, level-1, result);
        }
        
        if (node.right != null) {
            connectNodesOnGivenLevel(node.right, level-1, result);
        }  
    }

}
