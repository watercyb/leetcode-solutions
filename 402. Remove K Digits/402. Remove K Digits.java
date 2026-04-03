/*
 * Problem: 402. Remove K Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-k-digits/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k)
            return "0";
        char[] chrs = num.toCharArray();
        char[] MQ = new char[chrs.length];
        int idx = 0;
        for (int i = 0; i < chrs.length; i++) {
            while (idx > 0 && k > 0 && MQ[idx - 1] > chrs[i]) {
                idx--;
                k--;
            }
            MQ[idx++] = chrs[i];
        }
        int j = 0;
        while (j < idx - k - 1 && MQ[j] == '0') {
            j++;
        }
        String res = new String(MQ, j, Math.max(idx - j - k, 0));

        return res;
    }
}
