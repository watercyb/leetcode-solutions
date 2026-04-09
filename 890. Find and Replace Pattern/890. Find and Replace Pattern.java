/*
 * Problem: 890. Find and Replace Pattern
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-and-replace-pattern/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String p = getCode(pattern);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (p.equals(getCode(word)))
                res.add(word);
        }
        return res;
    }

    public String getCode(String str) {
        StringBuilder SB = new StringBuilder();
        char[] chrs = new char['z' + 1];
        char i = 0;
        for (char chr : str.toCharArray()) {
            if (chrs[chr] != 0) {
                SB.append(chrs[chr]);
            } else {
                i++;
                chrs[chr] = i;
                SB.append(chrs[chr]);
            }
        }
        return SB.toString();
    }
}
