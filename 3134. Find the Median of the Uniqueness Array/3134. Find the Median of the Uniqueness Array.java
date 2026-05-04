/*
 * Problem: 3134. Find the Median of the Uniqueness Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-median-of-the-uniqueness-array/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        long target = (((long) nums.length + 1) * nums.length / 2 + 1) / 2;
        int l = 1;
        int r = max;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, max, target, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int max, long target, int mid) {
        int[] counts = new int[max + 1];
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (counts[nums[i]]++ == 0)
                count++;
            while (count > mid) {
                if (counts[nums[j]]-- == 1)
                    count--;
                j++;
            }
            target -= i - j + 1;
            if (target <= 0)
                return true;
        }
        return false;
    }

}
