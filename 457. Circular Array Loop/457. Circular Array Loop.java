/*
 * Problem: 457. Circular Array Loop
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/circular-array-loop/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] seens = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!seens[i]) {
                target = -1;
                if (dfs(nums, seens, i) == 2)
                    return true;
            }
        }
        return false;
    }

    int target = -1;

    public int dfs(int[] nums, boolean[] seens, int i) {
        seens[i] = true;
        int next = ((nums[i] + i) % nums.length + nums.length) % nums.length;
        if (next == i)
            return 0;
        if (nums[i] > 0) {
            if (seens[next]) {
                target = next;
                return 1;
            }
            int res = dfs(nums, seens, next);
            if (res == 2)
                return 2;
            if (res == 1) {
                if (i == target)
                    return 2;
                return 1;
            }
        } else {
            if (seens[next]) {
                target = next;
                return -1;
            }
            int res = dfs(nums, seens, next);
            if (res == 2)
                return 2;
            if (res == -1) {
                if (i == target)
                    return 2;
                return -1;
            }
        }
        return 0;
    }
}
