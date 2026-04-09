/*
 * Problem: 805. Split Array With Same Average
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/split-array-with-same-average/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1)
            return false;
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        if (sums[nums.length] == 0)
            return true;
        for (int i = 1; i <= nums.length / 2; i++) {
            if (sums[nums.length] * i % nums.length == 0
                    && dfs(nums, new HashMap<>(), nums.length - 1, sums[nums.length] * i / nums.length, i))
                return true;
        }
        return false;
    }

    int[] sums;

    public boolean dfs(int[] nums, HashMap<Integer, Integer> HM, int i, int sum, int count) {
        if (sum == 0 && count == 0)
            return true;
        int h = sum * 31 + count;
        if (HM.getOrDefault(h, -1) >= i)
            return false;
        int j = i;
        while (j >= count - 1 && sums[j + 1] - sums[j + 1 - count] >= sum) {
            if (sums[count - 1] <= sum - nums[j] && dfs(nums, HM, j - 1, sum - nums[j], count - 1))
                return true;
            j--;
        }
        HM.put(h, i);
        return false;
    }
}
