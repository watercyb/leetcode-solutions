/*
 * Problem: 3040. Maximum Number of Operations With the Same Score II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxOperations(int[] nums) {
        int l = nums.length;
        int res = 0;
        res = Math.max(dfs(nums, new HashMap<>(), 0, l - 1, nums[0] + nums[l - 1]), res);
        if (nums[1] != nums[l - 1])
            res = Math.max(dfs(nums, new HashMap<>(), 0, l - 1, nums[0] + nums[1]), res);
        if (nums[0] != nums[l - 2] && nums[0] + nums[1] != nums[l - 2] + nums[l - 1])
            res = Math.max(dfs(nums, new HashMap<>(), 0, l - 1, nums[l - 2] + nums[l - 1]), res);
        return res;
    }

    boolean usedAll = false;

    public int dfs(int[] nums, HashMap<Integer, Integer> HM, int i, int j, int target) {
        if (usedAll)
            return 0;
        if (i >= j) {
            usedAll = true;
            return 0;
        }
        int k = i * 2000 + j;
        if (HM.containsKey(k))
            return HM.get(k);
        int res = 0;
        if (nums[i] + nums[j] == target)
            res = Math.max(dfs(nums, HM, i + 1, j - 1, target) + 1, res);
        if (nums[i] + nums[i + 1] == target)
            res = Math.max(dfs(nums, HM, i + 2, j, target) + 1, res);
        if (nums[j - 1] + nums[j] == target)
            res = Math.max(dfs(nums, HM, i, j - 2, target) + 1, res);
        HM.put(k, res);
        return res;
    }
}
