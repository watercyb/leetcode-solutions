/*
 * Problem: 1400. Construct K Palindrome Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/construct-k-palindrome-strings/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        int odd = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] % 2 == 1)
                odd++;
        }
        return odd <= k;
    }
}
