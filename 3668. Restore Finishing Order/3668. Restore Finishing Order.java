/*
 * Problem: 3668. Restore Finishing Order
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/restore-finishing-order/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        boolean[] isFriends = new boolean[101];
        for (int friend : friends) {
            isFriends[friend] = true;
        }
        int[] res = new int[friends.length];
        int idx = 0;
        for (int or : order) {
            if (isFriends[or])
                res[idx++] = or;
        }
        return res;
    }
}
