/*
 * Problem: 1847. Closest Room
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/closest-room/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);
        int[][] arr = new int[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            arr[i] = new int[] { queries[i][0], queries[i][1], i };
        }
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
        TreeSet<Integer> TS = new TreeSet<>();
        int[] res = new int[queries.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            while (idx < rooms.length && rooms[idx][1] >= arr[i][1]) {
                TS.add(rooms[idx][0]);
                idx++;
            }
            Integer l = TS.floor(arr[i][0]);
            Integer r = TS.higher(arr[i][0]);
            if (l == null && r == null) {
                res[arr[i][2]] = -1;
            } else if (l == null || (r != null && arr[i][0] - l > r - arr[i][0])) {
                res[arr[i][2]] = r;
            } else {
                res[arr[i][2]] = l;
            }
        }
        return res;
    }
}
