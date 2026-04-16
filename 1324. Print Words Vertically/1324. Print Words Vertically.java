/*
 * Problem: 1324. Print Words Vertically
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/print-words-vertically/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public List<String> printVertically(String s) {
        String[] strs = s.split(" ");
        List<String> res = new ArrayList<>();
        int idxStrs = 0;
        int len = -1;
        while (len != 0) {
            char[] chrs = new char[strs.length];
            int idxChrs = 0;
            len = 0;
            for (String str : strs) {
                if (idxStrs < str.length()) {
                    chrs[idxChrs++] = str.charAt(idxStrs);
                    len = idxChrs;
                } else {
                    chrs[idxChrs++] = ' ';
                }
            }
            if (len > 0)
                res.add(new String(chrs, 0, len));
            idxStrs++;
        }
        return res;
    }
}
