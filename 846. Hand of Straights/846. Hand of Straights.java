/*
 * Problem: 846. Hand of Straights
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/hand-of-straights/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] == -1)
                continue;
            int count = 1;
            int prv = hand[i];
            for (int j = i + 1; j < hand.length && count < groupSize; j++) {
                if (hand[j] == prv + 1) {
                    prv = hand[j];
                    hand[j] = -1;
                    count++;
                }
            }
            if (count != groupSize)
                return false;
        }
        return true;
    }
}
