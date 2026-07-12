package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ViewsOfATree {
    
    public ArrayList<Integer> leftView(Node root) 
    {
        HashSet<Integer> levelsSeen = new HashSet<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        return leftView(root, levelsSeen, 0, result);
    }

    public List<Integer> leftViewBfs(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (i == 0) {
                    result.add(currentNode.data);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
    }

    public List<Integer> rightViewBfs(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (i == levelSize - 1) {
                    //rightmost node of the level because i is the last node of that level 
                    //which will be seen from right view
                    result.add(currentNode.data);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return result;
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
