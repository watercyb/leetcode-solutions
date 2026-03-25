/*
 * Problem: 3Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/3sum/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int prvI = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == prvI)
                continue;
            int prvJ = Integer.MIN_VALUE;
            int k=nums.length-1;
            for (int j = i + 1; j < k; j++) {
                if (nums[j] == prvJ)
                    continue;
                int sum = nums[i] + nums[j];
                while (k>j) {
                    int tmp = sum + nums[k];
                    if (tmp < 0) {
                        break;
                    }
                    if (tmp == 0) {
                        res.add(Arrays.asList( nums[i], nums[j], nums[k]));
                        break;
                    }
                    k--;
                }
                prvJ = nums[j];
            }
            prvI = nums[i];
        }
        return res;
    }
}
