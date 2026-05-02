/*
 * Problem: 2937. Make Three Strings Equal
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/make-three-strings-equal/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0;
        while (i < s1.length() && i < s2.length() && i < s3.length() && s1.charAt(i) == s2.charAt(i)
                && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }
        if (i == 0)
            return -1;
        return s1.length() + s2.length() + s3.length() - 3 * i;
    }
}
