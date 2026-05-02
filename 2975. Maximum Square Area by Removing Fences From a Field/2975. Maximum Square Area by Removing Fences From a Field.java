/*
 * Problem: 2975. Maximum Square Area by Removing Fences From a Field
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if (hFences.length > vFences.length)
            return maximizeSquareArea(n, m, vFences, hFences);
        HashSet<Integer> HS = new HashSet<>(hFences.length * hFences.length, 0.99f);
        add(HS, m, 1);
        for (int i = 0; i < hFences.length; i++) {
            add(HS, hFences[i], 1);
            add(HS, m, hFences[i]);
            for (int j = i - 1; j >= 0; j--) {
                add(HS, hFences[i], hFences[j]);
            }
        }
        int max = chk(HS, n, 1, 0);
        for (int i = 0; i < vFences.length; i++) {
            max = chk(HS, vFences[i], 1, max);
            max = chk(HS, n, vFences[i], max);
            for (int j = i - 1; j >= 0; j--) {
                max = chk(HS, vFences[i], vFences[j], max);
            }
        }
        if (max == 0)
            return -1;
        return (int) ((long) max * max % 1_000_000_007);
    }

    public void add(HashSet<Integer> HS, int a, int b) {
        if (a < b) {
            add(HS, b, a);
        } else {
            HS.add(a - b);
        }
    }

    public int chk(HashSet<Integer> HS, int a, int b, int max) {
        if (a < b)
            return chk(HS, b, a, max);
        if (HS.contains(a - b) && max < a - b)
            return a - b;
        return max;
    }
}
