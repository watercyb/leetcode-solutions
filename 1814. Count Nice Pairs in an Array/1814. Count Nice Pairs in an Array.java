/*
 * Problem: 1814. Count Nice Pairs in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-nice-pairs-in-an-array/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int countNicePairs(int[] nums) {
        int mod = 1_000_000_007;
        for (int i = 0; i < nums.length; i++) {
            int rev = 0;
            int org = nums[i];
            while (org > 0) {
                rev = (rev * 10) + (org % 10);
                org /= 10;
            }
            nums[i] -= rev;
        }
        Arrays.sort(nums);
        int res = 0;
        int count = 0;
        int prv = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == prv) {
                count++;
            } else {
                res = (int) (((long) res + (long) count * (count - 1) / 2) % mod);
                count = 1;
                prv = nums[i];
            }
        }
        res = (int) (((long) res + (long) count * (count - 1) / 2) % mod);
        return res;
    }
}
