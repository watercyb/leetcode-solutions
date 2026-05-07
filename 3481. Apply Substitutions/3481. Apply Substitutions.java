/*
 * Problem: 3481. Apply Substitutions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apply-substitutions/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        for (List<String> rep : replacements) {
            strs[rep.get(0).charAt(0) - 'A'] = rep.get(1);
        }
        dfs(text);
        return SB.toString();
    }

    String[] strs = new String[26];
    StringBuilder SB = new StringBuilder();

    public void dfs(String str) {
        char[] chrs = str.toCharArray();
        int idx = 0;
        while (idx < chrs.length) {
            if (chrs[idx] == '%') {
                dfs(strs[chrs[idx + 1] - 'A']);
                idx += 3;
            } else {
                SB.append(chrs[idx]);
                idx++;
            }
        }
    }
}
