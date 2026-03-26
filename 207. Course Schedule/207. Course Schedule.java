/*
 * Problem: 207. Course Schedule
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/course-schedule/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        for (int[] arr : prerequisites) {
            counts[arr[0]]++;
        }
        boolean[] seen = new boolean[prerequisites.length];
        for (boolean changed = true; changed;) {
            changed = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!seen[i] && counts[prerequisites[i][1]] == 0) {
                    counts[prerequisites[i][0]]--;
                    seen[i] = true;
                    changed = true;
                }
            }
            for (int i = prerequisites.length-1; i >=0 ; i--) {
                if (!seen[i] && counts[prerequisites[i][1]] == 0) {
                    counts[prerequisites[i][0]]--;
                    seen[i] = true;
                    changed = true;
                }
            }
        }
        for (int count:counts) {
            if (count>0) return false;
        }
        return true;
    }
}
