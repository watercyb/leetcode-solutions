/*
 * Problem: 3271. Hash Divided String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/hash-divided-string/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public String stringHash(String s, int k) {
        char[] chrs = s.toCharArray();
        char[] res = new char[chrs.length / k];
        int idx = 0;
        for (int i = 0; i < chrs.length; i += k) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += chrs[j] - 'a';
            }
            res[idx++] = (char) (sum % 26 + 'a');
        }
        return new String(res);
    }
}
