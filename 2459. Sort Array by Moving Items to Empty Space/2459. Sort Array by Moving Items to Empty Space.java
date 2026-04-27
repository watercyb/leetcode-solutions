/*
 * Problem: 2459. Sort Array by Moving Items to Empty Space
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sort-array-by-moving-items-to-empty-space/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int sortArray(int[] nums) {
        return Math.min(getCount(nums.clone(), 0), getCount(nums, 1));
    }

    public int getCount(int[] nums, int offSet) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + offSet) {
                int idx = i;
                res++;
                while (nums[idx] != idx + offSet) {
                    int tmp = idx;
                    idx = nums[tmp] - offSet;
                    if (idx != -offSet) {
                        res++;
                    } else {
                        idx = (idx + nums.length) % nums.length;
                        res--;
                    }
                    nums[tmp] = tmp + offSet;
                }
            }
        }
        return res;
    }
}
