/*
 * Problem: 3769. Sort Integers by Binary Reflection
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sort-integers-by-binary-reflection/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int[] sortByReflection(int[] nums) {
        long[] arr = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = (rev(nums[i]) << 32) + nums[i];
        }
        Arrays.sort(arr);
        int[] res = new int[arr.length];
        int mask = (1 << 31) - 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = (int) (arr[i] & mask);
        }
        return res;
    }

    public long rev(int num) {
        int res = 0;
        while (num > 0) {
            res = (res << 1) + (num & 1);
            num >>= 1;
        }
        return res;
    }
}
