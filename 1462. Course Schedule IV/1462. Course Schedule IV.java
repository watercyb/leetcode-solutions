/*
 * Problem: 1462. Course Schedule IV
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/course-schedule-iv/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] prerequisity : prerequisites) {
            links.get(prerequisity[0]).add(prerequisity[1]);
        }
        boolean[][] seens = new boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!seens[i][i])
                dfs(seens, links, i);
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(seens[query[0]][query[1]]);
        }
        return res;
    }

    public void dfs(boolean[][] seens, List<List<Integer>> links, int i) {
        for (int next : links.get(i)) {
            if (!seens[next][next])
                dfs(seens, links, next);
            for (int j = 0; j < seens[0].length; j++) {
                seens[i][j] |= seens[next][j];
            }
        }
        seens[i][i] = true;
    }
}
