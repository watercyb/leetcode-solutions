/*
 * Problem: 702. Search in a Sorted Array of Unknown Size
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 * Language: java
 * Date: 2026-04-08
 */

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int r = 10000;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int num = reader.get(mid);
            if (num > target) {
                r = mid;
            } else if (num < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
