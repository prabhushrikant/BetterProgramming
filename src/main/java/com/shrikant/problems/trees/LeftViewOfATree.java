package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.HashSet;

public class LeftViewOfATree {
    
    public ArrayList<Integer> leftView(Node root) 
    {
        HashSet<Integer> levelsSeen = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        return leftView(root, levelsSeen, 0, result);
    }

    private ArrayList<Integer> leftView(Node node, HashSet<Integer> levelsSeen, int currentLevel, ArrayList<Integer> result) 
    {
        if (node == null) {
            return result;
        }

        if(!levelsSeen.contains(currentLevel)) 
        {
            result.add(node.data);
            levelsSeen.add(currentLevel);
        }
        if (node.left != null) {    
            leftView(node.left, levelsSeen, currentLevel+1, result);
        } 
        if (node.right != null) {                
            leftView(node.right, levelsSeen, currentLevel+1, result);
        }
    
        return result;
    }
}
