package com.shrikant.problems.trie;

import java.util.Set;

//https://leetcode.com/problems/longest-common-prefix
public class FindLongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        //attach all strings to the trie
        Trie trie = new Trie();
        for(String str : strs) {
            if(str.isEmpty()) {
                return "";
            }
            trie.attach(str);
        }

        StringBuilder lcp = new StringBuilder();
        var node = trie.getOrigin();

        while (node != null && node.size() == 1) {
            Set<Character> childrenKeys = node.keySet();
            if (childrenKeys.size() != 1) {
                return lcp.toString();
            } 
            Character child = childrenKeys.iterator().next();
            lcp.append(String.valueOf(child));
            node = node.get(child);
        }
        return lcp.toString();
    }
}
