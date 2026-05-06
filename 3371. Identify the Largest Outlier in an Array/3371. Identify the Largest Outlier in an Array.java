/*
 * Problem: 3371. Identify the Largest Outlier in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int getLargestOutlier(int[] nums) {
        int sum = 0;
        int[] counts = new int[2001];
        for (int num : nums) {
            sum += num;
            counts[num + 1000]++;
        }
        for (int i = 1000; i >= -1000; i--) {
            if (counts[i + 1000] == 0 || ((sum - i) & 1) == 1)
                continue;
            int idx = (sum - i) / 2;
            if (idx < -1000 || idx > 1000)
                continue;
            if (counts[idx + 1000] >= 2 || (idx != i && counts[idx + 1000] > 0))
                return i;
        }
        return -1;
    }
}
