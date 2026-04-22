/*
 * Problem: 1966. Binary Searchable Numbers in an Unsorted Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-searchable-numbers-in-an-unsorted-array/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int binarySearchableNumbers(int[] nums) {
        boolean[] isGoods = new boolean[nums.length];
        isGoods[0] = true;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= max) {
                isGoods[i] = true;
                max = nums[i];
            }
        }
        int res = 0;
        if (isGoods[isGoods.length - 1])
            res++;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= min) {
                if (isGoods[i])
                    res++;
                min = nums[i];
            }
        }
        return res;
    }
}
