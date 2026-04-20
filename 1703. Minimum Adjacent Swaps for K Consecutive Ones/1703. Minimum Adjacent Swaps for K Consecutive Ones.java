/*
 * Problem: 1703. Minimum Adjacent Swaps for K Consecutive Ones
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-adjacent-swaps-for-k-consecutive-ones/
 * Language: java
 * Date: 2026-04-20
 */


class Solution {
    public int minMoves(int[] nums, int k) {
        if (k == 1)
            return 0;
        int sumLeft = 0;
        int countZeroLeft = 0;
        int countOneLeft = 0;
        int l = 0;
        int targetLeft = (k + 1) / 2;
        int sumRight = 0;
        int countZeroRight = 0;
        int countOneRight = 0;
        int targetRight = k - targetLeft;
        while (nums[l] == 0) {
            l++;
        }
        int idx = l;
        while (countOneLeft + nums[idx] < targetLeft) {
            if (nums[idx] == 1) {
                countOneLeft++;
            } else {
                countZeroLeft++;
                sumLeft += countOneLeft;
            }
            idx++;
        }
        int r = idx + 1;
        while (countOneRight < targetRight) {
            if (nums[r] == 1) {
                countOneRight++;
                sumRight += countZeroRight;
            } else {
                countZeroRight++;
            }
            r++;
        }
        int res = sumLeft + sumRight;
        while (r < nums.length) {
            l++;
            sumLeft -= countZeroLeft;
            while (nums[l] == 0) {
                countZeroLeft--;
                l++;
            }
            idx++;
            while (nums[idx] == 0) {
                countZeroLeft++;
                sumLeft += countOneLeft;
                sumRight -= countOneRight;
                countZeroRight--;
                idx++;
            }
            while (r < nums.length && nums[r] == 0) {
                countZeroRight++;
                r++;
            }
            if (r == nums.length)
                break;
            r++;
            sumRight += countZeroRight;
            res = Math.min(sumLeft + sumRight, res);
        }
        return res;
    }
}
