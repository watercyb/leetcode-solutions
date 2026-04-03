/*
 * Problem: 373. Find K Pairs with Smallest Sums
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] idx = new int[nums1.length];
        int last = 0;
        while (k > 0) {
            while (last < nums1.length && idx[last] == nums2.length)
                last++;
            if (last == nums1.length)
                break;
            int[] min = { -1, Integer.MAX_VALUE };
            for (int i = last; i < nums1.length; i++) {
                if (nums1[i] + nums2[idx[i]] < min[1]) {
                    min[0] = i;
                    min[1] = nums1[i] + nums2[idx[i]];
                }
                if (idx[i] == 0)
                    break;
            }
            res.add(Arrays.asList(new Integer[] { nums1[min[0]], nums2[idx[min[0]]] }));
            idx[min[0]]++;
            k--;
        }
        return res;

    }
}

