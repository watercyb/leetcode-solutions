/*
 * Problem: 1702. Maximum Binary String After Change
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-binary-string-after-change/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public String maximumBinaryString(String binary) {
        char[] chrs = binary.toCharArray();
        int idx = 0;
        while (idx < chrs.length && chrs[idx] == '1') {
            idx++;
        }
        while (idx < chrs.length - 1 && chrs[idx + 1] == '0') {
            chrs[idx++] = '1';
        }
        if (idx >= chrs.length - 1)
            return new String(chrs);
        int count = 0;
        for (int i = idx + 1; i < chrs.length; i++) {
            count += '1' - chrs[i];
        }
        for (int i = 0; i < count; i++) {
            chrs[idx++] = '1';
        }
        chrs[idx++] = '0';
        while (idx < chrs.length) {
            chrs[idx++] = '1';
        }
        return new String(chrs);
    }
}
