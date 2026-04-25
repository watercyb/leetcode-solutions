/*
 * Problem: 2209. Minimum White Tiles After Covering With Carpets
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char[] chrs = floor.toCharArray();
        int[] DP = new int[chrs.length + 1];
        int sum = 0;
        for (int i = 0; i < chrs.length; i++) {
            sum += chrs[i] - '0';
            DP[i + 1] = sum;
        }
        int[] DPNext = new int[chrs.length + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < numCarpets && res > 0; i++) {
            Arrays.fill(DPNext, Integer.MAX_VALUE / 2);
            DPNext[0] = 0;
            for (int j = 0; j < chrs.length; j++) {
                if (chrs[j] == '0') {
                    DPNext[j + 1] = Math.min(DPNext[j + 1], DPNext[j]);
                } else {
                    DPNext[j + 1] = Math.min(DPNext[j + 1], DPNext[j] + 1);
                    int idx = Math.min(j + carpetLen, chrs.length);
                    DPNext[idx] = Math.min(DPNext[idx], DP[j]);
                }
            }
            int[] temp = DP;
            DP = DPNext;
            DPNext = temp;
            res = Math.min(res, DP[chrs.length]);
        }
        return res;
    }
}
