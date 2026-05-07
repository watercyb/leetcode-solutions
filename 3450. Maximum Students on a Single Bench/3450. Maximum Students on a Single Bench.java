/*
 * Problem: 3450. Maximum Students on a Single Bench
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-students-on-a-single-bench/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxStudentsOnBench(int[][] students) {
        HashMap<Integer, HashSet<Integer>> HM = new HashMap<>();
        int res = 0;
        for (int[] student : students) {
            HashSet<Integer> HS = HM.getOrDefault(student[1], new HashSet<>());
            HS.add(student[0]);
            HM.put(student[1], HS);
            res = Math.max(HS.size(), res);
        }
        return res;
    }
}
