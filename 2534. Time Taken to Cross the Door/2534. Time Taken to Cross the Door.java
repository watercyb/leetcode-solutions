/*
 * Problem: 2534. Time Taken to Cross the Door
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/time-taken-to-cross-the-door/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Integer>[] Qu = new LinkedList[2];
        Qu[0] = new LinkedList<>();
        Qu[1] = new LinkedList<>();
        int time = 0;
        int[] res = new int[arrival.length];
        int prv = 1;
        for (int i = 0; i < arrival.length; i++) {
            while (time < arrival[i] && (!Qu[prv].isEmpty() || !Qu[1 - prv].isEmpty())) {
                if (!Qu[prv].isEmpty()) {
                    res[Qu[prv].poll()] = time++;
                } else if (!Qu[1 - prv].isEmpty()) {
                    res[Qu[1 - prv].poll()] = time++;
                    prv = 1 - prv;
                } else {
                    prv = 1 - prv;
                }
            }
            if (time < arrival[i]) {
                prv = 1;
                time = arrival[i];
            }
            Qu[state[i]].offer(i);
        }
        while (!Qu[prv].isEmpty() || !Qu[1 - prv].isEmpty()) {
            if (!Qu[prv].isEmpty()) {
                res[Qu[prv].poll()] = time++;
            } else if (!Qu[1 - prv].isEmpty()) {
                res[Qu[1 - prv].poll()] = time++;
                prv = 1 - prv;
            } else {
                prv = 1 - prv;
            }
        }
        return res;
    }
}
