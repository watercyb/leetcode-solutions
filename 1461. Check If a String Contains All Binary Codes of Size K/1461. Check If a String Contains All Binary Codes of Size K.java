/*
 * Problem: 1461. Check If a String Contains All Binary Codes of Size K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public boolean hasAllCodes(String s, int k) {
        char[] chrs = s.toCharArray();
        int max = 1 << k;
        if (1 << k > chrs.length)
            return false;
        boolean[] seens = new boolean[max];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = (sum << 1) + chrs[i] - '0';
        }
        seens[sum] = true;
        max--;
        for (int i = k; i < chrs.length && max > 0; i++) {
            sum = (sum << 1) - ((chrs[i - k] - '0') << k) + chrs[i] - '0';
            if (!seens[sum]) {
                seens[sum] = true;
                max--;
            }
        }
        return max == 0;
    }
}
