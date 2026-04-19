/*
 * Problem: 1617. Count Subtrees With Max Distance Between Cities
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            links.add(new ArrayList<>());
        }
        int[] counts = new int[n + 1];
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
            counts[edge[0]]++;
            counts[edge[1]]++;
        }

        int[][] distances = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dfs(links, distances, i, i, 0);
        }
        int[] res = new int[n];
        List<Integer>[] lists = new ArrayList[n + 1];
        Queue<Integer> Qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (counts[i] == 1) {
                lists[i] = new ArrayList<>();
                lists[i].add(1 << i);
                res[getMax(distances, 1 << i)]++;
                Qu.offer(i);
            }
        }
        while (!Qu.isEmpty()) {
            int current = Qu.poll();
            if (counts[current] == 0)
                continue;
            counts[current]--;
            for (int next : links.get(current)) {
                if (counts[next] > 0) {
                    if (lists[next] == null) {
                        lists[next] = new ArrayList<>();
                        lists[next].add(1 << next);
                        res[getMax(distances, 1 << next)]++;
                    }
                    int size = lists[next].size();
                    for (int i = 0; i < size; i++) {
                        int hNext = lists[next].get(i);
                        for (int hCurrent : lists[current]) {
                            lists[next].add(hNext | hCurrent);
                            res[getMax(distances, hNext | hCurrent)]++;
                        }
                    }
                    if (counts[next]-- == 2)
                        Qu.offer(next);
                }
            }
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }

    public int getMax(int[][] distances, int h) {
        int max = 0;
        for (int j = 1; (1 << (j + 1)) < h; j++) {
            if ((h & (1 << j)) == 0)
                continue;
            for (int k = j + 1; (1 << k) < h; k++) {
                if ((h & (1 << k)) == 0)
                    continue;
                max = Math.max(distances[j][k], max);
            }
        }
        return max;
    }

    public void dfs(List<List<Integer>> links, int[][] distances, int i, int j, int stp) {
        distances[i][j] = stp;
        for (int next : links.get(j)) {
            if (next != i && distances[i][next] == 0)
                dfs(links, distances, i, next, stp + 1);
        }
    }
}
