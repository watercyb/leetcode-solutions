/*
 * Problem: 218. The Skyline Problem
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/the-skyline-problem/
 * Language: java
 * Date: 2026-03-27
 */

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Arrays.sort(buildings, (a, b) -> a[0] - b[0]);
        int idx = 0;
        int height = 0;
        int i = buildings[0][0];
        while (i >= 0) {
            while (!PQ.isEmpty() && PQ.peek()[0] <= i)
                PQ.poll();
            while (idx < buildings.length && buildings[idx][0] == i) {
                PQ.add(new int[] { buildings[idx][1], buildings[idx][2] });
                idx++;
            }
            if (PQ.isEmpty()) {
                if (height != 0) {
                    height = 0;
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(height);
                    res.add(tmp);
                }
            } else if (PQ.peek()[1] != height) {
                height = PQ.peek()[1];
                res.add(Arrays.asList(new Integer[] { i, height }));
            }

            if (!PQ.isEmpty() && idx < buildings.length) {
                i = Math.min(PQ.peek()[0], buildings[idx][0]);
            } else if (!PQ.isEmpty()) {
                i = PQ.peek()[0];
            } else if (idx < buildings.length) {
                i = buildings[idx][0];
            } else {
                return res;
            }

        }
        return res;

    }
}
