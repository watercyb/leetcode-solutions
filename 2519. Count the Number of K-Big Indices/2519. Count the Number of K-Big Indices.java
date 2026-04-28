/*
 * Problem: 2519. Count the Number of K-Big Indices
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-the-number-of-k-big-indices/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int kBigIndices(int[] nums, int k) {
        BIT = new int[nums.length + 2];
        int[] left = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i] + 1);
            left[i] = get(nums[i]);
        }
        BIT = new int[nums.length + 2];
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            insert(nums[i] + 1);
            if (left[i] >= k && get(nums[i]) >= k)
                res++;
        }
        return res;
    }

    int[] BIT;

    public void insert(int i) {
        while (i < BIT.length) {
            BIT[i]++;
            i += (i & -i);
        }
    }

    public int get(int i) {
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= (i & -i);
        }
        return res;
    }
}
