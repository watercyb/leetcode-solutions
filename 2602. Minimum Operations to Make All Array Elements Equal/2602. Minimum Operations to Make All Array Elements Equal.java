/*
 * Problem: 2602. Minimum Operations to Make All Array Elements Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-all-array-elements-equal/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        long sum = sums[nums.length];
        List<Long> res = new ArrayList<>();
        for (int query : queries) {
            int idx = binarySearch(nums, query) + 1;
            res.add((long) query * (2 * idx - nums.length) + sum - 2 * sums[idx]);
        }
        return res;
    }

    public int binarySearch(int[] nums, int num) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
