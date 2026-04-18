/*
 * Problem: 1533. Find the Index of the Large Integer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-index-of-the-large-integer/
 * Language: java
 * Date: 2026-04-18
 */

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * // Compares the sum of arr[l..r] with the sum of arr[x..y]
 * // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 * // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 * // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 * public int compareSub(int l, int r, int x, int y) {}
 *
 * // Returns the length of the array
 * public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        return sep(reader, 0, reader.length() - 1);
    }

    public int sep(ArrayReader reader, int l, int r) {
        if (l == r)
            return l;
        if ((r - l) % 2 == 0) {
            int mid = (l + r) >>> 1;
            int compare = reader.compareSub(l, mid - 1, mid + 1, r);
            if (compare == 0) {
                return mid;
            } else if (compare == -1) {
                return sep(reader, mid + 1, r);
            } else {
                return sep(reader, l, mid - 1);
            }
        } else {
            int mid = (l + r) >>> 1;
            int compare = reader.compareSub(l, mid, mid + 1, r);
            if (compare == -1) {
                return sep(reader, mid + 1, r);
            } else {
                return sep(reader, l, mid);
            }
        }
    }
}
