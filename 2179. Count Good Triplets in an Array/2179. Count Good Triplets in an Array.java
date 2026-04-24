/*
 * Problem: 2179. Count Good Triplets in an Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-good-triplets-in-an-array/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        BIT = new int[nums1.length + 2];
        int[] idx = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            idx[nums2[i]] = i;
        }
        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index = idx[nums1[i]];
            int left = get(index);
            int right = nums1.length - 1 - i - index + left;
            res += (long) left * right;
            insert(index);
        }
        return res;
    }

    int[] BIT;

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
