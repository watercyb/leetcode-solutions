/*
 * Problem: 3074. Apple Redistribution into Boxes
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/apple-redistribution-into-boxes/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int[] counts = new int[51];
        for (int num : capacity) {
            counts[num]++;
        }
        int sum = 0;
        for (int num : apple) {
            sum += num;
        }
        int res = 1;
        for (int i = counts.length - 1; i >= 0; i--) {
            while (counts[i] > 0) {
                sum -= i;
                if (sum <= 0)
                    return res;
                res++;
                counts[i]--;
            }

        }
        return res;
    }
}
