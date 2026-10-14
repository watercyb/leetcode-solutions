/*
 * Problem: 3723. Maximize Sum of Squares of Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-sum-of-squares-of-digits/?envType=daily-question&envId=2026-10-14
 * Language: java
 * Date: 2026-10-14
 */

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9)
            return "";
        char[] chrs = new char[num];
        Arrays.fill(chrs, '0');
        for (int i = 0; i < chrs.length && sum > 0; i++) {
            int n = Math.min(sum, 9);
            chrs[i] += n;
            sum -= n;
        }
        return new String(chrs);
    }
}
