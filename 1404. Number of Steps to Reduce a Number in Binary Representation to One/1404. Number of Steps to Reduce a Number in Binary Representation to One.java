/*
 * Problem: 1404. Number of Steps to Reduce a Number in Binary Representation to One
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int numSteps(String s) {
        char[] chrs = s.toCharArray();
        int carry = '0';
        int res = 0;
        int one = '1' + '0';
        for (int i = chrs.length - 1; i > 0; i--) {
            int tmp = chrs[i] + carry;
            if (tmp == one) {
                res += 2;
                carry = '1';
            }  else {
                res++;
            }
        }
        return res+carry-'0';
    }
}
