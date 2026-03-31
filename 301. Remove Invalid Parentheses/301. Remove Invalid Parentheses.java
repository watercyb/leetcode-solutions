/*
 * Problem: 301. Remove Invalid Parentheses
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/remove-invalid-parentheses/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        char[] chrs = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(res, chrs, 0, 0);
        return res;
    }

    public void dfs(List<String> res, char[] chrs, int l, int r) {
        int count = 0;
        while (r < chrs.length) {
            if (chrs[r] == '(') {
                count++;
            } else if (chrs[r] == ')') {
                count--;
            }
            if (count < 0) {
                while (l <= r) {
                    if (chrs[l] == ')' && (l == 0 || chrs[l - 1] != ')')) {
                        chrs[l] = '@';
                        dfs(res, chrs, l + 1, r + 1);
                        chrs[l] = ')';
                    }
                    l++;
                }
                return;
            }
            r++;
        }
        dfsRev(res, chrs, r - 1, r - 1, r - 1);
    }

    public void dfsRev(List<String> res, char[] chrs, int l, int r, int limR) {
        int count = 0;
        while (l >= 0) {
            if (chrs[l] == ')') {
                count++;
            } else if (chrs[l] == '(') {
                count--;
            }
            if (count < 0) {
                while (r >= l) {
                    if (chrs[r] == '(' && (r == limR || chrs[r + 1] != '(')) {
                        chrs[r] = '@';
                        dfsRev(res, chrs, l - 1, r - 1, limR);
                        chrs[r] = '(';
                    }
                    r--;
                }
                return;
            }
            l--;
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i <= limR; i++) {
            if (chrs[i] != '@')
                SB.append(chrs[i]);
        }
        res.add(SB.toString());
    }
}
