/*
 * Problem: 2426. Number of Pairs Satisfying Inequality
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-pairs-satisfying-inequality/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i] - nums2[i] + 20000;
            res += get(num + diff);
            insert(num);
        }
        return res;
    }

    int[] BIT = new int[50002];

    public void insert(int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
