package com.shrikant.problems.trees;

// o(n) approach.
public class DiameterOfTree {
    
    class Ref {
        int val = 0;
    }
    
    int diameter(Node root) {
        // Your code here
        if (root != null && root.left == null && root.right == null)
            return 1;

        Ref r = new Ref();
        diameter(root, r);     
        return r.val;
    }
    
    private int diameter(Node root, Ref r) {
        
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) 
            return 1;
        
        int left = diameter(root.left, r);
        int right = diameter(root.right, r);

        if (left + right + 1 > r.val)
            r.val = left + right + 1; 
            
        int ret = 1 + (left >= right? left : right);
        return ret;
    }
}
