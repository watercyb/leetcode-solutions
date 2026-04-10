/*
 * Problem: 947. Most Stones Removed with Same Row or Column
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int removeStones(int[][] stones) {
        int[] links = new int[10001 + 10001];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        int res = 0;
        for (int[] stone : stones) {
            int a = unionFind(links, stone[0]);
            int b = unionFind(links, stone[1] + 10001);
            if (a != b) {
                if (a != stone[0] || b != stone[1] + 10001)
                    res++;
                links[a] = b;

            }
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
