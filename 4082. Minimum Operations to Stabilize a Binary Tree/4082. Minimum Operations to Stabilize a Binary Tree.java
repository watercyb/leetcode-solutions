/*
 * Problem: 4082. Minimum Operations to Stabilize a Binary Tree
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-stabilize-a-binary-tree/
 * Language: java
 * Date: 2026-10-14
 */

/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
class Solution {
    public long stabilizeBinaryTree(TreeNode root) {
        return dfs(root).minCost;
    }

    private Function dfs(TreeNode node) {
        if (node == null) {
            return new Function();
        }

        // Calculate the cost functions for both subtrees.
        Function left = dfs(node.left);
        Function right = dfs(node.right);

        // Apply the parent-child constraint.
        left.shift();
        right.shift();

        // Merge the smaller function into the larger one.
        if (left.size < right.size) {
            Function temp = left;
            left = right;
            right = temp;
        }

        left.absorb(right);

        // Add the cost of changing the current node's value.
        left.addAbsoluteValue(node.val);
        left.size++;

        return left;
    }

    private static class Function {
        // Left breakpoints: max(p - x, 0).
        PriorityQueue<Long> left = new PriorityQueue<>(Collections.reverseOrder());

        // Right breakpoints: max(x - q, 0).
        PriorityQueue<Long> right = new PriorityQueue<>();

        // Actual breakpoint = stored value + corresponding offset.
        long leftOffset = 0;
        long rightOffset = 0;

        // Minimum value of the represented convex function.
        long minCost = 0;

        // Number of tree nodes represented by this function.
        int size = 0;

        // min_y F(y), where y is in [x - 1, x + 1].
        void shift() {
            leftOffset--;
            rightOffset++;
        }

        void addAbsoluteValue(long a) {
            addLeftBreakpoint(a);
            addRightBreakpoint(a);
        }

        // Add max(a - x, 0).
        void addLeftBreakpoint(long a) {
            if (!right.isEmpty()) {
                long rightMin = right.peek() + rightOffset;

                if (a > rightMin) {
                    right.poll();

                    left.add(rightMin - leftOffset);
                    right.add(a - rightOffset);

                    minCost += a - rightMin;
                    return;
                }
            }

            left.add(a - leftOffset);
        }

        // Add max(x - a, 0).
        void addRightBreakpoint(long a) {
            if (!left.isEmpty()) {
                long leftMax = left.peek() + leftOffset;

                if (a < leftMax) {
                    left.poll();

                    right.add(leftMax - rightOffset);
                    left.add(a - leftOffset);

                    minCost += leftMax - a;
                    return;
                }
            }

            right.add(a - rightOffset);
        }

        // Add another subtree's cost function.
        void absorb(Function other) {
            minCost += other.minCost;

            for (long value : other.left) {
                addLeftBreakpoint(value + other.leftOffset);
            }

            for (long value : other.right) {
                addRightBreakpoint(value + other.rightOffset);
            }

            other.left.clear();
            other.right.clear();

            size += other.size;
        }
    }
}
