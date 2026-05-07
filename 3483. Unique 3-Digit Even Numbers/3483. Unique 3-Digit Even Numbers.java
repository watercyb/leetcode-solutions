/*
 * Problem: 3483. Unique 3-Digit Even Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/unique-3-digit-even-numbers/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int totalNumbers(int[] digits) {
        int[] counts = new int[10];
        for (int digit : digits) {
            counts[digit]++;
        }
        dfs(counts, 0);
        return res;
    }

    int res = 0;

    public void dfs(int[] counts, int i) {
        if (i == 2) {
            for (int j = 0; j < 10; j += 2) {
                if (counts[j] > 0)
                    res++;
            }
        } else if (i == 0) {
            for (int j = 1; j < 10; j++) {
                if (counts[j] > 0) {
                    counts[j]--;
                    dfs(counts, i + 1);
                    counts[j]++;
                }
            }
        } else {
            for (int j = 0; j < 10; j++) {
                if (counts[j] > 0) {
                    counts[j]--;
                    dfs(counts, i + 1);
                    counts[j]++;
                }
            }
        }
    }
}
