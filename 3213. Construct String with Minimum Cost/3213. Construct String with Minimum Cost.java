/*
 * Problem: 3213. Construct String with Minimum Cost
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/construct-string-with-minimum-cost/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int minimumCost(String target, String[] words, int[] costs) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i], costs, i);
        }
        getSides(root);
        char[] chrs = target.toCharArray();
        int[] DP = new int[chrs.length + 1];
        TrieNode current = root;
        for (int i = 0; i < chrs.length; i++) {
            DP[i + 1] = Integer.MAX_VALUE / 2;
            int idx = chrs[i] - 'a';
            while (current != root && current.next[idx] == null) {
                current = current.side;
            }
            if (current.next[idx] == null)
                return -1;
            current = current.next[idx];
            TrieNode node = current;
            if (node.idx == -1)
                node = node.side_endOfWord;
            while (node != root) {
                DP[i + 1] = Math.min(DP[i + 1 - words[node.idx].length()] + costs[node.idx],
                        DP[i + 1]);
                node = node.side_endOfWord;
            }
        }
        if (DP[chrs.length] == Integer.MAX_VALUE / 2)
            return -1;
        return DP[chrs.length];
    }

    public void insert(TrieNode node, String word, int[] costs, int i) {
        for (char chr : word.toCharArray()) {
            chr -= 'a';
            if (node.next[chr] == null)
                node.next[chr] = new TrieNode();
            node = node.next[chr];
        }
        if (node.idx == -1 || costs[node.idx] > costs[i])
            node.idx = i;
    }

    public void getSides(TrieNode root) {
        Queue<TrieNode> Qu = new LinkedList<>();
        Qu.offer(root);
        root.side = root;
        root.side_endOfWord = root;
        while (!Qu.isEmpty()) {
            TrieNode current = Qu.poll();
            for (int i = 0; i < 26; i++) {
                if (current.next[i] == null)
                    continue;
                if (current == root) {
                    current.next[i].side = root;
                } else {
                    TrieNode sideParent = current.side;
                    while (sideParent != root && sideParent.next[i] == null) {
                        sideParent = sideParent.side;
                    }
                    if (sideParent.next[i] != null) {
                        current.next[i].side = sideParent.next[i];
                    } else {
                        current.next[i].side = root;
                    }
                }
                if (current.next[i].side.idx >= 0) {
                    current.next[i].side_endOfWord = current.next[i].side;
                } else {
                    current.next[i].side_endOfWord = current.next[i].side.side_endOfWord;
                }
                Qu.offer(current.next[i]);
            }
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    TrieNode side;
    TrieNode side_endOfWord;
    int idx = -1;
}
