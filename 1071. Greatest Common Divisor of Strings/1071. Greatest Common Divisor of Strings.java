/*
 * Problem: 1071. Greatest Common Divisor of Strings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ((new StringBuilder(str1).append(str2)).compareTo(new StringBuilder(str2).append(str1)) != 0)
            return "";
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        int tmp = a % b;
        if (tmp == 0)
            return b;
        return gcd(b, tmp);
    }
}
