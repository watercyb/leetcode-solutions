/*
 * Problem: 1705. Maximum Number of Eaten Apples
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-eaten-apples/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Pair> PQ = new PriorityQueue<>((a, b) -> a.rot - b.rot);
        int res = 0;
        int i = 0;
        while (i < apples.length || !PQ.isEmpty()) {
            while (!PQ.isEmpty() && PQ.peek().rot <= i) {
                PQ.poll();
            }
            if (i < apples.length && apples[i] > 0)
                PQ.offer(new Pair(apples[i], i + days[i]));
            if (!PQ.isEmpty()) {
                if (PQ.peek().num > 1) {
                    PQ.peek().num--;
                } else {
                    PQ.poll();
                }
                res++;
            }
            i++;
        }
        return res;
    }
}

class Pair {
    int num = 0;
    int rot = 0;

    public Pair(int num, int rot) {
        this.num = num;
        this.rot = rot;
    }
}
