/*
 * Problem: 2170. Minimum Operations to Make the Array Alternating
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minimumOperations(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[][] counts = new int[2][max + 1];
        for (int i = 0; i < nums.length; i++) {
            counts[i & 1][nums[i]]++;
        }
        int max11 = 0;
        int max12 = 1;
        int max21 = 0;
        int max22 = 1;
        for (int i = 0; i <= max; i++) {
            if (counts[0][i] > counts[0][max11]) {
                max12 = max11;
                max11 = i;
            } else if (counts[0][i] > counts[0][max12]) {
                max12 = i;
            }
            if (counts[1][i] > counts[1][max21]) {
                max22 = max21;
                max21 = i;
            } else if (counts[1][i] > counts[1][max22]) {
                max22 = i;
            }
        }
        if (max11 != max21) {
            return nums.length - counts[0][max11] - counts[1][max21];
        } else {
            return nums.length - Math.max(counts[0][max11] + counts[1][max22], counts[0][max12] + counts[1][max21]);
        }
    }
}
