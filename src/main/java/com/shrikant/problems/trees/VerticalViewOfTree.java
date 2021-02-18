package com.shrikant.problems.trees;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalViewOfTree {
    
    public ArrayList<Integer> verticalOrder(Node root)
    {
        // add your code here
        TreeMap<Integer, List<Node>> widthMap = new TreeMap<Integer, List<Node>>();
        levelOrder(root, widthMap, 0);

        return (ArrayList<Integer>) widthMap.values().stream().flatMap(Collection::stream)
            .map(x -> x.data).collect(Collectors.toList());
    }
    
    private static void levelOrder(Node node, TreeMap<Integer, List<Node>> widthMap, int width)
    {
        if (node == null)
        {
            return;
        }
        
        if (!widthMap.containsKey(width))
        {
            List<Node> nodeList = new ArrayList<Node>();
            nodeList.add(node);
            widthMap.put(width, nodeList);
        } else {
            List<Node> list = widthMap.get(width);
            list.add(node);
        }

        if (node.left != null) 
        {
            levelOrder(node.left, widthMap, width-1);
        }

        if (node.right != null)
        {
            levelOrder(node.right, widthMap, width+1);
        }

        return;
    }
}
