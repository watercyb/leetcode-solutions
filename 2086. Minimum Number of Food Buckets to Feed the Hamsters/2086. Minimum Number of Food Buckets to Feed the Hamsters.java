/*
 * Problem: 2086. Minimum Number of Food Buckets to Feed the Hamsters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minimumBuckets(String hamsters) {
        char[] chrs = hamsters.toCharArray();
        int prv = 1;
        int res = 0;
        int i = 0;
        while (i < chrs.length) {
            if (chrs[i] == 'H') {
                if (prv == 1) {
                    if (i == hamsters.length() - 1 || chrs[i + 1] == 'H')
                        return -1;
                    res++;
                    prv = 2;
                    i += 2;
                } else if (prv == 0) {
                    if (i == hamsters.length() - 1 || chrs[i + 1] == 'H') {
                        res++;
                        prv = 1;
                        i++;
                    } else {
                        res++;
                        prv = 2;
                        i += 2;
                    }
                } else {
                    prv = 1;
                    i++;
                }
            } else {
                prv = 0;
                i++;
            }
        }
        return res;
    }
}
