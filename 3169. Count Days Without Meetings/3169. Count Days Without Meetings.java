/*
 * Problem: 3169. Count Days Without Meetings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-days-without-meetings/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int res = 0;
        int lim = 0;
        for (int[] meeting : meetings) {
            if (meeting[0] > lim) {
                res += meeting[0] - lim - 1;
                lim = meeting[1];
            } else if (meeting[1] > lim) {
                lim = meeting[1];
            }
        }
        return res + days - lim;
    }
}
