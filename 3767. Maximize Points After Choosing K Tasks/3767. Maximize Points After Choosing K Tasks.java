/*
 * Problem: 3767. Maximize Points After Choosing K Tasks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-points-after-choosing-k-tasks/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        int[] arr = new int[technique1.length];
        long res = 0;
        for (int i = 0; i < technique1.length; i++) {
            arr[i] = technique1[i] - technique2[i];
            res += technique1[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - k; i++) {
            if (arr[i] < 0)
                res -= arr[i];
        }
        return res;
    }
}
