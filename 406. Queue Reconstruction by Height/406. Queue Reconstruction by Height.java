/*
 * Problem: 406. Queue Reconstruction by Height
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/queue-reconstruction-by-height/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            res.add(people[i][1], people[i]);
        }
        return res.toArray(new int[people.length][2]);
    }
}
