/*
 * Problem: 760. Find Anagram Mappings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-anagram-mappings/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            HM.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = HM.get(nums1[i]);
        }
        return res;
    }
}
