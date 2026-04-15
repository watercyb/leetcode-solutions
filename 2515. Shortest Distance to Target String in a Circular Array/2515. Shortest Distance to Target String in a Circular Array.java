/*
 * Problem: 2515. Shortest Distance to Target String in a Circular Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/?envType=daily-question&envId=2026-04-15
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(startIndex - i);
                res = Math.min(Math.min(dist, words.length - dist), res);
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
