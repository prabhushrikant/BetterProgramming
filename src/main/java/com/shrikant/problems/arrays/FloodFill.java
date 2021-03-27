package com.shrikant.problems.arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        
        int[][] processed = new int[image.length][image[0].length];
        for(int i=0; i < image.length; i++)
            for(int j=0; j < image[0].length; j++)
            {
                processed[i][j] = 0;    
            }
        
        int sourceColor = image[sr][sc];
        return floodFill(image, sr, sc, newColor, processed, sourceColor);
    }
    
    private int[][] floodFill(int[][] image, int sr, int sc, int newColor, int[][] processed, int sourceColor) 
    {
        if (processed[sr][sc] == 1) 
            return image;
        
        image[sr][sc] = newColor;
        processed[sr][sc] = 1;
        
        if (sr-1 >= 0 && image[sr-1][sc] == sourceColor) 
            image = floodFill(image, sr-1, sc, newColor, processed, sourceColor);
        if (sr+1 <= image.length - 1 && image[sr+1][sc] == sourceColor)
            image = floodFill(image, sr+1, sc, newColor, processed, sourceColor); 
        if (sc-1 >= 0 && image[sr][sc-1] == sourceColor)
            image = floodFill(image, sr, sc-1, newColor, processed, sourceColor);
        if (sc+1 <= image[0].length-1 && image[sr][sc+1] == sourceColor)
            image = floodFill(image, sr, sc+1, newColor, processed, sourceColor);
            
        return image;
    }
}
