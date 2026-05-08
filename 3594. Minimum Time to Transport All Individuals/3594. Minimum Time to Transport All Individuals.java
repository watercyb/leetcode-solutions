/*
 * Problem: 3594. Minimum Time to Transport All Individuals
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-time-to-transport-all-individuals/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        if (k == 1 && n > 1)
            return -1;
        double[][][] DP = new double[1 << n][m][2];
        for (double[][] arr : DP) {
            for (double[] row : arr) {
                Arrays.fill(row, Double.MAX_VALUE);
            }
        }
        DP[0][0][0] = 0;
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(0, 0, 0, 0));
        int max = (1 << n) - 1;
        double min = Double.MAX_VALUE;
        int[] maxTimes = new int[1 << n];
        while (!PQ.isEmpty()) {
            Node current = PQ.poll();
            double t = current.time;
            int h = current.h;
            int mIdx = current.m;
            int stage = current.stage;
            if (DP[h][mIdx][stage] != t || t > min)
                continue;
            if (h == max)
                return t;
            if (stage == 0) {
                int mask = h ^ max;
                for (int hMove = mask; hMove != 0; hMove = (hMove - 1) & mask) {
                    if (Integer.bitCount(hMove) > k)
                        continue;
                    int maxTime = 0;
                    if (maxTimes[hMove] != 0) {
                        maxTime = maxTimes[hMove];
                    } else {
                        for (int idx = 0; idx < n; idx++) {
                            if ((hMove & (1 << idx)) == 0)
                                continue;
                            if (time[idx] > maxTime)
                                maxTime = time[idx];
                        }
                        maxTimes[hMove] = maxTime;
                    }
                    int hNext = h + hMove;
                    double totalTimeMove = mul[mIdx] * maxTime;
                    int mIdxMove = (mIdx + (int) totalTimeMove) % m;
                    double totalTime = t + totalTimeMove;
                    if (totalTime < DP[hNext][mIdxMove][1] && totalTime < min) {
                        if (hNext == max)
                            min = totalTime;
                        DP[hNext][mIdxMove][1] = totalTime;
                        PQ.offer(new Node(totalTime, hNext, mIdxMove, 1));
                    }
                }
            } else {
                for (int idx = 0; idx < n; idx++) {
                    if ((h & (1 << idx)) == 0)
                        continue;
                    int hNext = h - (1 << idx);
                    double totalTimeBack = mul[mIdx] * time[idx];
                    int mIdxBack = (mIdx + (int) Math.floor(totalTimeBack)) % m;
                    double totalTime = t + totalTimeBack;
                    if (totalTime < DP[hNext][mIdxBack][0] && totalTime < min) {
                        DP[hNext][mIdxBack][0] = totalTime;
                        PQ.offer(new Node(totalTime, hNext, mIdxBack, 0));
                    }
                }
            }
        }
        return -1;
    }
}

class Node implements Comparable<Node> {
    double time;
    int h;
    int m;
    int stage;

    public Node(double time, int h, int m, int stage) {
        this.time = time;
        this.h = h;
        this.m = m;
        this.stage = stage;
    }

    @Override
    public int compareTo(Node node) {
        if (time < node.time) {
            return -1;
        } else if (time > node.time) {
            return 1;
        } else {
            return 0;
        }
    }
}
