/*
 * Problem: 2972. Count the Number of Incremovable Subarrays II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int j = nums.length - 1;
        while (j > 0 && nums[j - 1] < nums[j]) {
            j--;
        }
        if (j == 0)
            return (1l + nums.length) * nums.length / 2;
        int sum = nums.length + 1;
        long res = sum - j;
        int prv = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > prv) {
                while (j < nums.length && nums[j] <= nums[i]) {
                    j++;
                }
                res += sum - j;
                prv = nums[i];
            } else {
                break;
            }
        }
        return res;
    }
}
