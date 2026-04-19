/*
 * Problem: 1687. Delivering Boxes from Storage to Ports
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int[] DP = new int[boxes.length + 1];
        int weight = 0;
        int count = 1;
        int j = 0;
        for (int i = 0; i < boxes.length; i++) {
            weight += boxes[i][1];
            if (i == 0 || boxes[i][0] != boxes[i - 1][0])
                count++;
            while (j < i && (i - j >= maxBoxes || weight > maxWeight || DP[j] == DP[j + 1])) {
                weight -= boxes[j][1];
                if (boxes[j][0] != boxes[j + 1][0])
                    count--;
                j++;
            }
            DP[i + 1] = DP[j] + count;
        }
        return DP[boxes.length];
    }
}
