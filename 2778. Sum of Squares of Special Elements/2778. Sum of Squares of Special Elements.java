/*
 * Problem: 2778. Sum of Squares of Special Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-squares-of-special-elements/?envType=daily-question&envId=2026-10-11
 * Language: java
 * Date: 2026-10-11
 */

class Solution {
    public int sumOfSquares(int[] nums) {
        int res=0;
        for (int i=1;i<=nums.length;i++) {
            if (nums.length%i==0) res+=nums[i-1]*nums[i-1];
        }
        return res;
    }
}
