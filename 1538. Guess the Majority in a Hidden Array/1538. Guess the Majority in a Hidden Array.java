/*
 * Problem: 1538. Guess the Majority in a Hidden Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/guess-the-majority-in-a-hidden-array/
 * Language: java
 * Date: 2026-04-18
 */

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public:
 * // Compares 4 different elements in the array
 * // return 4 if the values of the 4 elements are the same (0 or 1).
 * // return 2 if three elements have a value equal to 0 and one element has
 * value equal to 1 or vice versa.
 * // return 0 : if two element have a value equal to 0 and two elements have a
 * value equal to 1.
 * public int query(int a, int b, int c, int d);
 *
 * // Returns the length of the array
 * public int length();
 * };
 */

class Solution {
    public int guessMajority(ArrayReader reader) {
        int l = reader.length();
        int sum = 0;
        int idx = -1;
        if (reader.query(0, 2, 3, 4) != reader.query(1, 2, 3, 4)) {
            idx = 1;
            sum++;
        }
        if (reader.query(0, 1, 3, 4) != reader.query(1, 2, 3, 4)) {
            idx = 2;
            sum++;
        }
        if (reader.query(0, 1, 2, 4) != reader.query(1, 2, 3, 4)) {
            idx = 3;
            sum++;
        }
        int initial = reader.query(0, 1, 2, 3);
        for (int i = 4; i < l; i++) {
            if (reader.query(1, 2, 3, i) != initial) {
                idx = i;
                sum++;
            }
        }
        if (sum * 2 == l) {
            return -1;
        } else if (sum * 2 > l) {
            return idx;
        } else {
            return 0;
        }
    }
}
