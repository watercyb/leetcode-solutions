/*
 * Problem: 1534. Count Good Triplets
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-good-triplets/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > b)
                    continue;
                int l = Math.max(arr[i] - a, arr[j] - c);
                int r = Math.min(arr[i] + a, arr[j] + c);
                if (l > r)
                    continue;
                res += get(r, i) - get(l - 1, i);
            }
            insert(arr[i]);
        }
        return res;
    }

    int[] BIT = new int[1002];

    public void insert(int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i, int num) {
        i++;
        if (i >= BIT.length)
            return num;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
