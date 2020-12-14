package com.arrays;

import java.util.TreeSet;

/*
09/24/2020
Leetcode 220b
In the question has the distance of k (slide window), the difference between two nums(sort) -> BST, bucket sort

 */
public class ContainsDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            Integer s = set.ceiling(nums[i]);
            if(s!= null && s<=nums[i]+t)
                return true;
            Integer g = set.floor(nums[i]);
            if(g!= null && nums[i]<= g+t)
                return true;
            set.add(nums[i]);
            if(set.size()>k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,1};
        ContainsDuplicate test = new ContainsDuplicate();
        System.out.println(test.containsNearbyAlmostDuplicate(num, 3, 0));
    }
}
