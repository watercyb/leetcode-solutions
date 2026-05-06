/*
 * Problem: 3400. Maximum Number of Matching Indices After Right Shifts
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-matching-indices-after-right-shifts/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        HashMap<Integer, List<Integer>> HM = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!HM.containsKey(nums2[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                HM.put(nums2[i], list);
            } else {
                HM.get(nums2[i]).add(i);
            }
        }
        int[] counts = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (HM.containsKey(nums1[i])) {
                for (int idx : HM.get(nums1[i])) {
                    counts[(i - idx + nums1.length) % nums1.length]++;
                }
            }
        }
        int res = 0;
        for (int count : counts) {
            res = Math.max(count, res);
        }
        return res;
    }
}
