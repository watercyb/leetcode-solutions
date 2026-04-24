/*
 * Problem: 2111. Minimum Operations to Make the Array K-Increasing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-the-array-k-increasing/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int kIncreasing(int[] arr, int k) {
        int res = arr.length;
        int[] DP = new int[(arr.length + k - 1) / k];
        for (int i = 0; i < k; i++) {
            int idx = 1;
            DP[0] = arr[i];
            for (int j = i + k; j < arr.length; j += k) {
                int index = binarySearch(DP, idx, arr[j]);
                DP[index] = arr[j];
                if (index == idx)
                    idx++;
            }
            res -= idx;
        }
        return res;
    }

    public int binarySearch(int[] DP, int r, int num) {
        if (num < DP[0])
            return 0;
        if (num > DP[r - 1])
            return r;
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (DP[mid] > num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
