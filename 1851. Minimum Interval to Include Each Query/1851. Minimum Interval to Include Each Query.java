/*
 * Problem: 1851. Minimum Interval to Include Each Query
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-interval-to-include-each-query/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] qu = new int[queries.length][2];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            qu[i] = new int[] { queries[i], i };
        }
        Arrays.sort(qu, (a, b) -> a[0] - b[0]);

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int stN = 0;
        for (int[] q : qu) {
            while (!PQ.isEmpty() && PQ.peek()[1] < q[0])
                PQ.poll();
            while (stN < intervals.length && intervals[stN][0] <= q[0]) {
                if (intervals[stN][1] >= q[0])
                    PQ.add(new int[] { intervals[stN][1] - intervals[stN][0] + 1, intervals[stN][1] });
                stN++;
            }
            if (!PQ.isEmpty()) {
                res[q[1]] = PQ.peek()[0];
            } else {
                res[q[1]] = -1;
            }
        }

        return res;

    }

}
