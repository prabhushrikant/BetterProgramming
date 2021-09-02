package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
public class SpiralLevelTraversal {

    //apprach 1
    //extending the logic of level order traversal but keep a flag to switch order of printing
    //O(n^2) time
    public ArrayList<Integer> findSpiral(Node root)
    {
        HeightOfTree obj = new HeightOfTree();
        int h = obj.getHeight(root); //assuming tree height starts with 0
        int d = 0;
        boolean flag = false;  //starting from right to left.
        List<Node> result = new ArrayList<>();
        while(d <= h) {
            result.addAll(findSpiral(root, d, flag, new ArrayList<Node>()));
            flag = !flag;
            d++;
        }  
        
        return (ArrayList<Integer>) result.stream().map(x -> x.data).collect(Collectors.toList());
    }

    private ArrayList<Node> findSpiral(Node node, int level, boolean flag, ArrayList<Node> result)
    {
        if (node == null)
            return result;
        if (level == 0) {
            result.add(node);
        }

        if (flag) {
            //print left to right, 
            findSpiral(node.left, level-1, flag, result);
            findSpiral(node.right, level-1, flag, result);
        } else {
            //print right to right, 
            findSpiral(node.right, level-1, flag, result);
            findSpiral(node.left, level-1, flag, result);
        }

        return result;
    }

    //Approach 2 
    //this can also be solved in iterative method using two stacks.
    //keeping one stack for left to right printing nodes.
    //other for right to left printing nodes.
    //O(n) time and O(n) extra space.

    //Note: Don't fall the fact that because it's a level order traversal and you should use queues, problem is much simpler using stacks 
    //flipping of right to left is inevitable.
    public ArrayList<Integer> findSpiral2(Node root)
    {
        Stack<Node> oddStack = new Stack<>();
        Stack<Node> evenStack = new Stack<>();
        int height = new HeightOfTree().getHeight2(root);
        int currHeight = 1;
        List<Node> result = new ArrayList<>();

        if (root != null)
        {
            oddStack.push(root);
        }

        while(currHeight <= height)
        {
            if (currHeight%2 == 1)
            {
                //pop odd stack, push even stack.
                while(!oddStack.isEmpty())
                {
                    Node popped = oddStack.pop();
                    result.add(popped);
                    if (popped.right != null) 
                    {
                        evenStack.push(popped.right);
                    }
                    if (popped.left != null) 
                    {
                        evenStack.push(popped.left);
                    }
                }
            } 
            else
            {   
                //pop even stack, push to odd stack
                while(!evenStack.isEmpty())
                {
                    Node popped = evenStack.pop();
                    result.add(popped);
                    if (popped.left != null) 
                    {
                        oddStack.push(popped.left);
                    }
                    if (popped.right != null) 
                    {
                        oddStack.push(popped.right);
                    }

                }
            } 

            currHeight++;
        }
        
        return (ArrayList<Integer>) result.stream().map(x -> x.data).collect(Collectors.toList());

    }


}
