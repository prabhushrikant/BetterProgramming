package com.shrikant.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

// Algo: Sort the array. Take two elements from the array using two nested loop and take other two elements using two pointer technique.
// Pseudo Code:
// for i in [0, n-4]
//   for j in [i+1, n-3]
//     left=j+1
//     right=n-1
//     while(left < right)
//       if(a[i]+a[j]+a[left]+a[right] == k)
//         //found one quadruplet {i, j, left, right}
//       if(a[i]+a[j]+a[left]+a[right] < k)
//         left++
//       else
//         right--
// Also remember that you need to find unique quadruplets.
public class FourSum {
    

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int sum) {
        // code here
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        Arrays.sort(arr);

        for(int i = 0; i <= arr.length - 4; i++)
        {
            for(int j = i+1; j <= arr.length - 3; j++) 
            {
                var left = j + 1;
                var right = arr.length - 1;

                while(left < right && left <= arr.length - 1 && right > j + 1) {
                    var currSum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (currSum == sum) {
                        result.add(makeResultEntry(arr[i], arr[j], arr[left], arr[right]));
                        left++; 
                        right--;
                    }                         
                    else if (currSum < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return (ArrayList<ArrayList<Integer>>) result.stream().collect(Collectors.toList());
    }

    private ArrayList<Integer> makeResultEntry(int i, int j, int k, int l) {
        ArrayList<Integer> entry = new ArrayList<>();
        var p = 0;
        while (p < 4) {
            switch(p) {
                case 0: {
                    entry.add(i);
                    break; 
                }
                case 1: {
                    entry.add(j); 
                    break; 
                }
                case 2: {
                    entry.add(k); 
                    break; 
                }
                case 3: {
                    entry.add(l);
                    break; 
                }
            }

            p++;
        }

        return entry;
    }
}
