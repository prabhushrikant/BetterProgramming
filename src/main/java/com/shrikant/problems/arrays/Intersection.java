package com.shrikant.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arrToStore; int[] arrToIterate;
        List<Integer> result = new ArrayList<Integer>(); 
        
        if (nums1.length <= nums2.length) {
            arrToStore = nums1;
            arrToIterate = nums2;
        } else {
            arrToStore = nums2;
            arrToIterate = nums1;
        } 
        
        for(int i=0; i < arrToStore.length; i++) {
            var value = map.merge(arrToStore[i], 1, (oldValue, newValue) -> oldValue + 1);
        }
        
        for(int i=0; i < arrToIterate.length; i++) {
            if (map.containsKey(arrToIterate[i]) && map.get(arrToIterate[i]) > 0) {
                result.add(arrToIterate[i]);
                Integer value = map.get(arrToIterate[i]);
                map.put(arrToIterate[i], value - 1);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
                
    }
}
