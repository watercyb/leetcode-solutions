/*
 * Problem: 825. Friends Of Appropriate Ages
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/friends-of-appropriate-ages/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];
        for (int age : ages) {
            counts[age]++;
        }
        int j = 15;
        int sum = 0;
        int res = 0;
        for (int i = 15; i <= 120; i++) {
            while (j <= i / 2 + 7) {
                sum -= counts[j++];
            }
            res += (sum + counts[i] - 1) * counts[i];
            sum += counts[i];
        }
        return res;
    }
}
