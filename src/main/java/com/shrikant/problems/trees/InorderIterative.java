package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    
    public List<Integer> inorderIterative(Node root)
    {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        stack.push(root);
        Node curr = root;  
        while(!stack.isEmpty())
        {
            while(curr.left != null)
            {
                stack.push(curr.left);
                curr = curr.left;
            }
            Node popped = stack.pop();
            result.add(popped.data);

            if (popped.right != null)
            {
                stack.push(popped.right);
                curr = popped.right;
            }            
        }

        return result;
    }
    
}
