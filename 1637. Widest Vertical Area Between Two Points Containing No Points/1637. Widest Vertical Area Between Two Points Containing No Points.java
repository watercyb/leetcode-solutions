/*
 * Problem: 1637. Widest Vertical Area Between Two Points Containing No Points
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] tmp=new int[points.length];
        for (int i=0;i<points.length;i++) {
            tmp[i]=points[i][0];

        }
        Arrays.sort(tmp);
        int max=0;

        for (int i=1;i<points.length;i++) {
            if (tmp[i]-tmp[i-1]>max) max=tmp[i]-tmp[i-1];
        }

        return max;

    }
}
