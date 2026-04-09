/*
 * Problem: 839. Similar String Groups
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/similar-string-groups/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numSimilarGroups(String[] strs) {
        char[][] chrs = new char[strs.length][];
        int[] links = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            chrs[i] = strs[i].toCharArray();
            links[i] = i;
        }
        for (int i = 0; i < strs.length - 1; i++) {
            int a = unionFind(links, i);
            for (int j = i + 1; j < strs.length; j++) {
                int b = unionFind(links, j);
                if (a != b && chk(chrs[i], chrs[j])) {
                    links[b] = a;
                }
            }
        }
        boolean[] seens = new boolean[strs.length];
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!seens[unionFind(links, i)]) {
                res++;
                seens[links[i]] = true;
            }
        }
        return res;
    }

    public boolean chk(char[] a, char[] b) {
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i] && n++ == 2)
                return false;
        }
        return true;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
