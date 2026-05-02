/*
 * Problem: 2936. Number of Equal Numbers Blocks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-equal-numbers-blocks/
 * Language: java
 * Date: 2026-05-02
 */

/**
 * Definition for BigArray.
 * class BigArray {
 *     public BigArray(int[] elements);
 *     public int at(long index);
 *     public long size();
 * }
 */
class Solution {
    public int countBlocks(BigArray nums) {
        return dfs(nums, 0, nums.size() - 1, nums.at(0), nums.at(nums.size() - 1));
    }

    public int dfs(BigArray nums, long l, long r, int vL, int vR) {
        if (vL == vR)
            return 1;
        if (l + 1 == r)
            return 2;
        long mid = (l + r) >>> 1;
        int vM = nums.at(mid);
        return dfs(nums, l, mid, vL, vM) + dfs(nums, mid, r, vM, vR) - 1;
    }
}
