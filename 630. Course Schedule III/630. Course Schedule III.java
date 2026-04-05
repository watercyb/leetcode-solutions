/*
 * Problem: 630. Course Schedule III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/course-schedule-iii/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int t = 1;
        int res = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> b - a);
        for (int[] course : courses) {
            if (t + course[0] - 1 > course[1]) {
                if (!PQ.isEmpty() && PQ.peek() > course[0] && t - PQ.peek() + course[0] - 1 <= course[1]) {
                    t = t - PQ.poll() + course[0];
                    PQ.offer(course[0]);
                }
            } else {
                t += course[0];
                PQ.offer(course[0]);
                res++;
            }
        }
        return res;
    }
}
