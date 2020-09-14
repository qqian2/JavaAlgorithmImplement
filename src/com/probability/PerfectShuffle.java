package com.probability;
/*
Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.
    Java.lang.Math.random() randomly generate a num between [0,1)
    when switch the random index is picking from Math.random()*i (i is from array.length)
 */
public class PerfectShuffle {
    public void shuffle(int[] array) {
        if(array == null || array.length <= 1)
            return;
        //from right to left,
        //for index i-1, randomly pick one of the first i elements
        for(int i = array.length;i>=1;i--){
            int random = (int)(Math.random()*i);
            swap(array,i-1, random);
        }
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args){
        PerfectShuffle test = new PerfectShuffle();
        int[] arr = new int[]{1,3,4,5,6,7,8,12};
        test.shuffle(arr);
        for(int a: arr)
            System.out.println(a);
    }
}