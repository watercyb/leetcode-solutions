/*
 * Problem: 591. Tag Validator
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/tag-validator/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public boolean isValid(String code) {
        char[] chrs = code.toCharArray();
        if (chrs[0] != '<')
            return false;
        String t = chkTag(chrs);
        if (t == null || t.startsWith("/"))
            return false;
        return dfs(chrs, t) && idx == chrs.length;
    }

    int idx = 0;
    char[] cdata = { ']', ']', '>' };

    public boolean dfs(char[] chrs, String tag) {
        while (idx < chrs.length) {
            if (chrs[idx] == '<') {
                String t = chkTag(chrs);
                if (t == null)
                    return false;
                if (t.equals("#CDATA"))
                    continue;
                if (!t.startsWith("/")) {
                    if (!dfs(chrs, t))
                        return false;
                } else {
                    return t.substring(1).equals(tag);
                }
            } else {
                idx++;
            }
        }
        return false;
    }

    public String chkTag(char[] chrs) {
        idx++;
        if (idx == chrs.length)
            return null;
        if (chrs[idx] == '!') {
            if (chrs.length - idx <= 9)
                return null;
            if (chrs[idx + 1] != '[' || chrs[idx + 2] != 'C' || chrs[idx + 3] != 'D' || chrs[idx + 4] != 'A'
                    || chrs[idx + 5] != 'T' || chrs[idx + 6] != 'A' || chrs[idx + 7] != '[')
                return null;
            idx += 8;
            int len = 0;
            while (idx < chrs.length && len < 3) {
                if (chrs[idx] == cdata[len]) {
                    len++;
                } else {
                    if (len != 2 || chrs[idx] != ']')
                        len = 0;
                }
                idx++;
            }
            if (len != 3)
                return null;
            return "#CDATA";
        } else {
            int len = 0;
            StringBuilder SB = new StringBuilder();
            if (chrs[idx] == '/') {
                SB.append('/');
                idx++;
            }
            while (idx < chrs.length && chrs[idx] != '>') {
                if (!Character.isUpperCase(chrs[idx]))
                    return null;
                if (len++ == 9)
                    return null;
                SB.append(chrs[idx]);
                idx++;
            }
            if (idx == chrs.length || len == 0)
                return null;
            idx++;
            return SB.toString();
        }
    }
}
