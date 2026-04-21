/*
 * Problem: 1804. Implement Trie II (Prefix Tree)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/implement-trie-ii-prefix-tree/
 * Language: java
 * Date: 2026-04-21
 */

class Trie {
    Node root = new Node();

    public Trie() {

    }

    public void insert(String word) {
        Node node = root;
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                node.next[chr] = new Node();
            node = node.next[chr];
            node.prefixCount++;
        }
        node.currentWordCount++;
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                return 0;
            node = node.next[chr];
        }
        return node.currentWordCount;
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;
        for (char chr : prefix.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                return 0;
            node = node.next[chr];
        }
        return node.prefixCount;
    }

    public void erase(String word) {
        Node node = root;
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            if (node.next[chr].prefixCount == 1) {
                node.next[chr] = null;
                return;
            }
            node = node.next[chr];
            node.prefixCount--;
        }
        node.currentWordCount--;
    }
}

class Node {
    int currentWordCount = 0;
    int prefixCount = 0;
    Node[] next = new Node[26];
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
