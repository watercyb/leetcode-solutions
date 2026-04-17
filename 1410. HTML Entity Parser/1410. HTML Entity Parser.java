/*
 * Problem: 1410. HTML Entity Parser
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/html-entity-parser/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String entityParser(String text) {
        char[] chrs = text.toCharArray();
        if (root == null) {
            root = new TrieNode();
            String[] strs = { "quot;", "apos;", "amp;", "gt;", "lt;", "frasl;" };
            for (int i = 0; i < strs.length; i++) {
                TrieNode node = root;
                for (char chr : strs[i].toCharArray()) {
                    if (node.next[chr] == null)
                        node.next[chr] = new TrieNode();
                    node = node.next[chr];
                }
                node.idx = i;
            }
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '&') {
                int idx = chk(chrs, root, i + 1);
                if (idx != -1) {
                    SB.append(symbols[idx]);
                    i += lens[idx];
                } else {
                    SB.append(chrs[i]);
                }
            } else {
                SB.append(chrs[i]);
            }
        }
        return SB.toString();
    }

    static TrieNode root;
    char[] symbols = { '\"', '\'', '&', '>', '<', '/' };
    char[] lens = { 5, 5, 4, 3, 3, 6 };

    public int chk(char[] chrs, TrieNode node, int i) {
        while (i < chrs.length) {
            if (node.next[chrs[i]] == null)
                return -1;
            node = node.next[chrs[i]];
            if (node.idx != -1)
                return node.idx;
            i++;
        }
        return -1;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode['z' + 1];
    int idx = -1;
}
