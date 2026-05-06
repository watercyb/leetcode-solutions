/*
 * Problem: 3326. Minimum Division Operations to Make Array Non Decreasing
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-division-operations-to-make-array-non-decreasing/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    static int[] meme = new int[1000001];

    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                continue;
            int num = divide(nums[i], nums[i + 1]);
            if (num > nums[i + 1]) {
                return -1;
            }
            nums[i] = num;
            res++;
        }
        return res;
    }

    public int divide(int num, int lim) {
        if (meme[num] != 0)
            return meme[num];
        if (num % 2 == 0)
            return 2;
        if (num % 3 == 0)
            return 3;
        lim = Math.min((int) Math.sqrt(num), lim);
        for (int i = 5; i <= lim; i += 6) {
            if (num % i == 0)
                return meme[num] = i;
            if (num % (i + 2) == 0)
                return meme[num] = i + 2;
        }
        return meme[num] = Integer.MAX_VALUE;
    }
}
