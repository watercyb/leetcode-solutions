/*
 * Problem: 1871. Jump Game VII
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/jump-game-vii/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int[] DP = new int[s.length()];
        for (int i = minJump; i < s.length(); i++) {
            DP[i] = '1' - s.charAt(i);
        }
        DP[0] = 1;
        int count = 0;
        for (int i = minJump; i < DP.length; i++) {
            count += DP[i - minJump];
            if (count == 0) {
                DP[i] = 0;
            }
            if (i >= maxJump)
                count -= DP[i - maxJump];
        }
        return DP[DP.length - 1] == 1;
    }
}
