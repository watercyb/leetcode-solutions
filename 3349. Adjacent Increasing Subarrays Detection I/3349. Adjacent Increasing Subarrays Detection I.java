/*
 * Problem: 3349. Adjacent Increasing Subarrays Detection I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int[] length = new int[nums.size()];
        int prv = nums.get(0);
        int len = 1;
        length[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num > prv) {
                len++;
            } else {
                len = 1;
            }
            if (len >= k && i >= 2 * k - 1 && length[i - k] >= k)
                return true;
            length[i] = len;
            prv = num;
        }
        return false;
    }
}
