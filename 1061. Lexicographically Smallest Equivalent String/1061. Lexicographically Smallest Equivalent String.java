/*
 * Problem: 1061. Lexicographically Smallest Equivalent String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] links = new int[26];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int a = find(links, s1.charAt(i) - 'a');
            int b = find(links, s2.charAt(i) - 'a');
            if (a < b) {
                links[b] = a;
            } else if (a > b) {
                links[a] = b;
            }
        }
        char[] chrs = baseStr.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            chrs[i] = (char) (find(links, chrs[i] - 'a') + 'a');
        }
        return new String(chrs);
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
