/*
 * Problem: 2899. Last Visited Integers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/last-visited-integers/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[nums.length];
        int r = 0;
        int l = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                arr[r++] = nums[i];
                l = r - 1;
            } else {
                if (l >= 0) {
                    res.add(arr[l--]);
                } else {
                    res.add(-1);
                }
            }
        }
        return res;
    }
}
