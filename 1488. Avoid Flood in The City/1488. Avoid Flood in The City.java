/*
 * Problem: 1488. Avoid Flood in The City
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/avoid-flood-in-the-city/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        HashMap<Integer, Integer> HM = new HashMap<>(rains.length);
        int[] arr = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (HM.containsKey(rains[i])) {
                arr[HM.get(rains[i])] = i;
            }
            HM.put(rains[i], i);
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (!PQ.isEmpty() && PQ.peek()[0] == i)
                    return new int[0];
                if (arr[i] != 0)
                    PQ.offer(new int[] { arr[i], i });
                res[i] = -1;
            } else {
                if (!PQ.isEmpty()) {
                    int[] pair = PQ.poll();
                    res[i] = rains[pair[1]];
                } else {
                    res[i] = 1;
                }
            }
        }
        return res;
    }
}
