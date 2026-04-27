/*
 * Problem: 2497. Maximum Star Sum of a Graph
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-star-sum-of-a-graph/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int res = Integer.MIN_VALUE;
        if (k == 0) {
            for (int val : vals) {
                res = Math.max(val, res);
            }
            return res;
        }
        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            links.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            links.get(edge[0]).add(edge[1]);
            links.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < vals.length; i++) {
            PriorityQueue<Integer> PQ = new PriorityQueue<>();
            int sum = vals[i];
            for (int next : links.get(i)) {
                if (vals[next] > 0) {
                    if (PQ.size() < k) {
                        sum += vals[next];
                        PQ.offer(vals[next]);
                    } else if (PQ.peek() < vals[next]) {
                        sum -= PQ.poll();
                        sum += vals[next];
                        PQ.offer(vals[next]);
                    }
                }
            }
            res = Math.max(sum, res);
        }
        return res;
    }
}
