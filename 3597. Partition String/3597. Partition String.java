/*
 * Problem: 3597. Partition String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-string/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public List<String> partitionString(String s) {
        Node root = new Node();
        Node node = root;
        StringBuilder SB = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (char chr : s.toCharArray()) {
            SB.append(chr);
            chr -= 'a';
            if (node.next[chr] == null) {
                node.next[chr] = new Node();
                node = root;
                res.add(SB.toString());
                SB.setLength(0);
            } else {
                node = node.next[chr];
            }
        }
        return res;
    }
}

class Node {
    Node[] next = new Node[26];
}
