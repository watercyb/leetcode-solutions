/*
 * Problem: 1942. The Number of the Smallest Unoccupied Chair
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int[] seats = new int[times.length];
        int idx = 0;
        int[] arr = new int[times[targetFriend][0]];
        Arrays.fill(arr, -1);
        List<Integer>[] lists = new ArrayList[times[targetFriend][0] + 1];
        for (int i = 0; i < times.length; i++) {
            if (times[i][0] < arr.length) {
                arr[times[i][0]] = i;
                if (times[i][1] < lists.length) {
                    if (lists[times[i][1]] == null)
                        lists[times[i][1]] = new ArrayList<>();
                    lists[times[i][1]].add(i);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (lists[i] != null) {
                for (int peopleIdx : lists[i]) {
                    PQ.offer(seats[peopleIdx]);
                }
            }
            if (arr[i] >= 0) {
                if (!PQ.isEmpty()) {
                    int seatIdx = PQ.poll();
                    seats[arr[i]] = seatIdx;
                } else {
                    seats[arr[i]] = idx++;
                }
            }
        }
        if (lists[times[targetFriend][0]] != null) {
            for (int peopleIdx : lists[times[targetFriend][0]]) {
                PQ.offer(seats[peopleIdx]);
            }
        }
        if (!PQ.isEmpty())
            return PQ.poll();
        return idx;
    }
}
