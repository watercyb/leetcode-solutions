/*
 * Problem: 71. Simplify Path
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/simplify-path/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String simplifyPath(String path) {
        char[] chrs = path.toCharArray();
        List<StringBuilder> Li = new ArrayList<>();
        StringBuilder SB = new StringBuilder("/");
        int dots = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '/') {
                if (SB.length() > 1) {
                    if (dots == 2 && SB.length() == 3) {
                        if (Li.size() > 0)
                            Li.remove(Li.size() - 1);
                    } else if (dots != 1 || SB.length() != 2) {
                        Li.add(SB);
                    }
                    SB = new StringBuilder("/");
                    dots = 0;
                }
            } else {
                SB.append(chrs[i]);
                if (chrs[i] == '.')
                    dots++;
            }
        }
        if (SB.length() > 1) {
            if (dots == 2 && SB.length() == 3) {
                if (Li.size() > 0)
                    Li.remove(Li.size() - 1);
            } else if (dots != 1 || SB.length() != 2) {
                Li.add(SB);
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder tmp : Li) {
            res.append(tmp);
        }
        if (res.length() == 0)
            return "/";
        return res.toString();
    }
}
