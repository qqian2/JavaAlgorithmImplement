package com.string.easy;
/*
12/15/2020 Leetcode 415
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
test case:
num1: "97"
num2: "9"
return: "106"

Best Approach: use a carry for storing one to front position, read string from end
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1--) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2--) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
        }

        return res.reverse().toString();
    }
}
