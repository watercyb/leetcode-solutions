/*
 * Problem: 2210. Count Hills and Valleys in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int countHillValley(int[] nums) {
        int res = 0;
        int hill = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1]) {
                if (hill == 0) {
                    if (nums[i] > nums[i - 1]) {
                        hill = 1;
                    } else {
                        hill = -1;
                    }
                } else if (hill == -1) {
                    if (nums[i] > nums[i - 1]) {
                        hill = 1;
                        res += 1;
                    }
                } else if (hill == 1) {
                    if (nums[i] < nums[i - 1]) {
                        hill = -1;
                        res += 1;
                    }
                }
            }
        }
        if ((hill == -1 && nums[nums.length - 1] > nums[nums.length - 2])
                || (hill == 1 && nums[nums.length - 1] < nums[nums.length - 2]))
            res += 1;
        return res;
    }
}
