/*
 * Problem: 841. Keys and Rooms
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/keys-and-rooms/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] unlocks = new boolean[rooms.size()];
        unlocks[0] = true;
        int[] arr = new int[unlocks.length];
        int l = 0;
        int r = 1;
        while (l < r) {
            int current = arr[l++];
            for (int next : rooms.get(current)) {
                if (!unlocks[next]) {
                    unlocks[next] = true;
                    arr[r++] = next;
                }
            }
        }
        return r == arr.length;
    }
}
