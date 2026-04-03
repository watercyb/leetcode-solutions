/*
 * Problem: 357. Count Numbers with Unique Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0) return 1;
        int res=10;
        int tmp=9;
        for (int i=9;i>9-n+1;i--) {
            tmp*=i;
            res+=tmp;
        }
        return res;
    }
}
