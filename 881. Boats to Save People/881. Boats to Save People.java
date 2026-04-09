/*
 * Problem: 881. Boats to Save People
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/boats-to-save-people/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int max = 0;
        for (int w : people) {
            max = Math.max(w, max);
        }
        int[] counts = new int[max + 1];
        for (int w : people) {
            counts[w]++;
        }
        int i = 0;
        int j = max;
        int res = 0;
        while (i <= j && counts[i] <= 0) {
            i++;
        }
        while (j >= i && counts[j] <= 0) {
            j--;
        }
        while (i <= j) {
            if (i + j <= limit) {
                counts[i]--;
                counts[j]--;
            } else {
                counts[j]--;
            }
            while (i <= j && counts[i] <= 0) {
                i++;
            }
            while (j >= i && counts[j] <= 0) {
                j--;
            }
            res++;
        }
        return res;
    }
}
