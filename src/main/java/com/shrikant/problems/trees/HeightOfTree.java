package com.shrikant.problems.trees;

public class HeightOfTree {

    public int getHeight(Node node) 
    {
        if (node.left != null && node.right != null) {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        } else if (node.left != null) {
            return 1 + getHeight(node.left);    
        } else if(node.right != null) {
            return 1 + getHeight(node.right);
        } else {
            return 0;
        }
    }

    //when you want height starting from 1 instead of zero
    //   5
    //  /
    // 4
    // is considered height of 2 instead of 1.
    public int getHeight2(Node node) 
    {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight2(node.left), getHeight2(node.right));
    }
    
}
