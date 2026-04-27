/*
 * Problem: 2452. Words Within Two Edits of Dictionary
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/words-within-two-edits-of-dictionary/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        char[][] chrs = new char[dictionary.length][];
        for (int i = 0; i < dictionary.length; i++) {
            chrs[i] = dictionary[i].toCharArray();
        }
        List<String> res = new ArrayList<>();
        for (String str : queries) {
            if (chk(chrs, str))
                res.add(str);
        }
        return res;
    }

    public boolean chk(char[][] chrs, String str) {
        char[] chrs1 = str.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            int count = 0;
            for (int j = 0; j < chrs[i].length && count <= 2; j++) {
                if (chrs[i][j] != chrs1[j])
                    count++;
            }
            if (count <= 2)
                return true;
        }
        return false;
    }
}
