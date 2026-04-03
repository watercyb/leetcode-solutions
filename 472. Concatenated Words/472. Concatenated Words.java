/*
 * Problem: 472. Concatenated Words
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/concatenated-words/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words) {
            char[] chrs = word.toCharArray();
            insert(chrs);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            char[] chrs = word.toCharArray();
            if (dfs(new boolean[chrs.length], chrs, head, 0))
                res.add(word);
        }
        return res;
    }

    TrieNode head = new TrieNode();

    public void insert(char[] chrs) {
        TrieNode node = head;
        for (char chr : chrs) {
            int tmp = chr - 'a';
            if (node.next[tmp] == null)
                node.next[tmp] = new TrieNode();
            node = node.next[tmp];
        }
        node.isWord = true;
    }

    public boolean dfs(boolean[] seens, char[] chrs, TrieNode node, int i) {
        if (i == chrs.length)
            return node.isWord;
        if (seens[i])
            return false;
        seens[i] = true;
        node = head;
        int j = i;
        while (j < chrs.length && node.next[chrs[j] - 'a'] != null) {
            node = node.next[chrs[j] - 'a'];
            if (j - i + 1 < chrs.length && node.isWord && dfs(seens, chrs, node, j + 1))
                return true;
            j++;
        }
        return false;
    }
}

class TrieNode {
    boolean isWord = false;
    TrieNode[] next = new TrieNode[26];

    public TrieNode() {

    }
}
