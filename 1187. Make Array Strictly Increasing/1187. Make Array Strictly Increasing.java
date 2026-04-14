/*
 * Problem: 1187. Make Array Strictly Increasing
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/make-array-strictly-increasing/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> TS = new TreeSet<>();
        for (int in : arr2) {
            TS.add(in);
        }
        Integer[] ar2 = TS.toArray(new Integer[TS.size()]);
        int[] DP = new int[arr1.length + 2];
        Arrays.fill(DP, Integer.MAX_VALUE / 2);
        DP[0] = 0;
        int[] tmp = new int[arr1.length + 2];
        System.arraycopy(arr1, 0, tmp, 1, arr1.length);
        tmp[0] = -1;
        tmp[arr1.length + 1] = Integer.MAX_VALUE;
        for (int i = 1; i <= arr1.length + 1; i++) {
            if (tmp[i] > tmp[i - 1])
                DP[i] = DP[i - 1];
            int idx = BS(ar2, tmp[i]);
            for (int j = i - 1; j > 0 && idx >= 0; j--, idx--) {
                if (ar2[idx] > tmp[j - 1])
                    DP[i] = Math.min(DP[j - 1] + i - j, DP[i]);
                if (i - j >= DP[i])
                    break;
            }
        }
        if (DP[arr1.length + 1] == Integer.MAX_VALUE / 2)
            return -1;
        return DP[arr1.length + 1];
    }

    public int BS(Integer[] arr, int num) {
        int l = -1;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (arr[mid] >= num) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }
}
