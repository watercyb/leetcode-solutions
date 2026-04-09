/*
 * Problem: 882. Reachable Nodes In Subdivided Graph
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<List<int[]>> links = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(new int[] { edge[1], edge[2] });
            links.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE / 2);
        steps[0] = 0;
        Queue<int[]> Qu = new LinkedList<>();
        Qu.offer(new int[] { 0, 0 });
        while (!Qu.isEmpty()) {
            int size = Qu.size();
            for (int i = 0; i < size; i++) {
                int[] current = Qu.poll();
                if (current[0] != steps[current[1]])
                    continue;
                for (int[] next : links.get(current[1])) {
                    int step = current[0] + next[1] + 1;
                    if (step < steps[next[0]]) {
                        steps[next[0]] = step;
                        if (step < maxMoves)
                            Qu.offer(new int[] { step, next[0] });
                    }
                }
            }
        }
        int res = 0;
        for (int step : steps) {
            if (step <= maxMoves)
                res++;
        }
        for (int[] edge : edges) {
            res += Math.min(Math.max(maxMoves - steps[edge[0]], 0) + Math.max(maxMoves - steps[edge[1]], 0), edge[2]);
        }
        return res;
    }
}
