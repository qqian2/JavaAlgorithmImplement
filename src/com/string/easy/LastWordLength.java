package com.string.easy;
/*
12/13/2020 Leetcode 58
Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
A word is a maximal substring consisting of non-space characters only.

test case:
Input: s = "Hello World"
Output: 5

Best approach: count from back and stop when meet the space T O(N) S O(1)
Built-in String Functions: trim(), split(), lastIndexOf()  T O(N) S O(N)
 */
public class LastWordLength {
    public int lengthOfLastWord1(String s) {
        int p = s.length(), length = 0;
        while (p > 0) {
            p--;
            // we're in the middle of the last word
            if (s.charAt(p) != ' ') {
                length++;
            }
            // here is the end of last word
            else if (length > 0) {
                return length;
            }
        }
        return length;
    }
    public int lengthOfLastWord2(String s) {
        s = s.trim();  // trim the trailing spaces in the string
        return s.length() - s.lastIndexOf(" ") - 1;
    }
}
