package com.shrikant.problems.arrays;

public class RottenTomatoes {

    public int tomotoesRotting(int[][] grid) {

        int timeToRotAll = 0;
        boolean hasNewInfections = false;
        int rows = grid.length;
        int cols = grid[0].length;

        do {
            hasNewInfections = false;
            int[][] temp = copy(grid); 
            for(int r=0; r < rows; r++){
                for(int c=0; c < cols; c++) {
                    if (grid[r][c] == 2) {
                       if(infect(r,c, temp)) {
                         hasNewInfections = true;   
                       }
                    }
                }
            }
            grid = temp;
            if (hasNewInfections) {
                timeToRotAll++;
            }
        } while(hasNewInfections);

        //this check is needed because there can be no new infections when there is an isolated tomato
        //where infection can't reach. This loop checks for that tomatoe to give out final verdict.
        if (!allAreRotten(grid)) {
            return -1;
        } 

        return timeToRotAll;
    }

    private boolean allAreRotten(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int r=0; r < rows; r++){
            for(int c=0; c < cols; c++) {
                if (grid[r][c] == 1) {
                   return false;
                }
            }
        }

        return true;
    }

    private int[][] copy(int[][] source) {
        int rows = source.length;
        int cols = source[0].length;

        int[][] newSource = new int[rows][cols];
        for(int r=0; r < rows; r++){
            for(int c=0; c < cols; c++) {
                newSource[r][c] = source[r][c];
            }
        }

        return newSource;
    }

    private boolean infect(int r, int c, int[][] temp) {
        boolean newInfection = false;
        int rows = temp.length;
        int cols = temp[0].length;

        if ((r-1 >= 0 && temp[r-1][c] == 1)) {
            temp[r-1][c] = 2; 
            newInfection = true;
        } 
        if (r+1 <= rows-1 && temp[r+1][c] == 1) {
            temp[r+1][c] = 2; 
            newInfection = true;    
        }
        if (c-1 >= 0 && temp[r][c-1] == 1) {
            temp[r][c-1] = 2; 
            newInfection = true;    
        } 
        if (c+1 <= cols-1 && temp[r][c+1] == 1) { 
            temp[r][c+1] = 2; 
            newInfection = true;
        }

        return newInfection;
    }
    
}
