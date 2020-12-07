package com.tree.bst.easy;
//12/06/2020
//Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
//test case:
//Input: root = [5,3,6,2,4,null,7], k = 9
//Output: true
//idea: inorder read bst to get a sorted array. Use two points pointing two ends and compare the sum with the target
// Time: O(n) Space: O(n)
//Other solutions: 1. Recursively traverse the tree and use hashset to check the sum
//2. Use BFS + Hashset
public class TwoSum {

}
