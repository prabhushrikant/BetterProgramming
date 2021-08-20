package com.shrikant.problems.generic;

public class BestBuy {
    
    public int highestScore(int[] number)
    {
        validateInput(number);
        int result = 0;
        int[] map = new int[10];

        for(int pos=0 ; pos < number.length; pos++)
        {   
            ++map[number[pos]];  
        }

        //calculate score from map
        int firstSum = -1;
        int secondSum = -1;
        for(int pos=9; pos >= 0 && (firstSum == -1 || secondSum == -1); pos--)
        {
            if (map[pos] > 1)
            {
                if (firstSum == -1) {
                    firstSum = getSum(map[pos] / 2, pos);
                } else if(secondSum == -1) {
                    secondSum = getSum(map[pos] / 2, pos);
                }                
            } 
        }

        if (firstSum > -1) 
        {
            result += firstSum;
        } 
        if (secondSum > -1) 
        {
            result += secondSum;
        }
        return result;
    }

    private int getSum(int times, int num)
    {
        int i = 0;
        int sum = 0; 
        while(i <= times) {
            sum += num;
            i++;
        }

        return sum;
    }

    private void validateInput(int[] number) {
        for (int i = 0; i < number.length; i++)
        {
            if (i < 0 && i > 9) {
                throw new IllegalArgumentException("Invalid input received.");
            }   
        }
    }
    
}
