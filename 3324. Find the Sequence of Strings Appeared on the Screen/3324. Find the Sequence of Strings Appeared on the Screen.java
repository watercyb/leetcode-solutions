/*
 * Problem: 3324. Find the Sequence of Strings Appeared on the Screen
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public List<String> stringSequence(String target) {
        char[] chrsT = target.toCharArray();
        StringBuilder SB = new StringBuilder();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chrsT.length; i++) {
            for (char j = 'a'; j <= chrsT[i]; j++) {
                SB.setLength(i);
                SB.append(j);
                res.add(SB.toString());
            }
        }
        return res;
    }
}
