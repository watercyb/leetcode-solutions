/*
 * Problem: 2966. Divide Array Into Arrays With Max Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length / 3;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int[][] res = new int[n][3];
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j < counts[i]; j++) {
                res[idx1][idx2] = i;
                if (i - res[idx1][0] > k)
                    return new int[0][0];
                if (idx2 == 2) {
                    idx1++;
                    idx2 = 0;
                } else {
                    idx2++;
                }
            }
        }
        return res;
    }
}
