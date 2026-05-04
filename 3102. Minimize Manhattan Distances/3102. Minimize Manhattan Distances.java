/*
 * Problem: 3102. Minimize Manhattan Distances
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-manhattan-distances/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int minimumDistance(int[][] points) {
        int max11 = Integer.MIN_VALUE;
        int max12 = Integer.MIN_VALUE;
        int max21 = Integer.MIN_VALUE;
        int max22 = Integer.MIN_VALUE;
        int min11 = Integer.MAX_VALUE;
        int min12 = Integer.MAX_VALUE;
        int min21 = Integer.MAX_VALUE;
        int min22 = Integer.MAX_VALUE;
        int[] idx = new int[4];
        for (int i = 0; i < points.length; i++) {
            int a = points[i][0] + points[i][1];
            int b = points[i][0] - points[i][1];
            if (a > max11) {
                max12 = max11;
                max11 = a;
                idx[0] = i;
            } else if (a > max12) {
                max12 = a;
            }
            if (a < min11) {
                min12 = min11;
                min11 = a;
                idx[1] = i;
            } else if (a < min12) {
                min12 = a;
            }
            if (b > max21) {
                max22 = max21;
                max21 = b;
                idx[2] = i;
            } else if (b > max22) {
                max22 = b;
            }
            if (b < min21) {
                min22 = min21;
                min21 = b;
                idx[3] = i;
            } else if (b < min22) {
                min22 = b;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            int a = (idx[0] == idx[i] ? max12 : max11) - (idx[1] == idx[i] ? min12 : min11);
            int b = (idx[2] == idx[i] ? max22 : max21) - (idx[3] == idx[i] ? min22 : min21);
            res = Math.min(Math.max(a, b), res);
        }
        return res;
    }
}
