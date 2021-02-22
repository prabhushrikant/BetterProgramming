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

    //doesn't work
    // public int getHeight2(Node node) 
    // {
    //     if (node == null) {
    //         return 0;
    //     }
    //     return 1 + Math.max(
    //         node.left != null ? getHeight2(node.left) : 0, 
    //         node.right != null ? getHeight2(node.right) : 0);
    // }
    
}
