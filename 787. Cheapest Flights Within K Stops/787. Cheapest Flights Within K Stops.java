/*
 * Problem: 787. Cheapest Flights Within K Stops
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] edges = new int[n][n];
        for (int[] arr : flights) {
            edges[arr[0]][arr[1]] = arr[2];
        }
        Queue<int[]> Qu = new LinkedList<>();
        int[] visits = new int[n];
        Arrays.fill(visits, Integer.MAX_VALUE);
        Qu.add(new int[] { src, 0 });
        int min = Integer.MAX_VALUE;
        while (k > -1 && !Qu.isEmpty()) {
            int size = Qu.size();
            for (int j = 0; j < size; j++) {
                int[] visit = Qu.poll();
                int[] arr = edges[visit[0]];
                for (int l = 0; l < n; l++) {
                    if (arr[l] == 0)
                        continue;
                    int next = visit[1] + arr[l];
                    if (l != dst) {
                        if (next < visits[l]) {
                            visits[l] = next;
                            Qu.add(new int[] { l, next });
                        }
                    } else if (next < min) {
                        min = next;
                    }
                }
            }
            k--;
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
