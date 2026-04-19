/*
 * Problem: 1636. Sort Array by Increasing Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-array-by-increasing-frequency/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[] frequencySort(int[] nums) {
        int[] counts = new int[201];
        int max = 0;
        for (int num : nums) {
            counts[num + 100]++;
            max = Math.max(counts[num + 100], max);
        }
        List<Integer>[] lists = new ArrayList[max + 1];
        for (int i = 200; i >= 0; i--) {
            if (counts[i] > 0) {
                if (lists[counts[i]] == null)
                    lists[counts[i]] = new ArrayList<>();
                lists[counts[i]].add(i - 100);
            }
        }
        int[] res = new int[nums.length];
        int idx = 0;
        for (int i = 1; i <= max; i++) {
            if (lists[i] == null)
                continue;
            for (int num : lists[i]) {
                for (int j = 0; j < i; j++) {
                    res[idx++] = num;
                }
            }
        }
        return res;
    }
}
