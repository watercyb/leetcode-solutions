/*
 * Problem: 2025. Maximum Number of Ways to Partition an Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int waysToPartition(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        HashMap<Integer, Integer> HM = new HashMap<>();
        long left = nums[0];
        if (sum - 2 * left != 0 && sum - 2 * left + k >= -100000 && sum - 2 * left + k <= 100000)
            HM.put((int) (sum - 2 * left + k), 1);
        int[] counts = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            if (sum - 2 * left == 0)
                counts[nums.length]++;
            counts[i] = HM.getOrDefault(nums[i], 0);
            left += nums[i];
            long key = sum - 2 * left + k;
            if (key >= -100000 && key <= 100000)
                HM.put((int) key, HM.getOrDefault((int) key, 0) + 1);
        }
        HM.clear();
        long right = nums[nums.length - 1];
        if (sum - 2 * right != 0 && sum - 2 * right + k >= -100000 && sum - 2 * right + k <= 100000)
            HM.put((int) (sum - 2 * right + k), 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            counts[i] += HM.getOrDefault(nums[i], 0);
            right += nums[i];
            long key = sum - 2 * right + k;
            if (key >= -100000 && key <= 100000)
                HM.put((int) key, HM.getOrDefault((int) key, 0) + 1);
        }
        int res = 0;
        for (int count : counts) {
            res = Math.max(count, res);
        }
        return res;
    }
}
