/*
 * Problem: 1710. Maximum Units on a Truck
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-units-on-a-truck/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] counts = new int[1001];
        for (int[] boxType : boxTypes) {
            counts[boxType[1]] += boxType[0];
        }
        int res = 0;
        for (int i = 1000; i >= 0; i--) {
            if (counts[i] == 0)
                continue;
            if (truckSize >= counts[i]) {
                res += i * counts[i];
                truckSize -= counts[i];
            } else {
                res += truckSize * i;
                return res;
            }
        }
        return res;
    }
}
