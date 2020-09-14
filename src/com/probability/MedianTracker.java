package com.probability;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an unlimited flow of numbers, keep track of the median of all elements seen so far.

You will have to implement the following two methods for the class

read(int value) - read one value from the flow
median() - return the median at any time, return null if there is no value read so far
Examples

read(1), median is 1
read(2), median is 1.5
read(3), median is 2
read(10), median is 2.5
......
*/
/*
if size is even, median = (the smallest of large half+ the largest of small half)/2
if size is odd, median = value of middle one
 */
public class MedianTracker {
    private PriorityQueue<Integer> largeHalf;
    private PriorityQueue<Integer> smallHalf;
    public MedianTracker() {
        largeHalf = new PriorityQueue<>();
        smallHalf = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void read(int value) {
        if(smallHalf.isEmpty()||value <=smallHalf.peek()){
            smallHalf.offer(value);
        }else{
            largeHalf.offer(value);
        }

        if(largeHalf.size()>smallHalf.size()+1){
            smallHalf.offer(largeHalf.poll());
        }
        if(largeHalf.size()+1<smallHalf.size()){
            largeHalf.offer(smallHalf.poll());
        }
    }

    public Double median() {
        int size = size();
        if(size == 0)
            return null;
        if(size%2 == 0)
            return (double)(largeHalf.peek()+smallHalf.peek())/2;
        else if(largeHalf.size()>smallHalf.size()){
            return (double)largeHalf.peek();
        }else
            return (double)smallHalf.peek();
    }
    private int size(){
        return largeHalf.size()+smallHalf.size();
    }
}
