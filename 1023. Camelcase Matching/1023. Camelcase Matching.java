/*
 * Problem: 1023. Camelcase Matching
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/camelcase-matching/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        char[] chrs = pattern.toCharArray();
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(chk(queries[i], chrs));
        }
        return res;
    }

    public boolean chk(String str, char[] chrs) {
        int i = 0;
        for (char chr : str.toCharArray()) {
            if (Character.isUpperCase(chr) && (i == chrs.length || chr != chrs[i]))
                return false;
            if (i < chrs.length && chr == chrs[i])
                i++;
        }
        return i == chrs.length;
    }
}
