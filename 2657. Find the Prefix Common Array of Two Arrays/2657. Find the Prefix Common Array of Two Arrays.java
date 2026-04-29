/*
 * Problem: 2657. Find the Prefix Common Array of Two Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean[] seens1 = new boolean[51];
        boolean[] seens2 = new boolean[51];
        int count = 0;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (!seens1[A[i]]) {
                seens1[A[i]] = true;
                if (seens2[A[i]])
                    count++;
            }
            if (!seens2[B[i]]) {
                seens2[B[i]] = true;
                if (seens1[B[i]])
                    count++;
            }
            res[i] = count;
        }
        return res;
    }
}
