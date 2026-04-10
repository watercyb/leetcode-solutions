/*
 * Problem: 954. Array of Doubled Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/array-of-doubled-pairs/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int maxP = 0;
        int maxN = 0;
        int countP = 0;
        int countN = 0;
        int zero = 0;
        for (int num : arr) {
            if (num > 0) {
                maxP = Math.max(maxP, num);
                countP++;
            } else if (num < 0) {
                maxN = Math.min(maxN, num);
                countN++;
            } else {
                zero++;
            }
        }
        if (zero % 2 == 1 || countP % 2 == 1 || countN % 2 == 1)
            return false;
        int[] countsP = new int[maxP + 1];
        int[] countsN = new int[-maxN + 1];
        for (int num : arr) {
            if (num > 0) {
                countsP[num]++;
            } else if (num < 0) {
                countsN[-num]++;
            }
        }
        for (int i = 1; i <= maxP; i++) {
            if (countsP[i] != 0) {
                if (2 * i > maxP || countsP[2 * i] < countsP[i])
                    return false;
                countsP[2 * i] -= countsP[i];
            }
        }
        for (int i = 1; i <= -maxN; i++) {
            if (countsN[i] != 0) {
                if (2 * i > -maxN || countsN[2 * i] < countsN[i])
                    return false;
                countsN[2 * i] -= countsN[i];
            }
        }
        return true;
    }
}
