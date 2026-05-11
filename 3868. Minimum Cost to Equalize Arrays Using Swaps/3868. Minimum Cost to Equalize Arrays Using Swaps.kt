/*
 * Problem: 3868. Minimum Cost to Equalize Arrays Using Swaps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-equalize-arrays-using-swaps/
 * Language: kotlin
 * Date: 2026-05-11
 */

class Solution {
    fun minCost(nums1: IntArray, nums2: IntArray): Int {
        var max=0;
        for (num in nums1) {
            max=max(max,num);
        }
        for (num in nums2) {
            max=max(max,num);
        }
        val counts=IntArray(max+1);
        for (i in 0 until nums1.size) {
            counts[nums1[i]]++;
            counts[nums2[i]]--;
        }
        var res=0;
        for (count in counts) {
            if (count%2!=0) return -1;
            if (count>0) {
                res+=count;
            }
        }
        return res/2;
    }
}
