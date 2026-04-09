/*
 * Problem: 893. Groups of Special-Equivalent Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/groups-of-special-equivalent-strings/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numSpecialEquivGroups(String[] words) {
        HashSet<String> HS = new HashSet<>();
        for (String word : words) {
            char[] chrs = word.toCharArray();
            for (int i = 0; i < chrs.length - 2; i++) {
                for (int j = i + 2; j < chrs.length; j += 2) {
                    if (chrs[j] > chrs[i]) {
                        char temp = chrs[i];
                        chrs[i] = chrs[j];
                        chrs[j] = temp;
                    }
                }
            }
            HS.add(new String(chrs));
        }
        return HS.size();
    }
}
