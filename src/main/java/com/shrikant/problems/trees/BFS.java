package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Also known as level order traversal

public class BFS {
    
    //recursive method for BFS
    public ArrayList<Integer> levelOrder(Node root) {

        //starting tree height at 0
        int d = 0;
        List<Node> result = new ArrayList<>();
        HeightOfTree obj = new HeightOfTree();
        int heighOfTheTree = obj.getHeight(root); 
        while(d <= heighOfTheTree) {
            result.addAll(getNodesOnGivenLevel(root, d, new ArrayList<Node>()));
            d++;
        }

        //print the level order 
        //result.forEach(node -> System.out.print(node.data + ", "));

        return (ArrayList<Integer>)result.stream().map(x -> x.data).collect(Collectors.toList());
    }

    private ArrayList<Node> getNodesOnGivenLevel(Node node, int level, ArrayList<Node> result)
    {
        if (level == 0) {
            result.add(node);
        }

        if (node.left != null)
        {
            getNodesOnGivenLevel(node.left, level-1, result);
        }
        
        if (node.right != null) {
            getNodesOnGivenLevel(node.right, level-1, result);
        }  
        
        return result;
    }
}
