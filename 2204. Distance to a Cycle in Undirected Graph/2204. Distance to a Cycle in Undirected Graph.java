/*
 * Problem: 2204. Distance to a Cycle in Undirected Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distance-to-a-cycle-in-undirected-graph/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        int[] counts = new int[n];
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
            counts[edge[0]]++;
            counts[edge[1]]++;
        }
        Queue<Integer> Qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (counts[i] == 1) {
                Qu.offer(i);
                counts[i]--;
            }
        }
        while (!Qu.isEmpty()) {
            int current = Qu.poll();
            for (int next : links.get(current)) {
                if (--counts[next] == 1) {
                    Qu.offer(next);
                    counts[next]--;
                }
            }
        }
        Qu.clear();
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (counts[i] > 1) {
                Qu.offer(i);
                res[i] = 0;
            }
        }
        int stp = 1;
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int current = Qu.poll();
                for (int next : links.get(current)) {
                    if (res[next] == Integer.MAX_VALUE) {
                        Qu.offer(next);
                        res[next] = stp;
                    }
                }
            }
            stp++;
        }
        return res;
    }
}
