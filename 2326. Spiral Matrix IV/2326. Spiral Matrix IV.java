/*
 * Problem: 2326. Spiral Matrix IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/spiral-matrix-iv/
 * Language: java
 * Date: 2026-04-26
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] arr : res) {
            Arrays.fill(arr, -1);
        }
        int rLeft = 0;
        int rRight = m - 1;
        int cLeft = 0;
        int cRight = n - 1;
        while (head != null) {
            for (int i = cLeft; i <= cRight && head != null; i++) {
                res[rLeft][i] = head.val;
                head = head.next;
            }
            rLeft++;
            for (int i = rLeft; i <= rRight && head != null; i++) {
                res[i][cRight] = head.val;
                head = head.next;
            }
            cRight--;
            for (int i = cRight; i >= cLeft && head != null; i--) {
                res[rRight][i] = head.val;
                head = head.next;
            }
            rRight--;
            for (int i = rRight; i >= rLeft && head != null; i--) {
                res[i][cLeft] = head.val;
                head = head.next;
            }
            cLeft++;
        }
        return res;
    }
}
