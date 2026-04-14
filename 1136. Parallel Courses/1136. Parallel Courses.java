/*
 * Problem: 1136. Parallel Courses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/parallel-courses/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            links.add(new ArrayList<>());
        }
        int[] counts = new int[n + 1];
        for (int[] relation : relations) {
            links.get(relation[0]).add(relation[1]);
            counts[relation[1]]++;
        }
        Queue<Integer> Qu = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                Qu.offer(i);
            } else {
                count++;
            }
        }
        int stp = 0;
        while (!Qu.isEmpty()) {
            int l = Qu.size();
            for (int i = 0; i < l; i++) {
                for (int next : links.get(Qu.poll())) {
                    counts[next]--;
                    if (counts[next] == 0) {
                        Qu.offer(next);
                        count--;
                    }
                }
            }
            stp++;
        }
        if (count != 0)
            return -1;
        return stp;
    }
}
