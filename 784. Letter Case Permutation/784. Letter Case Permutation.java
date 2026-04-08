/*
 * Problem: 784. Letter Case Permutation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/letter-case-permutation/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        dfs(s.toCharArray(), res, 0);
        return res;
    }

    public void dfs(char[] chrs, List<String> res, int i) {
        if (i == chrs.length) {
            res.add(new String(chrs));
        } else {
            dfs(chrs, res, i + 1);
            if (Character.isLowerCase(chrs[i])) {
                chrs[i] -= 32;
                dfs(chrs, res, i + 1);
                chrs[i] += 32;
            } else if (Character.isUpperCase(chrs[i])) {
                chrs[i] += 32;
                dfs(chrs, res, i + 1);
                chrs[i] -= 32;
            }
        }
    }
}
