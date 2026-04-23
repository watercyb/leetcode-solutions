/*
 * Problem: 2045. Second Minimum Time to Reach Destination
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/second-minimum-time-to-reach-destination/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int stp = getSecondMin(n, edges);
        int res = 0;
        int totalTime = 0;
        for (int i = 0; i < stp; i++) {
            if (totalTime / change % 2 == 1) {
                int t = change - (totalTime % change);
                res += t;
                totalTime += t;
            }
            res += time;
            totalTime += time;
        }
        return res;
    }

    public int getSecondMin(int n, int[][] edges) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
        }
        int[] seens = new int[n + 1];
        int[] stps = new int[n + 1];
        Deque<Integer> Dq = new ArrayDeque<>();
        Dq.offerLast(1);
        seens[1] = 1;
        stps[1] = 0;
        int stp = 1;
        int min = Integer.MAX_VALUE;
        while (!Dq.isEmpty()) {
            int size = Dq.size();
            for (int i = 0; i < size; i++) {
                int current = Dq.pollFirst();
                for (int next : links.get(current)) {
                    if (seens[next] == 0) {
                        seens[next]++;
                        stps[next] = stp;
                        Dq.offerLast(next);
                        if (next == n) {
                            min = stp + 2;
                        }
                    } else if (seens[next] == 1) {
                        if (stps[next] != stp - 1)
                            continue;
                        seens[next]++;
                        Dq.offerLast(next);
                        if (next == n) {
                            return stp;
                        }
                    }
                }
            }
            stp++;
        }
        return min;
    }
}
