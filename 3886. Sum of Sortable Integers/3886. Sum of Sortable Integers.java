/*
 * Problem: 3886. Sum of Sortable Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/sum-of-sortable-integers/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int sortableIntegers(int[] nums) {
        int max1 = 0;
        int max2 = 0;
        int prv = 0;
        boolean isSorted = true;
        for (int num : nums) {
            if (num > max1) {
                max1 = num;
            } else if (num < max2) {
                return 0;
            } else if (num < max1 && num > max2) {
                max2 = num;
            }
            if (num < prv)
                isSorted = false;
            prv = num;
        }
        if (isSorted) {
            int res = 0;
            int idx = 1;
            while (idx * idx < nums.length) {
                if (nums.length % idx == 0)
                    res += idx + nums.length / idx;
                idx++;
            }
            if (idx * idx == nums.length)
                res += idx;
            return res;
        } else {
            int res = 0;
            for (int i = 2; i <= nums.length / 2; i++) {
                if (nums.length % i != 0)
                    continue;
                if (chkArr(nums, i)) {
                    res += i;
                }
            }
            if (chkArr(nums, nums.length))
                res += nums.length;
            return res;
        }
    }

    public boolean chkArr(int[] nums, int i) {
        int max = 0;
        for (int j = 0; j < nums.length; j += i) {
            int[] pair = chkSeg(nums, j, j + i - 1);
            if (pair == null)
                return false;
            if (pair[0] < max)
                return false;
            max = pair[1];
        }
        return true;
    }

    public int[] chkSeg(int[] nums, int l, int r) {
        if (nums[l] < nums[r]) {
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] < nums[i - 1])
                    return null;
            }
            return new int[] { nums[l], nums[r] };
        } else {
            int[] res = new int[] { nums[l], nums[r] };
            while (l < r && nums[l + 1] >= nums[l]) {
                l++;
            }
            if (l == r)
                return res;
            res[1] = nums[l];
            l++;
            res[0] = nums[l];
            while (l < r && nums[l + 1] >= nums[l]) {
                l++;
            }
            if (l == r)
                return res;
            return null;
        }
    }
}
