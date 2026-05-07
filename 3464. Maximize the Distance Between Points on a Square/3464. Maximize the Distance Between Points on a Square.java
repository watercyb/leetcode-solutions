/*
 * Problem: 3464. Maximize the Distance Between Points on a Square
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        long[] arr = new long[points.length];
        int idx = 0;
        for (int[] point : points) {
            if (point[0] == 0) {
                arr[idx++] = point[1];
            } else if (point[0] == side) {
                arr[idx++] = 3l * side - point[1];
            } else if (point[1] == side) {
                arr[idx++] = side + point[0];
            } else {
                arr[idx++] = 4l * side - point[0];
            }
        }
        Arrays.sort(arr);
        long first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1] - arr[i];
        }
        arr[arr.length - 1] = first - arr[arr.length - 1] + 4l * side;
        int l = 0;
        int r = side + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(arr, mid, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(long[] arr, int mid, int k) {
        int[] next = new int[arr.length];
        long sum = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (sum < mid) {
                sum += arr[j];
                j = (j + 1) % arr.length;
            }
            if (i == j)
                return false;
            next[i] = j;
            sum -= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            if (chk(next, i, k))
                return true;
        }
        return false;
    }

    public boolean chk(int[] next, int i, int k) {
        int j = i;
        int change = 0;
        while (k > 0 && !(change == 2 || (change == 1 && j > i))) {
            k--;
            if (next[j] < j)
                change++;
            j = next[j];
        }
        if (change == 2 || (change == 1 && j > i) || k > 0)
            return false;
        return true;
    }
}
