/*
 * Problem: 1032. Stream of Characters
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/stream-of-characters/
 * Language: java
 * Date: 2026-04-11
 */

class StreamChecker {
    int[] arr = new int[40000];
    int idx = 0;
    TrieNode head = new TrieNode();

    public StreamChecker(String[] words) {
        for (String word : words) {
            TrieNode node = head;
            char[] chrs = word.toCharArray();
            for (int i = chrs.length - 1; i >= 0; i--) {
                int j = chrs[i] - 'a';
                if (node.next[j] == null)
                    node.next[j] = new TrieNode();
                node = node.next[j];
            }
            node.isWord = true;
        }
    }

    public boolean query(char letter) {
        arr[idx++] = letter - 'a';
        TrieNode node = head;
        int i = idx - 1;
        while (i >= 0) {
            node = node.next[arr[i]];
            if (node == null)
                break;
            if (node.isWord)
                return true;
            i--;
        }
        return false;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    boolean isWord = false;
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
