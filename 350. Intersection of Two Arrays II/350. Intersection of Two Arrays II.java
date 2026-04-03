/*
 * Problem: 350. Intersection of Two Arrays II
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] counts = new int[1001];
        for (int num : nums1) {
            counts[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (counts[num]-- > 0)
                list.add(num);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
