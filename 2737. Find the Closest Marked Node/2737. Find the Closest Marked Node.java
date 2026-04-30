/*
 * Problem: 2737. Find the Closest Marked Node
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-closest-marked-node/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            int c = edge.get(2);
            lists[a].add(new int[] { b, c });
        }
        int[] stps = new int[n];
        Arrays.fill(stps, Integer.MAX_VALUE);
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PQ.offer(new int[] { s, 0 });
        boolean[] isMarked = new boolean[n];
        for (int mark : marked) {
            isMarked[mark] = true;
        }
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            if (stps[current[0]] <= current[1])
                continue;
            stps[current[0]] = current[1];
            if (isMarked[current[0]]) {
                return current[1];
            }
            for (int[] next : lists[current[0]]) {
                if (stps[current[0]] + next[1] < stps[next[0]]) {
                    PQ.offer(new int[] { next[0], stps[current[0]] + next[1] });
                }
            }
        }
        return -1;
    }
}
