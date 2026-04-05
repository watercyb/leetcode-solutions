/*
 * Problem: 611. Valid Triangle Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-triangle-number/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public int triangleNumber(int[] nums) {
        int[] counts = new int[1001];
        for (int num : nums) {
            counts[num]++;
        }
        int idx = counts[0];
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i;
            }
            counts[i] += counts[i - 1];
        }
        int res = 0;
        for (int i = counts[0]; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum > 1000) {
                    res += counts[1000] - j - 1;
                } else {
                    res += counts[sum - 1] - j - 1;
                }
            }
        }
        return res;
    }
}
