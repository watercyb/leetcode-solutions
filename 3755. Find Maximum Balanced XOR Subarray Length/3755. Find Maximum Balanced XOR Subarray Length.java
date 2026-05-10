/*
 * Problem: 3755. Find Maximum Balanced XOR Subarray Length
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-maximum-balanced-xor-subarray-length/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<Integer, HashMap<Integer, Integer>> HM = new HashMap<>(nums.length, 0.99f);
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(0, -1);
        HM.put(0, temp);
        int xor = 0;
        int count = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            count += 1 - (nums[i] & 1) * 2;
            if (HM.containsKey(xor)) {
                temp = HM.get(xor);
                if (temp.containsKey(count)) {
                    res = Math.max(res, i - temp.get(count));
                } else {
                    temp.put(count, i);
                }
            } else {
                temp = new HashMap<>();
                temp.put(count, i);
                HM.put(xor, temp);
            }
        }
        return res;
    }
}
