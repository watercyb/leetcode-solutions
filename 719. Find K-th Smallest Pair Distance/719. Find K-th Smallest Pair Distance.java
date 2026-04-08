/*
 * Problem: 719. Find K-th Smallest Pair Distance
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-k-th-smallest-pair-distance/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int mid, int k) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < i && nums[i] - nums[j] > mid) {
                j++;
            }
            k -= i - j;
        }
        return k <= 0;
    }
}
