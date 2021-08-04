package com.shrikant.problems.trees;

//program to check given binary tree is a binary search tree.
public class ValidateBST {
    
    public boolean isValidBST(Node root) {
        
        //Check if left substree is BST
        //check if right subtree is BST
        //max from left <= root < min from right subtree
        
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    private boolean isValidBST(Node root, int min, int max) 
    {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data > max) {
            return false;
        }

        return isValidBST(root.left, min, root.data) && 
        isValidBST(root.right, root.data, max);
    }
}
