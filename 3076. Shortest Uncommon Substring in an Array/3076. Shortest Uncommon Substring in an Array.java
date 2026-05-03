/*
 * Problem: 3076. Shortest Uncommon Substring in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-uncommon-substring-in-an-array/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public String[] shortestSubstrings(String[] arr) {
        TrieNode node = new TrieNode(-1);
        for (int i = 0; i < arr.length; i++) {
            insert(node, arr[i], i);
        }
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = getMin(node, arr[i]);
        }
        return res;
    }

    public String getMin(TrieNode root, String str) {
        char[] chrs = str.toCharArray();
        String res = "{";
        for (int i = 1; i <= chrs.length; i++) {
            if (!res.equals("{"))
                break;
            for (int j = 0; j < chrs.length - i + 1; j++) {
                TrieNode node = root;
                for (int k = 0; k < i; k++) {
                    node = node.next[chrs[j + k] - 'a'];
                }
                if (node.count == 1) {
                    String subStr = str.substring(j, j + i);
                    if (subStr.compareTo(res) < 0)
                        res = subStr;
                }
            }
        }
        if (res.equals("{"))
            return "";
        return res;
    }

    public void insert(TrieNode root, String str, int n) {
        char[] chrs = str.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            TrieNode node = root;
            for (int j = i; j < chrs.length; j++) {
                int idx = chrs[j] - 'a';
                if (node.next[idx] == null) {
                    node.next[idx] = new TrieNode(n);
                    node = node.next[idx];
                } else {
                    node = node.next[idx];
                    if (node.count == 1 && node.last != n)
                        node.count++;
                }
            }
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    int count = 1;
    int last = 0;

    public TrieNode(int last) {
        this.last = last;
    }
}
