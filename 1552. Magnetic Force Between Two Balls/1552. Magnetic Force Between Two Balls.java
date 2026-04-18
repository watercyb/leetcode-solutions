/*
 * Problem: 1552. Magnetic Force Between Two Balls
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/magnetic-force-between-two-balls/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = (position[position.length - 1] - position[0]) / (m - 1) + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(position, m - 1, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int[] position, int m, int mid) {
        int last = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= mid) {
                last = position[i];
                m--;
                if (m == 0)
                    return true;
            }
        }
        return false;
    }
}
