/*
 * Problem: 1597. Build Binary Expression Tree From Infix Expression
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/build-binary-expression-tree-from-infix-expression/
 * Language: java
 * Date: 2026-04-18
 */

/**
 * Definition for a binary tree node.
 * class Node {
 * char val;
 * Node left;
 * Node right;
 * Node() {this.val = ' ';}
 * Node(char val) { this.val = val; }
 * Node(char val, Node left, Node right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public Node expTree(String s) {
        return dfs(s.toCharArray(), 0, s.length() - 1, false);
    }

    int idx = 0;

    public Node dfs(char[] chrs, int l, int r, boolean prv) {
        if (idx == r)
            return new Node(chrs[idx++]);
        Node node = new Node('@');
        while (idx <= r) {
            if (Character.isDigit(chrs[idx])) {
                if (node.val == '@') {
                    node.val = chrs[idx];
                } else {
                    node.right = new Node(chrs[idx]);
                }
            } else if (chrs[idx] == '+' || chrs[idx] == '-') {
                if (!prv) {
                    node = new Node(chrs[idx++], node, dfs(chrs, l, r, true));
                    idx--;
                } else {
                    return node;
                }
            } else if (chrs[idx] == '(') {
                int i = idx;
                int count = 1;
                while (count > 0) {
                    i++;
                    if (chrs[i] == '(') {
                        count++;
                    } else if (chrs[i] == ')') {
                        count--;
                    }
                }
                idx++;
                if (node.val == '@') {
                    node = dfs(chrs, idx + 1, i - 1, false);
                } else {
                    node.right = dfs(chrs, idx + 1, i - 1, false);
                }
                idx = i;
            } else {
                node = new Node(chrs[idx], node, null);
            }
            idx++;
        }
        return node;
    }
}
