/*
 * Problem: 1885. Count Pairs in Two Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-pairs-in-two-arrays/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = nums1[i] - nums2[i];
            res += get(diff - 1);
            insert(-diff);
        }
        return res;
    }

    int[] BIT = new int[200002];

    public void insert(int i) {
        i += 100001;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i += 100001;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
