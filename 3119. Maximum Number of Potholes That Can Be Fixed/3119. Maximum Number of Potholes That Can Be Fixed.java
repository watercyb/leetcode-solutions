/*
 * Problem: 3119. Maximum Number of Potholes That Can Be Fixed
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-potholes-that-can-be-fixed/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maxPotholes(String road, int budget) {
        int[] counts = new int[road.length() + 1];
        int count = 0;
        for (char chr : road.toCharArray()) {
            if (chr == '.') {
                counts[count]++;
                count = 0;
            } else {
                count++;
            }
        }
        counts[count]++;
        int res = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            for (int j = 0; j < counts[i]; j++) {
                if (budget > i + 1) {
                    res += i;
                    budget -= i + 1;
                } else {
                    res += budget - 1;
                    return res;
                }
            }
        }
        return res;
    }
}
