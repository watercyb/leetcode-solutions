/*
 * Problem: 3485. Longest Common Prefix of K Strings After Removal
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/longest-common-prefix-of-k-strings-after-removal/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] longestCommonPrefix(String[] words, int k) {
        String str1 = "";
        int max1 = 0;
        int max2 = 0;
        Node root = new Node();
        for (String word : words) {
            Node node = root;
            int n = 0;
            int max = 0;
            for (char chr : word.toCharArray()) {
                chr -= 'a';
                if (node.next[chr] == null)
                    node.next[chr] = new Node();
                node = node.next[chr];
                node.count++;
                n++;
                if (node.count >= k)
                    max = n;
            }
            if (max > max1) {
                String str = word.substring(0, max);
                str1 = str;
                max2 = max1;
                max1 = max;
            } else if (max > max2) {
                max2 = max;
            }
        }
        boolean[] isStr1 = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(str1))
                isStr1[i] = true;
        }
        int[] res = new int[words.length];
        for (int i = 0; i < res.length; i++) {
            if (isStr1[i]) {
                res[i] = max2;
            } else {
                res[i] = max1;
            }
        }
        return res;
    }
}

class Node {
    Node[] next = new Node[26];
    int count = 0;

    public Node() {

    }
}
