/*
 * Problem: 686. Repeated String Match
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/repeated-string-match/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int repeatedStringMatch(String a, String b) {
        boolean[] seens = new boolean['z' + 1];
        for (char chr : a.toCharArray()) {
            seens[chr] = true;
        }
        for (char chr : b.toCharArray()) {
            if (!seens[chr])
                return -1;
        }
        int lengthA = a.length();
        int lengthB = b.length();
        int n = (lengthB + lengthA - 1) / lengthA;
        String str = a.repeat(n);
        if (str.indexOf(b) >= 0)
            return n;
        str = a.repeat(n + 1);
        if (str.indexOf(b) >= 0)
            return n + 1;
        return -1;
    }
}
