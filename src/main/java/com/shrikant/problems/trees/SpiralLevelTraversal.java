package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1
public class SpiralLevelTraversal {

    //apprach 1
    //extending the logic of level order traversal but keep a flag to switch order of printing
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

    //Note: Don't fall the fact that because it's a level order traversal and you should use queues, problem is much simpler using stacks 
    //flipping of right to left is inevitable.

    

}
