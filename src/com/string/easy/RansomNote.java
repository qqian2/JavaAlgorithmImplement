package com.string.easy;

import java.util.HashMap;
import java.util.Map;
/*
12/14/2020 Leetcode 383
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
test case:
Input: ransomNote = "a", magazine = "b"
Output: false

Best approach: one hashmap/array T O(N) S O(1)
Interesting solution: Sorting and remove as stacks T O(NlogN) S O(1)
 */
public class RansomNote {

    // Takes a String, and returns a HashMap with counts of
    // each character.
    private Map<Character, Integer> makeCountsMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount + 1);
        }
        return counts;
    }


    public boolean canConstruct(String ransomNote, String magazine) {

        // Check for obvious fail case.
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Make a counts map for the magazine.
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);

        // For each character in the ransom note:
        for (char c : ransomNote.toCharArray()) {
            // Get the current count for c in the magazine.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);
            // If there are none of c left, return false.
            if (countInMagazine == 0) {
                return false;
            }
            // Put the updated count for c back into magazineCounts.
            magazineCounts.put(c, countInMagazine - 1);
        }

        // If we got this far, we can successfully build the note.
        return true;
    }
}
