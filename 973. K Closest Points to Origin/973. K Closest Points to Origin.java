/*
 * Problem: 973. K Closest Points to Origin
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/k-closest-points-to-origin/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        QS(points, 0, points.length - 1, k);
        return Arrays.copyOf(points, k);
    }

    public void QS(int[][] points, int l, int r, int k) {
        int idx = (l + r) >>> 1;
        int pivot = getDist(points, idx);
        swap(points, idx, r);
        int j = l;
        for (int i = l; i <= r; i++) {
            if (getDist(points, i) <= pivot) {
                swap(points, i, j);
                j++;
            }
        }
        if (j > k) {
            QS(points, l, j - 2, k);
        } else if (j < k) {
            QS(points, j, r, k);
        }
    }

    public void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int getDist(int[][] points, int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
}
