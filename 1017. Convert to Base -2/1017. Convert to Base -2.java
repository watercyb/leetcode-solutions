/*
 * Problem: 1017. Convert to Base -2
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-to-base-2/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public String baseNeg2(int n) {
        int[] arr = new int[31];
        int idx = 0;
        int carry = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0)
                carry++;
            if (carry == 1) {
                arr[i] = 1;
                carry = i % 2;
                idx = i;
            } else if (carry == 2) {
                arr[i] = 0;
                carry = 1;
            }
        }
        StringBuilder SB = new StringBuilder();
        while (idx >= 0) {
            SB.append(arr[idx--]);
        }
        return SB.toString();
    }
}
