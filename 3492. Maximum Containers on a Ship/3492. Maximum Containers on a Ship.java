/*
 * Problem: 3492. Maximum Containers on a Ship
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-containers-on-a-ship/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(maxWeight / w,  n * n);
    }
}
