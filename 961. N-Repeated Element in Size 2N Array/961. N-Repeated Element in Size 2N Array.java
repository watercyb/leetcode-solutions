/*
 * Problem: 961. N-Repeated Element in Size 2N Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int repeatedNTimes(int[] nums) {
        boolean[] seens = new boolean[10001];
        for (int num : nums) {
            if (seens[num])
                return num;
            seens[num] = true;
        }
        return -1;
    }
}
