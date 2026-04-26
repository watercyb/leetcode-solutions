/*
 * Problem: 2301. Match Substring After Replacement
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/match-substring-after-replacement/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        boolean[][] links = new boolean['z' + 1]['z' + 1];
        for (char[] mapping : mappings) {
            links[mapping[0]][mapping[1]] = true;
        }
        char[] chrS = s.toCharArray();
        char[] chrSub = sub.toCharArray();
        for (int i = 0; i <= chrS.length - chrSub.length; i++) {
            if (chk(chrS, chrSub, links, i))
                return true;
        }
        return false;
    }

    public boolean chk(char[] chrS, char[] chrSub, boolean[][] links, int i) {
        for (int j = 0; j < chrSub.length; j++) {
            if (chrSub[j] != chrS[i] && !links[chrSub[j]][chrS[i]])
                return false;
            i++;
        }
        return true;
    }
}
