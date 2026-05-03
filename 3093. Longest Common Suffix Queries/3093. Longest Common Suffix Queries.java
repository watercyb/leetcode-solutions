/*
 * Problem: 3093. Longest Common Suffix Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-common-suffix-queries/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode node = new TrieNode();
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(node, wordsContainer[i], i);
        }
        int[] res = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            res[i] = get(node, wordsQuery[i]);
        }
        return res;
    }

    public int get(TrieNode node, String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            int j = str.charAt(i) - 'a';
            if (node.next[j] == null)
                return node.idx;
            node = node.next[j];
        }
        return node.idx;
    }

    public void insert(TrieNode node, String str, int idx) {
        int length = str.length();
        if (length < node.length) {
            node.length = length;
            node.idx = idx;
        }
        for (int i = length - 1; i >= 0; i--) {
            int j = str.charAt(i) - 'a';
            if (node.next[j] == null)
                node.next[j] = new TrieNode(length, idx);
            node = node.next[j];
            if (length < node.length) {
                node.length = length;
                node.idx = idx;
            }
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    int length = Integer.MAX_VALUE;
    int idx = -1;

    public TrieNode() {
    }

    public TrieNode(int length, int idx) {
        this.length = length;
        this.idx = idx;
    }
}
