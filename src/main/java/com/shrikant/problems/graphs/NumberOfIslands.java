package com.shrikant.problems.graphs;

//Can be solved using bfs : https://www.geeksforgeeks.org/islands-in-a-graph-using-bfs/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numberOfIslands = 0;
        for (int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if (grid[row][col] == '1')
                {
                    DFS(row, col, grid, m, n);
                    numberOfIslands++;
                }
            }
        }
        
        return numberOfIslands;
    }
    
    private void DFS(int row, int col, char[][] grid, int m, int n)
    {
        if (row < 0 || col < 0 || row >= m || col >= n)
            return ;
        else
        {
            if (grid[row][col] == '1') 
            {
                grid[row][col] = 'x'; //if not a char grid we can also make it 0,
                
                //if allowed movement in all 8 directions there will 4 more calls to DFS
                DFS(row+1, col, grid, m, n);
                DFS(row, col+1, grid, m, n);
                DFS(row-1, col, grid, m, n);
                DFS(row, col-1, grid, m, n);    
            }
            
        }
    }
}
