/*
 * Problem: 1361. Validate Binary Tree Nodes
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/validate-binary-tree-nodes/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] seen = new boolean[n];
        for (int in : leftChild) {
            if (in != -1) {
                if (seen[in])
                    return false;
                seen[in] = true;
            }
        }
        for (int in : rightChild) {
            if (in != -1) {
                if (seen[in])
                    return false;
                seen[in] = true;
            }
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                if (root != -1)
                    return false;
                root = i;
            }
        }
        if (root==-1) return false;
        seen[root] = true;
        dfs(seen, leftChild, rightChild, root);
        for (int i = 0; i < n; i++) {
            if (seen[i])
                return false;
        }
        return true;
    }

    public boolean dfs(boolean[] seen, int[] leftChild, int[] rightChild, int node) {
        if (!seen[node])
            return false;
        seen[node] = false;
        if (leftChild[node] != -1 && !dfs(seen, leftChild, rightChild, leftChild[node]))
            return false;
        if (rightChild[node] != -1 && !dfs(seen, leftChild, rightChild, rightChild[node]))
            return false;
        return true;
    }
}
