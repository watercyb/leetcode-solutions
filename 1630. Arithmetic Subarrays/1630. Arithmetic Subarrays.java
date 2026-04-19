/*
 * Problem: 1630. Arithmetic Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/arithmetic-subarrays/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            if (findAri(nums, l[i], r[i])) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public boolean findAri(int[] nums, int l, int r) {
        if (r - l == 1)
            return true;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        if (max == min)
            return true;
        if ((max - min) % (r - l) != 0)
            return false;
        boolean[] arr = new boolean[max - min + 1];
        for (int i = l; i <= r; i++) {
            arr[nums[i] - min] = true;
        }
        int idx = 0;
        int diff = (max - min) / (r - l);
        int n = r - l;
        for (int i = diff; i < arr.length - 1; i += diff) {
            if (!arr[i])
                return false;
        }
        return true;
    }
}
