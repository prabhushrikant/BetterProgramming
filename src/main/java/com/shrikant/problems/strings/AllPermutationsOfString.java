package com.shrikant.problems.strings;

public class AllPermutationsOfString {
    
    public void printAllPermutations(String S, int origLength, String result)
	{
        //Approach doesn't work , though looks easy to implement because the only the last permutation gets returned to previous call
        //instead of call permutation
        //from af
	    // if (S.length() == 1) {
	    //     return S;
	    // }
	    // else
	    // {
	    //     String permutation = S;
        //     for(int i=0; i < S.length(); i++)
        //     {
        //         String firstString = String.valueOf(S.charAt(i));
        //         permutation = firstString + printAllPermutations(S.substring(0, i) + S.substring(i + 1, S.length()),
        //                 origLength);
        //         if (permutation.length() == origLength)
        //         {
        //             System.out.println(permutation);
        //         }
        //     }
            
        //     return permutation;
        // }
        

        //Note: This code will generate duplicate entries if there are any characters repeated in input string.
        if (result.length() == origLength)
        {
            System.out.println(result);            
        } 
        else 
        {
            for(int i=0; i < S.length(); i++)
            {
                String firstString = String.valueOf(S.charAt(i));
                printAllPermutations(S.substring(0, i) + S.substring(i + 1, S.length()),
                        origLength, result + firstString);
            }
        }   
	}
}
