/*
 * Problem: 555. Split Concatenated Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-concatenated-strings/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public String splitLoopedString(String[] strs) {
        String[] revs = new String[strs.length];
        String[] maxes = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            revs[i] = rev;
            if (rev.compareTo(strs[i]) > 0) {
                maxes[i] = revs[i];
            } else {
                maxes[i] = strs[i];
            }
        }
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            StringBuilder SB = new StringBuilder();
            for (int j = 1; j < strs.length; j++) {
                SB.append(maxes[(i + j) % strs.length]);
            }
            String mid = SB.toString();
            for (int j = 0; j < strs[i].length(); j++) {
                String a = strs[i].substring(j);
                String b = revs[i].substring(j);
                if (a.compareTo(b) > 0) {
                    String str = new StringBuilder(a).append(mid).append(strs[i].substring(0, j)).toString();
                    if (str.compareTo(res) > 0)
                        res = str;
                } else {
                    String str = new StringBuilder(b).append(mid).append(revs[i].substring(0, j)).toString();
                    if (str.compareTo(res) > 0)
                        res = str;
                }
            }
        }
        return res;
    }
}
