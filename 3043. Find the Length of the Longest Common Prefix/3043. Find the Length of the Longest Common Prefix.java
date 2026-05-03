/*
 * Problem: 3043. Find the Length of the Longest Common Prefix
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        for (int num : arr1) {
            TrieNode node = root;
            for (char chr : String.valueOf(num).toCharArray()) {
                chr -= '0';
                if (node.next[chr] == null)
                    node.next[chr] = new TrieNode();
                node = node.next[chr];
            }
        }
        int res = 0;
        for (int num : arr2) {
            TrieNode node = root;
            int count = 0;
            for (char chr : String.valueOf(num).toCharArray()) {
                chr -= '0';
                if (node.next[chr] == null)
                    break;
                node = node.next[chr];
                count++;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[10];
}
