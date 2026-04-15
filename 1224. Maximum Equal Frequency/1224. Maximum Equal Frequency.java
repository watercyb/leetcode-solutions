/*
 * Problem: 1224. Maximum Equal Frequency
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-equal-frequency/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maxEqualFreq(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        max = 0;
        for (int num : nums) {
            if (++counts[num] > max)
                max = counts[num];
        }
        int[] freqs = new int[max + 1];
        for (int count : counts) {
            freqs[count]++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int count = counts[nums[i]];
            int freq = freqs[count];
            int len = count * freq;
            if (i < nums.length - 1 && len == i + 1)
                return i + 2;
            if (len == i || (count + 1 < freqs.length && freqs[count + 1] == 1 && count * (freq + 1) == i))
                return i + 1;
            freqs[counts[nums[i]]]--;
            counts[nums[i]]--;
            freqs[counts[nums[i]]]++;
        }
        return 1;
    }
}
