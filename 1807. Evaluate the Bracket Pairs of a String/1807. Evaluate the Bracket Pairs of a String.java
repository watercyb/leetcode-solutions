/*
 * Problem: 1807. Evaluate the Bracket Pairs of a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> HM = new HashMap<>(knowledge.size(), 0.99f);
        for (List<String> list : knowledge) {
            HM.put(list.get(0), list.get(1));
        }
        StringBuilder SB = new StringBuilder();
        StringBuilder SB1 = null;
        for (char chr : s.toCharArray()) {
            if (chr == '(') {
                SB1 = new StringBuilder();
            } else if (chr == ')') {
                SB.append(HM.getOrDefault(SB1.toString(), "?"));
                SB1 = null;
            } else if (SB1 != null) {
                SB1.append(chr);
            } else {
                SB.append(chr);
            }
        }
        return SB.toString();
    }
}
