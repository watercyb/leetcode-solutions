/*
 * Problem: 3Sum With Multiplicity
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/3sum-with-multiplicity/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int[] counts = new int[101];
        for (int num : arr) {
            counts[num]++;
        }
        long res = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0)
                continue;
            int l = Math.max(i, target - i - 100);
            int r = Math.min((target - i) / 2 + 1, counts.length);
            for (int j = l; j < r; j++) {
                if (counts[j] == 0 || counts[target - i - j] == 0)
                    continue;
                int k = target - i - j;
                if (i == j && j == k) {
                    res += (long) counts[i] * (counts[j] - 1) * (counts[k] - 2) / 6;
                } else if (i == j) {
                    res += (long) counts[i] * (counts[j] - 1) * counts[k] / 2;
                } else if (j == k || i == k) {
                    res += (long) counts[i] * counts[j] * (counts[k] - 1) / 2;
                } else {
                    res += (long) counts[i] * counts[j] * counts[k];
                }
            }
        }
        return (int) (res % 1_000_000_007);
    }
}
