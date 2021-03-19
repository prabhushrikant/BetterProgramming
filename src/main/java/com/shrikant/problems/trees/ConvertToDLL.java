package com.shrikant.problems.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Convert the given binary tree's inorder traversal to doubly linked list.
//i.e converted doubly linked list should have nodes arranged in same way as inorder traversal of the given tree.
//You should use left pointer = prev pointer and right point = next pointer
//Try doing it in-place 
//Try doing it without in-place (extra space) (do inorder traversal, store results in list , move through the list and adjust pointers)
//https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
public class ConvertToDLL {

    //todo: try to avoid using global variables but use method variables.
    Node head = null;
    Node tail = null;

    public ArrayList<Integer> convert(Node root) {
    
        convert2(root);

        List<Node> result = new ArrayList<>();
        while(head != null) {
            result.add(head);
            head = head.right;
        }
        return (ArrayList<Integer>)result.stream().map(x -> x.data).collect(Collectors.toList());
    }

    private void convert2(Node node) {

        if (node == null) {
            return;
        }

        convert2(node.left);
        
        if (head == null) {
            head = node;
        }

        if (tail != null) {
            tail.right = node;
            node.left = tail;            
        }

        tail = node;  

        convert2(node.right);
    }
    
}
