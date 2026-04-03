/*
 * Problem: 425. Word Squares
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/word-squares/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        char[][] chrs = new char[words.length][];
        for (int i = 0; i < words.length; i++) {
            chrs[i] = words[i].toCharArray();
        }
        TrieNode root = new TrieNode();
        for (int i = 0; i < chrs.length; i++) {
            TrieNode node = root;
            for (char chr : chrs[i]) {
                chr -= 'a';
                if (node.next[chr] == null) {
                    node.next[chr] = new TrieNode();
                    node.list.add((int) chr);
                }
                node = node.next[chr];
            }
            node.idx = i;
        }
        dfs(chrs, new int[chrs[0].length][chrs[0].length], root, new int[chrs[0].length], 0, 0, words, root);
        return res;
    }

    List<List<String>> res = new ArrayList<>();

    public void dfs(char[][] chrs, int[][] meme, TrieNode node, int[] arr, int i, int j, String[] words,
            TrieNode root) {
        if (i == meme.length) {
            List<String> list = new ArrayList<>();
            for (int k = 0; k < arr.length; k++) {
                list.add(words[arr[k]]);
            }
            res.add(list);
            return;
        }
        if (j == 0) {
            for (int k = 0; k < i; k++) {
                node = node.next[meme[i][k]];
                j++;
                if (node == null)
                    return;
            }
        }
        for (int next : node.list) {
            if (node.next[next] != null) {
                meme[j][i] = next;
                if (j == meme.length - 1) {
                    arr[i] = node.next[next].idx;
                    dfs(chrs, meme, root, arr, i + 1, 0, words, root);
                } else {
                    dfs(chrs, meme, node.next[next], arr, i, j + 1, words, root);
                }
            }
        }
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    List<Integer> list = new ArrayList<>();
    int idx = -1;
}
