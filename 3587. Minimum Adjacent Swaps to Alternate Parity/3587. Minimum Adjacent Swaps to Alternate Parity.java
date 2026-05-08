/*
 * Problem: 3587. Minimum Adjacent Swaps to Alternate Parity
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-adjacent-swaps-to-alternate-parity/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int minSwaps(int[] nums) {
        int[] counts = new int[2];
        int target = nums[0] & 1;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] & 1;
            counts[nums[i]]++;
            if (nums[i] != target) {
                target = -1;
            } else {
                target = 1 - target;
            }
        }
        if (target != -1)
            return 0;
        if (counts[0] == counts[1]) {
            return Math.min(getMin(nums.clone(), 0), getMin(nums, 1));
        } else if (counts[0] == counts[1] + 1) {
            return getMin(nums, 0);
        } else if (counts[0] + 1 == counts[1]) {
            return getMin(nums, 1);
        } else {
            return -1;
        }
    }

    public int getMin(int[] nums, int target) {
        int require = -1;
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;
            res += count;
            if (require == nums[i]) {
                count--;
                if (count == 0)
                    require = -1;
                nums[i] = -1;
            } else if (nums[i] != target) {
                require = target;
                res -= count;
                count++;
            } else {
                target = 1 - target;
            }
        }
        return res;
    }
}
