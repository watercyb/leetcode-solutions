/*
 * Problem: 2781. Length of the Longest Valid Substring
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/length-of-the-longest-valid-substring/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        char[] chrs = word.toCharArray();
        TrieNode node = new TrieNode();
        for (String str : forbidden) {
            insert(node, str);
        }
        int l = chrs.length - 1;
        int r = chrs.length;
        int res = 0;
        while (l >= 0) {
            r = find(node, chrs, l, r);
            res = Math.max(r - l, res);
            l--;
        }
        return res;
    }

    public int find(TrieNode node, char[] chrs, int l, int r) {
        while (l < r) {
            node = node.next[chrs[l] - 'a'];
            if (node == null)
                return r;
            if (node.isWord)
                return l;
            l++;
        }
        return l;
    }

    public void insert(TrieNode node, String str) {
        for (char chr : str.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                node.next[chr] = new TrieNode();
            node = node.next[chr];
            if (node.isWord)
                return;
        }
        node.isWord = true;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}
