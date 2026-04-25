/*
 * Problem: 2243. Calculate Digit Sum of a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/calculate-digit-sum-of-a-string/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k)
            return s;
        StringBuilder SB = new StringBuilder();
        int count = 0;
        int sum = 0;
        for (char chr : s.toCharArray()) {
            sum += chr - '0';
            count++;
            if (count == k) {
                SB.append(String.valueOf(sum));
                sum = 0;
                count = 0;
            }
        }
        if (count > 0)
            SB.append(String.valueOf(sum));
        return digitSum(SB.toString(), k);
    }
}
