/*
 * Problem: 2404. Most Frequent Even Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/most-frequent-even-element/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int mostFrequentEven(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max / 2 + 1];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                continue;
            int tmp = nums[i] / 2;
            counts[tmp]++;
            if (counts[tmp] > counts[res] || (counts[tmp] == counts[res] && tmp < res))
                res = tmp;
        }
        if (counts[res] == 0)
            return -1;
        return res * 2;
    }
}
