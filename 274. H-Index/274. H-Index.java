/*
 * Problem: 274. H-Index
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/h-index/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int hIndex(int[] citations) {
        int[] counts = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            int tmp = Math.min(citations[i], citations.length);
            counts[tmp]++;
        }
        int sum = 0;
        for (int i = citations.length; i >= 0; i--) {
            sum += counts[i];
            if (sum >= i)
                return i;
        }
        return 0;
    }
}
