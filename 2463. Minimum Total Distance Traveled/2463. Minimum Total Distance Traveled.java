/*
 * Problem: 2463. Minimum Total Distance Traveled
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-total-distance-traveled/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int[] arr = new int[robot.size()];
        for (int i = 0; i < robot.size(); i++) {
            arr[i] = robot.get(i);
        }
        Arrays.sort(arr);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        long[][] DP = new long[factory.length + 1][arr.length + 1];
        for (long[] row : DP) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        DP[0][0] = 0;
        for (int i = 0; i < factory.length; i++) {
            Deque<Integer> indexes = new ArrayDeque<>();
            Deque<Long> mins = new ArrayDeque<>();
            indexes.offerLast(-1);
            mins.offerLast(0L);
            long offset = 0;
            for (int j = 0; j < arr.length; j++) {
                offset += Math.abs(factory[i][0] - arr[j]);
                while (!indexes.isEmpty() && indexes.peekFirst() + factory[i][1] < j) {
                    indexes.pollFirst();
                    mins.pollFirst();
                }
                long num = DP[i][j + 1] - offset;
                while (!indexes.isEmpty() && mins.peekLast() >= num) {
                    indexes.pollLast();
                    mins.pollLast();
                }
                indexes.offerLast(j);
                mins.offerLast(num);
                DP[i + 1][j + 1] = mins.peekFirst() + offset;
            }
        }
        return DP[factory.length][arr.length];
    }
}
