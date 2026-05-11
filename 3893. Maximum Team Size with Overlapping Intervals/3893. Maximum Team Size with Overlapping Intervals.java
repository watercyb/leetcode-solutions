/*
 * Problem: 3893. Maximum Team Size with Overlapping Intervals
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-team-size-with-overlapping-intervals/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int maximumTeamSize(int[] startTime, int[] endTime) {
        int[] starts = startTime.clone();
        int[] ends = endTime.clone();
        Arrays.sort(starts);
        Arrays.sort(ends);
        HashMap<Integer, Integer> HMStarts = new HashMap<>(startTime.length, 0.99f);
        HashMap<Integer, Integer> HMEnds = new HashMap<>(startTime.length, 0.99f);
        int idxStart = 0;
        int idxEnd = 0;
        for (int i = 0; i < startTime.length; i++) {
            while (idxStart < starts.length && ends[i] + 1 > starts[idxStart]) {
                idxStart++;
            }
            HMStarts.put(ends[i], idxStart);
            while (starts[i] > ends[idxEnd]) {
                idxEnd++;
            }
            HMEnds.put(starts[i], idxEnd);
        }
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            int a = HMStarts.get(endTime[i]);
            int b = HMEnds.get(startTime[i]);
            res = Math.max(res, a - b);
        }
        return res;
    }
}
