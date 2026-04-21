/*
 * Problem: 1858. Longest Word With All Prefixes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-word-with-all-prefixes/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insert(root, word);
        }
        dfs(root);
        return res;
    }

    String res = "";

    public void insert(TrieNode node, String word) {
        char[] chrs = word.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            int idx = chrs[i] - 'a';
            if (node.next[idx] == null)
                node.next[idx] = new TrieNode();
            node = node.next[idx];
        }
        node.word = word;
    }

    public void dfs(TrieNode node) {
        if (node.word.length() > res.length())
            res = node.word;
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null && !node.next[i].word.isEmpty())
                dfs(node.next[i]);
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word = "";
}
