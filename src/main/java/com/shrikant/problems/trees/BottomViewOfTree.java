package com.shrikant.problems.trees;

import java.util.*;
import java.util.stream.Collectors;

//Program to print the bottom view of the tree. 
//Edge Case:  When there can be two nodes possible to be seen from the bottom in case of the tree. 20 8 22 5 3 4 25, here Node with value 3 and 4 share the spot in output result. 
//            Make an assumption to print the one which comes first in processing e.g. Node with value 3, i.e. result should have 5 8 3 22 25
public class BottomViewOfTree {

    public ArrayList<Integer> bottomView(Node root)
    {
        //we purposefully use treeMap here which keeps the keys of the hashmap sorted in ascending order.
        //because we want to print the bottom view of the tree from left to right. (Key here is the width from the root of the tree, so left and bottom most element will have lowest width)
        //More on treeMap here: https://www.geeksforgeeks.org/treemap-in-java/
        TreeMap<Integer, Node> widthMap = new TreeMap<Integer, Node>();
        bottomView(root, widthMap, 0);

        return (ArrayList<Integer>) widthMap.values().stream().map(x -> x.data).collect(Collectors.toList());
    }

    private void bottomView(Node node, TreeMap<Integer, Node> widthMap, int width)
    {
        if (node == null)
        {
            return;
        }

        if (node.left != null) 
        {
            bottomView(node.left, widthMap, width-1);
        }

        if (node.right != null)
        {
            bottomView(node.right, widthMap, width+1);
        }

        if (!widthMap.containsKey(width))
        {
            widthMap.put(width, node);
        }

        return;
    }
    
}
