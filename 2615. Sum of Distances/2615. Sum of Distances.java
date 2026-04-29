/*
 * Problem: 2615. Sum of Distances
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sum-of-distances/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, long[]> HM = new HashMap<>(nums.length, 0.99f);
        for (int i = 0; i < nums.length; i++) {
            if (!HM.containsKey(nums[i])) {
                HM.put(nums[i], new long[] { 1, i });
            } else {
                long[] arr = HM.get(nums[i]);
                arr[0]++;
                arr[1] += i;
            }
        }
        long[] res = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            long[] arr = HM.get(nums[i]);
            res[i] = arr[1] - arr[0] * i;
            arr[0] -= 2;
            arr[1] -= 2 * i;
        }
        return res;
    }
}
