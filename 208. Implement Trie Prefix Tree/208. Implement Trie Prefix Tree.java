/*
 * Problem: 208. Implement Trie (Prefix Tree)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 * Language: java
 * Date: 2026-03-26
 */

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                node.next[chr] = new TrieNode();
            node = node.next[chr];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                return false;
            node = node.next[chr];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char chr : prefix.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                return false;
            node = node.next[chr];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
