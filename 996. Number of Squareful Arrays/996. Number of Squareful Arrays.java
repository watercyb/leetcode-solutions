/*
 * Problem: 996. Number of Squareful Arrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-squareful-arrays/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int numSquarefulPerms(int[] nums) {
        return dfs(nums, 0, -1);
    }

    public int dfs(int[] nums, int i, int prv) {
        if (i == nums.length)
            return 1;
        int res = 0;
        if (chk(nums[i], prv))
            res = dfs(nums, i + 1, nums[i]);
        for (int j = i + 1; j < nums.length; j++) {
            if (chk(nums[j], prv) && chk(nums, i, j)) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                res += dfs(nums, i + 1, nums[i]);
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        return res;
    }

    public boolean chk(int a, int b) {
        if (b == -1)
            return true;
        int sqrt = (int) Math.sqrt(a + b);
        return sqrt * sqrt == a + b;
    }

    public boolean chk(int[] nums, int a, int b) {
        for (int i = a; i < b; i++) {
            if (nums[i] == nums[b])
                return false;
        }
        return true;
    }
}
