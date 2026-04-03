/*
 * Problem: 548. Split Array with Equal Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/split-array-with-equal-sum/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean splitArray(int[] nums) {
        if (nums.length < 7)
            return false;
        nums = getArr(nums);
        if (nums.length == 1)
            return true;
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + sum;
            sum = sums[i];
        }
        for (int i = 3; i < nums.length - 3; i++) {
            int left = sums[i] - nums[i];
            HashSet<Integer> HS = new HashSet<>();
            for (int j = 1; j < i - 1; j++) {
                int l = sums[j] - nums[j];
                if (l + l == left - nums[j]) {
                    HS.add(l);
                }
            }
            int right = sum - sums[i];
            for (int j = i + 2; j < nums.length - 1; j++) {
                int r = sums[j] - nums[j] - sums[i];
                if (r + r == right - nums[j] && HS.contains(r))
                    return true;
            }
        }
        return false;
    }

    public int[] getArr(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (count++ >= 7)
                    continue;
                list.add(nums[i]);
            } else {
                count = 0;
                list.add(nums[i]);
            }
        }
        nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
