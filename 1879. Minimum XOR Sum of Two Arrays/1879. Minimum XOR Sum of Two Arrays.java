/*
 * Problem: 1879. Minimum XOR Sum of Two Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int[] meme = new int[(1 << nums1.length)];
        Arrays.fill(meme, -1);
        meme[meme.length - 1] = 0;
        return dfs(nums1, nums2, meme, 0, 0);
    }

    public int dfs(int[] nums1, int[] nums2, int[] meme, int h, int i) {
        if (meme[h] != -1)
            return meme[h];
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums2.length; j++) {
            if ((h & (1 << j)) == 0)
                res = Math.min(res, dfs(nums1, nums2, meme, h + (1 << j), i + 1) + (nums1[i] ^ nums2[j]));
        }

        return meme[h] = res;
    }
}
