/*
 * Problem: 2707. Extra Characters in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/extra-characters-in-a-string/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String str : dictionary) {
            TrieNode node = root;
            for (char chr : str.toCharArray()) {
                chr -= 'a';
                if (node.next[chr] == null)
                    node.next[chr] = new TrieNode();
                node = node.next[chr];
            }
            node.isWord = true;
        }
        return dfs(s.toCharArray(), new int[s.length()], root, 0) - 1;
    }

    public int dfs(char[] chrs, int[] meme, TrieNode root, int i) {
        if (i == chrs.length)
            return 1;
        if (meme[i] != 0)
            return meme[i];
        int j = i;
        TrieNode node = root;
        int res = dfs(chrs, meme, root, j + 1) + 1;
        while (j < chrs.length) {
            int idx = chrs[j] - 'a';
            if (node.next[idx] != null) {
                node = node.next[idx];
                j++;
            } else {
                break;
            }
            if (node.isWord)
                res = Math.min(dfs(chrs, meme, root, j), res);
        }
        return meme[i] = res;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}
