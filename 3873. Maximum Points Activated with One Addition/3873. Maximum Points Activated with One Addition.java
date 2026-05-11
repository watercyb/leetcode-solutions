/*
 * Problem: 3873. Maximum Points Activated with One Addition
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-points-activated-with-one-addition/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int maxActivated(int[][] points) {
        HashMap<Integer, Integer> rows = new HashMap<>(points.length, 0.99f);
        HashMap<Integer, Integer> cols = new HashMap<>(points.length, 0.99f);
        int[] links = new int[points.length];
        int[] counts = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            links[i] = i;
            int x = points[i][0];
            int y = points[i][1];
            if (!rows.containsKey(x)) {
                rows.put(x, i);
                counts[i] = 1;
            } else {
                int a = find(links, rows.get(x));
                links[a] = i;
                counts[i] = counts[a] + 1;
            }
            if (!cols.containsKey(y)) {
                cols.put(y, i);
            } else {
                int a = find(links, cols.get(y));
                if (a != i) {
                    links[a] = i;
                    counts[i] += counts[a];
                }
            }
        }
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < links.length; i++) {
            if (links[i] == i) {
                if (counts[i] > max1) {
                    max2 = max1;
                    max1 = counts[i];
                } else if (counts[i] > max2) {
                    max2 = counts[i];
                }
            }
        }
        return max1 + max2 + 1;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
