package com.shrikant.problems.trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

//Note: trick here is not to process the nodes in zig zag fashion but continue processing them as regular bfs but 
//keep track when the level changes and just print them in reverse order when need them.
public class ZigZagTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        
        int d = new HeightOfTree().getHeight2(root);
        Queue<Node> oddQueue = new LinkedList<>();
        Queue<Node> evenQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        if (root != null);
            oddQueue.add(root);

        int i = 1;
        while(i <= d)
        {
            Node popped;
            List<Integer> innerResult = new ArrayList<Integer>();
            if (i % 2 != 0)
            {
                while(!oddQueue.isEmpty())
                {
                    popped = oddQueue.remove();
                    //fill up the even queue.
                    innerResult.add(popped.data);
                    addToQueue(popped, evenQueue);
                }                
            } 
            else
            {                
               while(!evenQueue.isEmpty())
                {                    
                    popped = evenQueue.remove();
                    innerResult.add(popped.data);
                    //fill up the odd queue.
                    addToQueue(popped, oddQueue);
                }
                
                //print even level nodes in reverse order
                Collections.reverse(innerResult);
            }
        
            result.add(innerResult);
            i++; //process next level
        }
        
        return result;
    }

    private void addToQueue(Node node, Queue<Node> queue)
    {
        if (node.left != null)
        {
            queue.add(node.left);
        }
        if(node.right != null)
        {
            queue.add(node.right);
        }
    }
}
