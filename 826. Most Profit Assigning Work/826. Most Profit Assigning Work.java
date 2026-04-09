/*
 * Problem: 826. Most Profit Assigning Work
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/most-profit-assigning-work/
 * Language: java
 * Date: 2026-04-09
 */

import java.awt.Point;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Point[] jobs = new Point[N];
        for (int i = 0; i < N; ++i)
            jobs[i] = new Point(difficulty[i], profit[i]);
        Arrays.sort(jobs, (a, b) -> a.x - b.x);
        Arrays.sort(worker);

        int ans = 0, i = 0, best = 0;
        for (int skill: worker) {
            while (i < N && skill >= jobs[i].x)
                best = Math.max(best, jobs[i++].y);
            ans += best;
        }

        return ans;
    }
}
