/*
 * Problem: 517. Super Washing Machines
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/super-washing-machines/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0)
            return -1;
        int target = sum / machines.length;
        int res = 0;
        sum = 0;
        for (int i = 0; i < machines.length; i++) {
            int diff = machines[i] - target;
            res = Math.max(Math.max(diff, Math.abs(sum)), res);
            sum = sum + diff;
        }
        return res;
    }
}
