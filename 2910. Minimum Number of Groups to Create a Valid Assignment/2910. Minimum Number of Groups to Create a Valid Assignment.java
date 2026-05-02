/*
 * Problem: 2910. Minimum Number of Groups to Create a Valid Assignment
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        HashMap<Integer, Integer> HM = new HashMap<>(balls.length, 0.99f);
        for (int ball : balls) {
            HM.put(ball, HM.getOrDefault(ball, 0) + 1);
        }
        int[] counts = new int[balls.length + 1];
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (int c : HM.values()) {
            if (counts[c]++ == 0)
                count++;
            min = Math.min(min, c);
        }
        int[][] arr = new int[count][];
        int idx = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > 0)
                arr[idx++] = new int[] { i, counts[i] };
        }
        for (int i = min + 1; i >= 1; i--) {
            int res = chk(arr, i);
            if (res != -1)
                return res;
        }
        return -1;
    }

    public int chk(int[][] arr, int i) {
        int res = 0;
        for (int[] pair : arr) {
            int w = (pair[0] + i - 1) / i;
            if (w * (i - 1) <= pair[0]) {
                res += w * pair[1];
            } else {
                return -1;
            }
        }
        return res;
    }
}
