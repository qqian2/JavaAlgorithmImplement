package com.probability;
/*
Given a random generator random5(), the return value of random5() is 0 - 4 with equal probability. Use random5() to implement random7().

??????????Not quite sure when it needs to be 5*random5()+random5()
 */
public class Random7 {
    public int random7() {
        // write your solution here
        // you can use RandomFive.random5() for generating
        // 0 - 4 with equal probability.
        while(true){
            int random = 5*random5()+random5();
            if(random<21)
                return random%7;
        }
    }

    private int random5() {
        return (int) (Math.random() * 5);
    }
}
