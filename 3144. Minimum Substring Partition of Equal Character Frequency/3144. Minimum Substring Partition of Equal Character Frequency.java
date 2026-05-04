/*
 * Problem: 3144. Minimum Substring Partition of Equal Character Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-substring-partition-of-equal-character-frequency/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumSubstringsInPartition(String s) {
        char[] chrs = s.toCharArray();
        int[] DP = new int[chrs.length + 1];
        int max = Integer.MAX_VALUE / 2;
        Arrays.fill(DP, max);
        DP[0] = 0;
        for (int i = 0; i < chrs.length; i++) {
            int[] counts = new int[26];
            int maxCount = 0;
            int count = 0;
            for (int j = i; j >= 0; j--) {
                int idx = chrs[j] - 'a';
                counts[idx]++;
                if (counts[idx] > maxCount) {
                    maxCount++;
                    count = 1;
                } else if (counts[idx] == maxCount) {
                    count++;
                }
                if (maxCount * count == i - j + 1)
                    DP[i + 1] = Math.min(DP[j] + 1, DP[i + 1]);
            }
        }
        if (DP[chrs.length] >= max)
            return -1;
        return DP[chrs.length];
    }
}

