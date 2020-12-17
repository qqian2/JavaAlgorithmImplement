package com.string.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
12/15/2020 Leetcode 205
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
testcase:
Input: s = "egg", t = "add"
Output: true

Input: s = "foo", t = "bar"
Output: false

Approach1: HashMap for maping character from s to t. HashSet for checking mapped character in t.
Approach2: Map both s and t to Integer Pattern. Compare two patterns.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic1(String s, String t) {
        if(s == null) return t == null;
        if(t == null) return false;
        if(s.length() != t.length()) return false;
        if(s.length() == 0) return true;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            Character cur = s.charAt(i);
            Character mappedcur = map.get(cur);
            if(mappedcur == null){
                if(mapped.contains(t.charAt(i)))
                    return false;
                map.put(cur, t.charAt(i));
                mapped.add(t.charAt(i));
            }else{
                if(mappedcur != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sVals = getIntegerPattern(s);
        int[] tVals = getIntegerPattern(t);

        for (int i = 0; i < sVals.length; ++i) {
            if (sVals[i] != tVals[i]) {
                return false;
            }
        }

        return true;
    }

    private int[] getIntegerPattern(String s) {
        int[] pattern = new int[s.length()];

        int uniqueCharId = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char sc = s.charAt(i);
            Integer charId = map.get(sc);
            if (charId == null) {
                map.put(sc, ++uniqueCharId);
                charId = uniqueCharId;
            }
            pattern[i] = charId;
        }

        return pattern;
    }
}
