/*
 * Problem: 17. Letter Combinations of a Phone Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    char[][] chrs = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
            { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0) return res;
        DFS(res, new StringBuilder(), digits, 0);
        return res;
    }

    public void DFS(List<String> res, StringBuilder SB, String digits, int i) {
        if (i == digits.length()) {
            res.add(SB.toString());
        } else {
            for (char chr : chrs[digits.charAt(i) - '2']) {
                SB.append(chr);
                DFS(res, SB, digits, i + 1);
                SB.deleteCharAt(i);
            }
        }
    }
}
