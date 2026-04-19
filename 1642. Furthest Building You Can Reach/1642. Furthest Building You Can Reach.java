/*
 * Problem: 1642. Furthest Building You Can Reach
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/furthest-building-you-can-reach/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int sum=0;
        for (int i=1;i<heights.length;i++)
            if (heights[i]>heights[i-1])
                sum+=heights[i]-heights[i-1];
        if (bricks>=sum) return heights.length-1;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0)
                continue;
            if (PQ.size() < ladders) {
                PQ.add(heights[i] - heights[i - 1]);
            } else if (ladders == 0 || diff <= PQ.peek()) {
                bricks -= diff;
            } else {
                bricks -= PQ.poll();
                PQ.add(diff);
            }
            if (bricks < 0)
                return i - 1;
        }
        return heights.length - 1;
    }
}
