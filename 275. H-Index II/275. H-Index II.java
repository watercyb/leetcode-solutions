/*
 * Problem: 275. H-Index II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/h-index-ii/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public int hIndex(int[] citations) {
        int l = 1;
        int r = citations.length + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (citations[citations.length - mid] < mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
