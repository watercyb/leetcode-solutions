/*
 * Problem: 2895. Minimum Processing Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-processing-time/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int[] p = new int[processorTime.size()];
        int[] t = new int[tasks.size()];
        for (int i = 0; i < p.length; i++) {
            p[i] = processorTime.get(i);
        }
        for (int i = 0; i < t.length; i++) {
            t[i] = tasks.get(i);
        }
        Arrays.sort(p);
        Arrays.sort(t);
        int idx = t.length - 1;
        int res = 0;
        for (int time : p) {
            for (int i = 0; i < 4; i++) {
                res = Math.max(time + t[idx--], res);
            }
        }
        return res;
    }
}
