/*
 * Problem: 2662. Minimum Cost of a Path With Special Roads
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-of-a-path-with-special-roads/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] steps = new int[specialRoads.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        int min = getDist(start, target);
        for (int i = 0; i < specialRoads.length; i++) {
            int stp = getDist(start, specialRoads[i]) + specialRoads[i][4];
            if (stp < steps[i]) {
                steps[i] = stp;
                PQ.offer(new int[] { stp, i });
                min = Math.min(stp + getDist(specialRoads[i][2], specialRoads[i][3], target[0], target[1]), min);
            }
        }
        while (!PQ.isEmpty()) {
            int[] current = PQ.poll();
            int idx = current[1];
            int x = specialRoads[idx][2];
            int y = specialRoads[idx][3];
            int stp = current[0];
            if (stp >= min)
                break;
            if (stp != steps[idx])
                continue;
            for (int i = 0; i < specialRoads.length; i++) {
                if (idx == i)
                    continue;
                int stpNext = stp + getDist(x, y, specialRoads[i][0], specialRoads[i][1]) + specialRoads[i][4];
                if (stpNext < min && stpNext < steps[i]) {
                    steps[i] = stpNext;
                    min = Math.min(stpNext + getDist(specialRoads[i][2], specialRoads[i][3], target[0], target[1]),
                            min);
                    PQ.offer(new int[] { stpNext, i });
                }
            }
        }
        return min;
    }

    public int getDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
