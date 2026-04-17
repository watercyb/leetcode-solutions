/*
 * Problem: 1428. Leftmost Column with at Least a One
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * Language: java
 * Date: 2026-04-17
 */

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 * public int get(int row, int col) {}
 * public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> tmp = binaryMatrix.dimensions();
        int row = tmp.get(0);
        int col = tmp.get(1);
        int j = col;
        for (int i = 0; i < row; i++) {
            while (j > 0 && binaryMatrix.get(i, j - 1) == 1) {
                j--;
            }
            if (j == 0)
                return 0;
        }
        if (j == col)
            return -1;
        return j;
    }
}
