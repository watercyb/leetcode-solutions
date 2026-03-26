/*
 * Problem: 210. Course Schedule II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/course-schedule-ii/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] Li = new ArrayList[numCourses];
        HashSet<Integer> Used = new HashSet<>();
        int[] Needs = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            Used.add(i);
            Li[i]=new ArrayList<Integer>();
        }
        for (int i=0;i<prerequisites.length;i++) {
            Li[prerequisites[i][1]].add(prerequisites[i][0]);
            Needs[prerequisites[i][0]]++;
            Used.remove(prerequisites[i][0]);
        }

        int[] re = new int[numCourses];
        int index = 0;
        Queue<Integer> Qu = new LinkedList<>();
        for (int key : Used) {
            re[index++] = key;
            Qu.add(key);
        }
        while (Qu.size() != 0) {
            int n = Qu.poll();
            for (int in : Li[n]) {
                if (Needs[in] == 1) {
                    Qu.add(in);
                    re[index++] = in;
                } else {
                    Needs[in]--;
                }
            }
        }

        if (index == numCourses) {
            return re;
        }
        return new int[] {};
    }
}
