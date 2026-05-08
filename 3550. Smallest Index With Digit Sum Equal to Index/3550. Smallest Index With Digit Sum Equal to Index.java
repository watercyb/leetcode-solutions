/*
 * Problem: 3550. Smallest Index With Digit Sum Equal to Index
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/smallest-index-with-digit-sum-equal-to-index/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            if (sum == i)
                return i;
        }
        return -1;
    }
}
