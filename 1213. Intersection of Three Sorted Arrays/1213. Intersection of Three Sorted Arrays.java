/*
 * Problem: 1213. Intersection of Three Sorted Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-three-sorted-arrays/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] counts = new int[2001];
        for (int i = 0; i < arr1.length; i++) {
            counts[arr1[i]]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            counts[arr2[i]]++;
        }
        for (int i = 0; i < arr3.length; i++) {
            counts[arr3[i]]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 3)
                res.add(i);
        }
        return res;
    }
}
