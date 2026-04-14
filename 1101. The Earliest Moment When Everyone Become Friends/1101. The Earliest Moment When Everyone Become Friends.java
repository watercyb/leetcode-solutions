/*
 * Problem: 1101. The Earliest Moment When Everyone Become Friends
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int earliestAcq(int[][] logs, int n) {
        if (logs.length < n - 1) { return -1; }
        Arrays.sort(logs,(a,b)->a[0]-b[0]);
        int[] links = new int[n];
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            links[i] = i;
            counts[i] = 1;
        }
        for (int[] log : logs) {
            int a = UF(links, log[1]);
            int b = UF(links, log[2]);
            if (a != b) {
                links[b] = a;
                counts[a] += counts[b];
                if (counts[a] == n)
                    return log[0];
            }
        }
        return -1;
    }

    public int UF(int[] links, int i) {
        if (links[i] != i)
            links[i] = UF(links, links[i]);
        return links[i];
    }
}
