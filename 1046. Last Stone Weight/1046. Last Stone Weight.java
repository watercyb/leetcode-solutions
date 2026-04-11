/*
 * Problem: 1046. Last Stone Weight
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/last-stone-weight/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] counts = new int[1001];
        int max = 0;
        for (int stone : stones) {
            counts[stone]++;
            max = Math.max(stone, max);
        }
        int prv = 0;
        for (int i = max; i >= 1; i--) {
            while (counts[i] > 0) {
                if (prv == 0) {
                    if ((counts[i] & 1) == 1)
                        prv = i;
                    break;
                } else if (prv > 0) {
                    if (prv - i == i) {
                        counts[i] = (counts[i] + 1) & 1;
                        prv = i;
                    } else if (prv - i < i) {
                        counts[prv - i]++;
                        prv = 0;
                        counts[i]--;
                    } else {
                        prv = prv - i;
                        counts[i]--;
                    }
                }
            }
        }
        return prv;
    }
}
