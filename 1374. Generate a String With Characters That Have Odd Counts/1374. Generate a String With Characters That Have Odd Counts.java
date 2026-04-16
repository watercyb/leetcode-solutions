/*
 * Problem: 1374. Generate a String With Characters That Have Odd Counts
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String generateTheString(int n) {
        char[] res = new char[n];
        Arrays.fill(res, 'a');
        if (n % 2 == 1)
            return new String(res);
        res[0] = 'b';
        return new String(res);
    }
}
