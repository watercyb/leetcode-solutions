/*
 * Problem: 1202. Smallest String With Swaps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-string-with-swaps/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chrs = s.toCharArray();
        int[] links = new int[chrs.length];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int a = unionFind(links, pair.get(0));
            int b = unionFind(links, pair.get(1));
            links[a] = b;
        }
        int[][] groups = new int[chrs.length][];
        for (int i = 0; i < chrs.length; i++) {
            int a = unionFind(links, i);
            if (groups[a] == null)
                groups[a] = new int[27];
            groups[a][chrs[i] - 'a']++;
        }
        for (int i = 0; i < chrs.length; i++) {
            int a = unionFind(links, i);
            while (groups[a][groups[a][26]] == 0) {
                groups[a][26]++;
            }
            chrs[i] = (char) (groups[a][26] + 'a');
            groups[a][groups[a][26]]--;
        }
        return new String(chrs);
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
