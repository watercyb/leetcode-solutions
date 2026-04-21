/*
 * Problem: 1801. Number of Orders in the Backlog
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-orders-in-the-backlog/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sells = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        long res = 0;
        for (int[] order : orders) {
            if (order[2] == 0) {
                while (order[1] > 0 && !sells.isEmpty() && sells.peek()[0] <= order[0]) {
                    if (order[1] > sells.peek()[1]) {
                        int count = sells.poll()[1];
                        res -= count;
                        order[1] -= count;
                    } else if (order[1] < sells.peek()[1]) {
                        res -= order[1];
                        sells.peek()[1] -= order[1];
                        order[1] = 0;
                    } else {
                        res -= sells.poll()[1];
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) {
                    res += order[1];
                    buys.offer(new int[] { order[0], order[1] });
                }
            } else {
                while (order[1] > 0 && !buys.isEmpty() && buys.peek()[0] >= order[0]) {
                    if (order[1] > buys.peek()[1]) {
                        int count = buys.poll()[1];
                        res -= count;
                        order[1] -= count;
                    } else if (order[1] < buys.peek()[1]) {
                        res -= order[1];
                        buys.peek()[1] -= order[1];
                        order[1] = 0;
                    } else {
                        res -= buys.poll()[1];
                        order[1] = 0;
                    }
                }
                if (order[1] > 0) {
                    res += order[1];
                    sells.offer(new int[] { order[0], order[1] });
                }
            }
        }
        return (int) (res % 1_000_000_007);
    }
}
