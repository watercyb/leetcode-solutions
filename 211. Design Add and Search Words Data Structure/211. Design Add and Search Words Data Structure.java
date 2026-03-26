/*
 * Problem: 211. Design Add and Search Words Data Structure
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * Language: java
 * Date: 2026-03-26
 */

class WordDictionary {
    TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.next[idx] == null)
                node.next[idx] = new TrieNode();
            node = node.next[idx];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(), root, 0);
    }

    public boolean dfs(char[] chrs, TrieNode node, int i) {
        if (i == chrs.length)
            return node.isWord;
        if (chrs[i] == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.next[(char) j] != null && dfs(chrs, node.next[(char) j], i + 1))
                    return true;
            }
        } else {
            int idx = chrs[i] - 'a';
            if (node.next[idx] != null && dfs(chrs, node.next[idx], i + 1))
                return true;
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
