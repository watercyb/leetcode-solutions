/*
 * Problem: 1628. Design an Expression Tree With Evaluate Function
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/
 * Language: java
 * Date: 2026-04-19
 */

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree representing it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Deque<TreeNode> Dq = new ArrayDeque<>();
        for (int i = 0; i < postfix.length; i++) {
            if (Character.isDigit(postfix[i].charAt(0))) {
                Dq.offerLast(new TreeNode(Integer.valueOf(postfix[i])));
            } else {
                TreeNode right = Dq.pollLast();
                TreeNode left = Dq.pollLast();
                Dq.offerLast(new TreeNode(postfix[i], left, right));
            }
        }
        return Dq.pollLast();
    }
};

class TreeNode extends Node {
    String oprater;
    int val;
    boolean isDigit = false;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
        isDigit = true;
    }

    public TreeNode(String oprater, TreeNode left, TreeNode right) {
        this.oprater = oprater;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        return dfs(this);
    }

    public int dfs(TreeNode node) {
        if (node.isDigit)
            return node.val;
        int left = dfs(node.left);
        int right = dfs(node.right);
        switch (node.oprater) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }
        return 0;
    }
}

/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
