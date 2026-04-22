/*
 * Problem: 1945. Sum of Digits of String After Convert
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int getLucky(String s, int k) {
        int num = 0;
        for (char chr : s.toCharArray()) {
            int numTemp = chr - 'a' + 1;
            num += numTemp / 10 + numTemp % 10;
        }
        for (int i = 1; i < k && num >= 10; i++) {
            int numTemp = num;
            num = 0;
            while (numTemp > 0) {
                num += numTemp % 10;
                numTemp /= 10;
            }
        }
        return num;
    }
}
