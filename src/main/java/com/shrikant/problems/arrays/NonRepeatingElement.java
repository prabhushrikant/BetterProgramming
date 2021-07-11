package com.shrikant.problems.arrays;

class NonRepeatingElement 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        return findOnce(arr, n, 0, n-1);
        
    }
    
    int findOnce(int arr[], int n, int s, int e)
    {
        if (e < s) {
            //no such element exists.
            return Integer.MAX_VALUE;
        }
        
        if (s == e) {
            return arr[s];
        }
         
        //be careful here, calculating mid point in second half the array shouldn't give index in first half 
        //hence add start index to it.
        var mid = s + (e - s + 1) / 2;
        
        if (mid % 2 == 0) 
        {
            //check direction 
            if (arr[mid] == arr[mid + 1]) {
                //mid is even, which is also the first occurance, hence element lies on right.
                return findOnce(arr, n, mid + 2, e);
            } 
            else if (arr[mid] == arr[mid - 1])
            {   
                //mid is even, but first occurance is odd, hence element lies on left.
                return findOnce(arr, n, s, mid-2);

            } else {
                //both next and prev item didn't match, this element must be the element we want.
                return arr[mid];
            }
        } 
        else
        {
            //mid is odd.
            
            if (arr[mid] == arr[mid + 1]) 
            {
                //first occurance is odd, element lies on left.
                return findOnce(arr, n, s, mid-1);
            } 
            else if (arr[mid] == arr[mid-1]) 
            {
                //first occurance is even, element lies on right;
                return findOnce(arr, n, mid+1, e);

            } else {
                //both next and prev item didn't match, this element must be the element we want.
                return arr[mid];
            }
        }
    }
}
