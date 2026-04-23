/*
 * Problem: 2015. Average Height of Buildings in Each Segment
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/average-height-of-buildings-in-each-segment/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[][] averageHeightOfBuildings(int[][] buildings) {
        Arrays.sort(buildings, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int idx = 0;
        int count = 0;
        int sum = 0;
        int prv = 0;
        int height = 0;
        while (idx < buildings.length || !PQ.isEmpty()) {
            int prvNext = 0;
            if (idx < buildings.length && (PQ.isEmpty() || PQ.peek()[1] >= buildings[idx][0])) {
                prvNext = buildings[idx][0];
                while (idx < buildings.length && buildings[idx][0] == prvNext) {
                    count++;
                    sum += buildings[idx][2];
                    PQ.offer(buildings[idx]);
                    idx++;
                }
                while (!PQ.isEmpty() && PQ.peek()[1] == prvNext) {
                    count--;
                    sum -= PQ.poll()[2];
                }
            } else {
                int[] pair = PQ.poll();
                count--;
                sum -= pair[2];
                prvNext = pair[1];
                while (!PQ.isEmpty() && PQ.peek()[1] == prvNext) {
                    count--;
                    sum -= PQ.poll()[2];
                }
            }
            int heightNext = count == 0 ? 0 : sum / count;
            if (heightNext != height) {
                if (height != 0)
                    list.add(new int[] { prv, prvNext, height });
                prv = prvNext;
                height = heightNext;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
