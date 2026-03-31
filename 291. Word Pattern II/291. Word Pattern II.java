/*
 * Problem: 291. Word Pattern II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/word-pattern-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        char[][] map = new char[26][];
        return dfs(pattern.toCharArray(), s.toCharArray(), map, new StringBuilder(), 0, 0);
    }

    HashSet<String> HS = new HashSet<>();

    public boolean dfs(char[] chrsP, char[] chrsS, char[][] map, StringBuilder SB, int i, int j) {
        if (i == chrsP.length && j == chrsS.length)
            return true;
        if (i == chrsP.length || j == chrsS.length)
            return false;
        if (map[chrsP[i] - 'a'] != null) {
            char[] chrs = map[chrsP[i] - 'a'];
            if (chrsS.length - chrs.length - j < chrsP.length - i - 1)
                return false;
            for (int k = 0; k < chrs.length; k++) {
                if (chrs[k] != chrsS[k + j])
                    return false;
            }
            if (dfs(chrsP, chrsS, map, SB, i + 1, j + chrs.length))
                return true;
        } else {
            if (chrsS.length - j >= chrsP.length - i - 1) {
                SB.append(chrsS[j]);
                if (dfs(chrsP, chrsS, map, SB, i, j + 1))
                    return true;

                String str = SB.toString();
                if (HS.add(str)) {
                    map[chrsP[i] - 'a'] = str.toCharArray();
                    if (dfs(chrsP, chrsS, map, new StringBuilder(), i + 1, j + 1))
                        return true;
                    map[chrsP[i] - 'a'] = null;
                    HS.remove(str);
                }

                SB.setLength(SB.length() - 1);
            }
        }
        return false;
    }
}
