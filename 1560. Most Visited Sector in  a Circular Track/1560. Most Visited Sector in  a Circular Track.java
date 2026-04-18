/*
 * Problem: 1560. Most Visited Sector in  a Circular Track
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int a = rounds[0];
        int b = rounds[rounds.length - 1];
        List<Integer> res = new ArrayList<>();
        if (a <= b) {
            for (int i = a; i <= b; i++) {
                res.add(i);
            }
        } else {
            for (int i = 1; i <= b; i++) {
                res.add(i);
            }
            for (int i = a; i <= n; i++) {
                res.add(i);
            }
        }
        return res;
    }
}
