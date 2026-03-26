/*
 * Problem: 139. Word Break
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/word-break/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String str : wordDict) {
            TrieNode node = root;
            for (char chr : str.toCharArray()) {
                chr -= 'a';
                if (node.next[chr] == null)
                    node.next[chr] = new TrieNode();
                node = node.next[chr];
            }
            node.isWord = true;
        }
        return dfs(s.toCharArray(), new boolean[s.length()], root, 0);
    }

    public boolean dfs(char[] chrs, boolean[] meme, TrieNode root, int i) {
        if (i == chrs.length)
            return true;
        if (meme[i])
            return false;
        meme[i] = true;
        int j = i;
        TrieNode node = root;
        while (j < chrs.length) {
            int idx = chrs[j] - 'a';
            if (node.next[idx] != null) {
                node = node.next[idx];
                j++;
            } else {
                break;
            }
            if (node.isWord && dfs(chrs, meme, root, j))
                return true;
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}
