/*
 * Problem: 93. Restore IP Addresses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/restore-ip-addresses/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), res, new StringBuilder(), 0, 3);
        return res;
    }

    public void dfs(char[] chrs, List<String> res, StringBuilder SB, int i, int n) {
        if (n == 0) {
            int num = 0;
            if ((i < chrs.length - 1 && chrs[i] == '0') || i + 3 < chrs.length)
                return;
            for (int j = i; j < chrs.length; j++) {
                num *= 10;
                num += chrs[j] - '0';
            }
            if (num <= 255) {
                int size = SB.length();
                SB.append(String.valueOf(num));
                res.add(SB.toString());
                SB.setLength(size);
            }
        } else {
            int size = SB.length();
            int num = 0;
            for (int j = i; j < chrs.length - n; j++) {
                num *= 10;
                num += chrs[j] - '0';
                if (num <= 255) {
                    SB.append(String.valueOf(num)).append('.');
                    dfs(chrs, res, SB, j + 1, n - 1);
                    SB.setLength(size);
                } else {
                    return;
                }
                if (num == 0)
                    return;
            }
        }
    }
}
