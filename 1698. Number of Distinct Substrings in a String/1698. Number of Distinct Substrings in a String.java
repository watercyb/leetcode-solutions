/*
 * Problem: 1698. Number of Distinct Substrings in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-distinct-substrings-in-a-string/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int countDistinct(String s) {
        TrieNode head = new TrieNode();
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            chrs[i] -= 'a';
        }
        int res = 0;
        for (int i = 0; i < chrs.length; i++) {
            TrieNode node = head;
            for (int j = i; j < chrs.length; j++) {
                if (node.next[chrs[j]] == null) {
                    node.next[chrs[j]] = new TrieNode();
                    res++;
                }
                node = node.next[chrs[j]];
            }
        }
        return res;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
}
