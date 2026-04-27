/*
 * Problem: 2477. Minimum Fuel Cost to Report to the Capital
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        int[] links = new int[roads.length + 1];
        int[] linkNums = new int[roads.length + 1];
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            links[a] += b;
            links[b] += a;
            linkNums[a]++;
            linkNums[b]++;
        }
        int[] arr = new int[roads.length + 1];
        int idx = 0;
        for (int i = 1; i <= roads.length; i++) {
            if (linkNums[i] == 1)
                arr[idx++] = i;
        }
        int[] counts = new int[roads.length + 1];
        Arrays.fill(counts, 1);
        long res = 0;
        for (int i = 0; i < roads.length; i++) {
            int a = arr[i];
            int b = links[arr[i]];
            links[b] -= a;
            if (b != 0 && --linkNums[b] == 1)
                arr[idx++] = b;
            res += (counts[a] - 1) / seats + 1;
            counts[b] += counts[a];
        }
        return res;
    }
}
