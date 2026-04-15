/*
 * Problem: 1297. Maximum Number of Occurrences of a Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] chrs = s.toCharArray();
        if (minSize > chrs.length)
            return 0;
        int res = 0;
        TrieNode root = new TrieNode();
        boolean[] seens;
        for (int i = 0; i <= chrs.length - minSize; i++) {
            TrieNode node = root;
            seens = new boolean[26];
            int count = 0;
            int size = 0;
            for (int j = i; j < minSize + i; j++) {
                int idx = chrs[j] - 'a';
                if (!seens[idx]) {
                    seens[idx] = true;
                    if (count++ == maxLetters)
                        break;
                }
                if (node.next[idx] == null)
                    node.next[idx] = new TrieNode();
                node = node.next[idx];
                size++;
                node.count++;
            }
            if (size == minSize && node.count > res)
                res = node.count;
        }
        return res;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    int count = 0;
}
