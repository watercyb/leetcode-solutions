/*
 * Problem: 1389. Create Target Array in the Given Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/create-target-array-in-the-given-order/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
