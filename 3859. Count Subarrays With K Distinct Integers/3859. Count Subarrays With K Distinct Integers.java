/*
 * Problem: 3859. Count Subarrays With K Distinct Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subarrays-with-k-distinct-integers/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        Left left = new Left(nums, k, max);
        Right right = new Right(nums, k, m, max);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = left.getNext();
            int r = right.getNext();
            res += Math.max(r - l, 0);
        }
        return res;
    }
}

class Right {
    int[] nums;
    int k;
    int m;
    int l = 0;
    int r = 0;
    int[] counts;
    int dist = 0;
    int less = 0;

    public Right(int[] nums, int k, int m, int max) {
        this.nums = nums;
        this.k = k;
        this.m = m;
        counts = new int[max + 1];
    }

    public int getNext() {
        if (counts[nums[r]]++ == 0) {
            dist++;
            if (counts[nums[r]] < m)
                less++;
        } else if (counts[nums[r]] == m) {
            less--;
        }
        while (l <= r && (dist > k || (dist == k && less == 0))) {
            if (counts[nums[l]]-- == 1) {
                dist--;
                if (m != 1)
                    less--;
            } else if (counts[nums[l]] == m - 1) {
                less++;
            }
            l++;
        }
        r++;
        return l;
    }

}

class Left {
    int[] nums;
    int k;
    int l = 0;
    int r = 0;
    int[] counts;
    int dist = 0;

    public Left(int[] nums, int k, int max) {
        this.nums = nums;
        this.k = k;
        counts = new int[max + 1];
    }

    public int getNext() {
        if (counts[nums[r]]++ == 0)
            dist++;
        while (l <= r && dist > k) {
            if (counts[nums[l++]]-- == 1)
                dist--;
        }
        r++;
        return l;
    }
}
