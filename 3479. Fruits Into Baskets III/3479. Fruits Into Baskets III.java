/*
 * Problem: 3479. Fruits Into Baskets III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fruits-into-baskets-iii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int size = (int) Math.pow(2, Math.ceil(Math.log(fruits.length) / Math.log(2)));
        int[] segment = new int[2 * size - 1];
        for (int i = 0; i < fruits.length; i++) {
            segment[size - 1 + i] = baskets[i];
        }
        for (int i = size - 2; i >= 0; i--) {
            segment[i] = Math.max(segment[2 * i + 1], segment[2 * i + 2]);
        }
        int res = 0;
        for (int fruit : fruits) {
            if (segment[0] < fruit) {
                res++;
            } else {
                getMin(segment, 0, fruit);
            }
        }
        return res;
    }

    public int getMin(int[] segment, int i, int target) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l >= segment.length)
            return segment[i] = 0;
        if (segment[l] >= target) {
            segment[i] = Math.max(getMin(segment, l, target), segment[r]);
        } else if (segment[r] >= target) {
            segment[i] = Math.max(getMin(segment, r, target), segment[l]);
        }
        return segment[i];
    }
}
