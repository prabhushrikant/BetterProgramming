package com.shrikant.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.shrikant.problems.utils.Pair;

public class ValidateSuDoKu {

    public boolean validateSoDoKu(int[][] board) {

        ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> cols = new ArrayList<HashSet<Integer>>();
        HashMap<Pair, HashSet<Integer>> subSquares = new HashMap<>();

        //populate arrayLists with empty hashsets.
        for(int i = 0; i < 9; i++) {
            rows.add(i, new HashSet<Integer>());
            cols.add(i, new HashSet<Integer>());            
        }

        //populate hashmap with empty hashsets.
        for(int i=0; i < 9; i++)
            for(int j=0; j < 9; j++) {
                Pair pair = new Pair(i/3, j/3);
                subSquares.put(pair, subSquares.getOrDefault(pair, new HashSet<>()));
            }
        
        //start validating
        for(int r=0; r < 9; r++)
            for(int c=0; c < 9; c++) {
                if (board[r][c] == -1) 
                    continue;

                Pair pair = new Pair(r/3, c/3);    
                if (rows.get(r).contains(board[r][c]) || 
                    cols.get(c).contains(board[r][c]) ||
                    subSquares.get(pair).contains(board[r][c]))
                    return false;
                
                //update hashsets.    
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                HashSet<Integer> set = subSquares.get(pair);
                set.add(board[r][c]);                 
            }

        return true;
    }
}
