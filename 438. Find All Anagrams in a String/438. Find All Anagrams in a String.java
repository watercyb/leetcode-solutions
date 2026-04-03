/*
 * Problem: 438. Find All Anagrams in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length())
            return res;
        int[] counts = new int['z' + 1];
        int dist = 0;
        for (char chr : p.toCharArray()) {
            counts[chr]++;
            if (counts[chr] == 1)
                dist++;
        }
        char[] chrs = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            counts[chrs[i]]--;
            if (counts[chrs[i]] == 0) {
                dist--;
            } else if (counts[chrs[i]] == -1) {
                dist++;
            }
        }
        if (dist == 0)
            res.add(0);
        int j = 0;
        for (int i = p.length(); i < chrs.length; i++) {
            counts[chrs[i]]--;
            if (counts[chrs[i]] == 0) {
                dist--;
            } else if (counts[chrs[i]] == -1) {
                dist++;
            }
            if (counts[chrs[j]] == 0) {
                dist++;
            } else if (counts[chrs[j]] == -1) {
                dist--;
            }
            counts[chrs[j++]]++;
            if (dist == 0)
                res.add(j);
        }
        return res;
    }
}
