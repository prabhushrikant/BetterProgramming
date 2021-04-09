package com.shrikant.problems.trie;

import java.util.HashMap;

public class Trie {

    // implementing a HashMap
    private HashMap<Character, HashMap> origin;
  
    // implementing a zero-argument constructor
    public Trie()
    {
        // creating a new HashMap
        origin = new HashMap<Character, HashMap>();
    }
  
    // implementing another constructor
    // with an array as a parameter
    public Trie(String[] array)
    {
        origin = new HashMap<Character, HashMap>();
        // attaching that array string in the trie
        for (String c : array)
            attach(c);
    }
  
    // attach function to add character to the trie
    public void attach(String str)
    {
        HashMap<Character, HashMap> node = origin;
        int i = 0;
        while (i < str.length()) {
            // if node already contains that key,
            //  we will simply point that node
            if (node.containsKey(str.charAt(i))) {
                node = node.get(str.charAt(i));
            }
            else {
  
                // else we will make a new hashmap with
                // that character and then point it.
                node.put(str.charAt(i),
                         new HashMap<Character, HashMap>());
                node = node.get(str.charAt(i));
            }
            i++;
        }
  
        // putting 0 to end the string
        node.put('\0', new HashMap<Character, HashMap>(0));
    }

    public boolean search(String str)
    {
        HashMap<Character, HashMap> presentNode = origin;
        int i = 0;
        while (i < str.length()) {
  
            // will search for that character if it exists
            if (presentNode.containsKey(str.charAt(i))) {
                presentNode = presentNode.get(str.charAt(i));
            }
            else {
                // if the character does not exist
                // that simply means the whole string
                // will also not exists, so we will
                // return false if we find a character
                // which is not found in the hash trie
                return false;
            }
            i++;
        }
        // this will check for the end string,
        // and if the whole string is found,
        // it will return true else false
        if (presentNode.containsKey('\0')) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
