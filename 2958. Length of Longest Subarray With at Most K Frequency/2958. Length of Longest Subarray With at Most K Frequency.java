/*
 * Problem: 2958. Length of Longest Subarray With at Most K Frequency
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/?envType=daily-question&envId=2026-08-12
 * Language: java
 * Date: 2026-08-12
 */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if (k == nums.length)
            return nums.length;
        HashMap<Integer, Integer> HM = new HashMap<>();
        int res = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (HM.containsKey(nums[i])) {
                int tmp = HM.get(nums[i]);
                if (tmp == k) {
                    res = Math.max(i - j, res);
                    while (nums[j] != nums[i]) {
                        HM.put(nums[j], HM.get(nums[j]) - 1);
                        j++;
                    }
                    j++;
                } else {
                    HM.put(nums[i], tmp + 1);
                }
            } else {
                HM.put(nums[i], 1);
            }
        }
        return Math.max(nums.length - j, res);
    }
}
