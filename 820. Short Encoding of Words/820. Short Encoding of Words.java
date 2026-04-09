/*
 * Problem: 820. Short Encoding of Words
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/short-encoding-of-words/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            char[] chrs = words[i].toCharArray();
            Node node = root;
            boolean newWord = false;
            for (int j = chrs.length - 1; j >= 0; j--) {
                int idx = chrs[j] - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new Node();
                    newWord = true;
                }
                node = node.next[idx];
                if (node.isWord && j != 0) {
                    node.isWord = false;
                    res -= chrs.length - j + 1;
                }
            }
            if (newWord) {
                node.isWord = true;
                res += chrs.length + 1;
            }
        }
        return res;
    }
}

class Node {
    Node[] next = new Node[26];
    boolean isWord = false;
}
