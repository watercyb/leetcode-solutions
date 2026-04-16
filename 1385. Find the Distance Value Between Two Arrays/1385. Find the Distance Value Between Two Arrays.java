/*
 * Problem: 1385. Find the Distance Value Between Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int[] counts1 = new int[2001];
        int[] counts2 = new int[2001];
        for (int num : arr1) {
            counts1[num + 1000]++;
        }
        for (int num : arr2) {
            counts2[num + 1000]++;
        }
        int j = 0;
        int res = arr1.length;
        for (int i = 0; i <= 2000; i++) {
            if (counts1[i] == 0)
                continue;
            while (j <= 2000 && (i - j > d || counts2[j] == 0)) {
                j++;
            }
            if (j == 2001)
                return res;
            if (Math.abs(i - j) <= d)
                res -= counts1[i];
        }
        return res;
    }
}
