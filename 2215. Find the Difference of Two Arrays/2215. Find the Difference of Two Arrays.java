/*
 * Problem: 2215. Find the Difference of Two Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-difference-of-two-arrays/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] counts1 = new boolean[2001];
        boolean[] counts2 = new boolean[2001];
        for (int num1 : nums1) {
            counts1[num1 + 1000] = true;
        }
        for (int num2 : nums2) {
            counts2[num2 + 1000] = true;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < 2001; i++) {
            if (counts1[i] && !counts2[i]) {
                a.add(i - 1000);
            } else if (!counts1[i] && counts2[i]) {
                b.add(i - 1000);
            }
        }
        res.add(a);
        res.add(b);
        return res;
    }
}
