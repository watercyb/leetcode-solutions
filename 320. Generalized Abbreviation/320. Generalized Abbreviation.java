/*
 * Problem: 320. Generalized Abbreviation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/generalized-abbreviation/
 * Language: java
 * Date: 2026-04-01
 */

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        dfs(word.toCharArray(), res, new StringBuilder(), 0, 0);
        return res;
    }

    public void dfs(char[] chrs, List<String> list, StringBuilder SB, int i, int num) {
        int length = SB.length();
        if (i == chrs.length) {
            if (num > 0)
                SB.append(num);
            list.add(SB.toString());
            SB.setLength(length);
        } else {
            if (num != 0)
                SB.append(num);
            SB.append(chrs[i]);
            dfs(chrs, list, SB, i + 1, 0);
            SB.setLength(length);
            dfs(chrs, list, SB, i + 1, num + 1);
        }
    }
}
