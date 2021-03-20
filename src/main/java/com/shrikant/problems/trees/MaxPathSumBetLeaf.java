package com.shrikant.problems.trees;

//https://practice.geeksforgeeks.org/problems/maximum-path-sum/1
public class MaxPathSumBetLeaf {
    
    int maxPathSumBetLeaf = Integer.MIN_VALUE;

    public int getMaxPathSumBetLeaf(Node root) {

        getMaxPathSumBetLeaf(root, Integer.MIN_VALUE);

        return maxPathSumBetLeaf;
    }

    private int getMaxPathSumBetLeaf(Node node, int maxRootToLeaf) {

        if (isLeaf(node))
            return node.data;
            
        int leftMaxSum = Integer.MIN_VALUE;
        int rightMaxSum = Integer.MIN_VALUE;

        if (node.left != null) 
            leftMaxSum = getMaxPathSumBetLeaf(node.left, maxRootToLeaf);    
        if (node.right != null)
            rightMaxSum = getMaxPathSumBetLeaf(node.right, maxRootToLeaf);    

        //Please note that either leftMaxSum or rightMaxSum can be MIN_VALUE at a time but not both since that would mean it's a leaf node, check for which is done at very first.
        
        //Also node that adding any value to MIN_VALUE converts it into positive infinity i.e. to avoid integer overflow. 
        if (leftMaxSum == Integer.MIN_VALUE) {
            maxRootToLeaf = node.data + rightMaxSum;
        } else if (rightMaxSum == Integer.MIN_VALUE) {
            maxRootToLeaf = node.data + leftMaxSum;
        } else if (node.data + leftMaxSum >= node.data + rightMaxSum) {
            maxRootToLeaf = node.data + leftMaxSum;
        } else {
            maxRootToLeaf = node.data + rightMaxSum;
        }
        
        if (leftMaxSum > Integer.MIN_VALUE && 
            rightMaxSum > Integer.MIN_VALUE && 
            leftMaxSum + node.data + rightMaxSum > maxPathSumBetLeaf) {
                maxPathSumBetLeaf = leftMaxSum + node.data + rightMaxSum;
        }

        return maxRootToLeaf;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

}
