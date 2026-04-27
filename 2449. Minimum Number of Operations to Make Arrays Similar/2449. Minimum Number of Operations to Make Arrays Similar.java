/*
 * Problem: 2449. Minimum Number of Operations to Make Arrays Similar
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-arrays-similar/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int num : target) {
            max = Math.max(num, max);
        }
        int[] counts1 = new int[max + 1];
        int[] counts2 = new int[max + 1];
        for (int num : nums) {
            counts1[num]++;
        }
        for (int num : target) {
            counts2[num]++;
        }
        return (count(counts1, counts2, 0, 0) + count(counts1, counts2, 1, 1)) / 4;
    }

    public long count(int[] counts1, int[] counts2, int i, int j) {
        long res = 0;
        while (i < counts1.length) {
            while (i < counts1.length && counts1[i] == 0) {
                i += 2;
            }
            if (i >= counts1.length)
                break;
            while (j < counts2.length && counts2[j] == 0) {
                j += 2;
            }
            while (counts1[i] > 0 && counts2[j] > 0) {
                res += Math.abs(i - j);
                counts1[i]--;
                counts2[j]--;
            }
        }
        return res;
    }
}
