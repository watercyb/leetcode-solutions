/*
 * Problem: 3493. Properties Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/properties-graph/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int numberOfComponents(int[][] properties, int k) {
        long[][] arr = new long[properties.length][2];
        int[] links = new int[properties.length];
        for (int i = 0; i < properties.length; i++) {
            for (int num : properties[i]) {
                if (num <= 50) {
                    arr[i][0] |= 1l << num;
                } else {
                    arr[i][1] |= 1l << num;
                }
            }
            links[i] = i;
        }
        for (int i = 0; i < properties.length; i++) {
            for (int j = i + 1; j < properties.length; j++) {
                if (chk(arr[i], arr[j], k)) {
                    int a = find(links, i);
                    int b = find(links, j);
                    if (a != b)
                        links[a] = b;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < properties.length; i++) {
            if (links[i] == i)
                res++;
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public boolean chk(long[] a, long[] b, int k) {
        return Long.bitCount(a[0] & b[0]) + Long.bitCount(a[1] & b[1]) >= k;
    }
}
