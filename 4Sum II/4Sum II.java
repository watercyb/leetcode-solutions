/*
 * Problem: 4Sum II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/4sum-ii/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      HashMap<Integer, Integer> HM=new HashMap<Integer, Integer>();
        int n=0;
        for (int num1: nums1){
            for (int num2: nums2){
                HM.put(num1+num2,HM.getOrDefault(num1+num2,0)+1);
            }
        }
        for (int num3: nums3){
            for (int num4: nums4){
                n+=HM.getOrDefault(-num3-num4,0);
            }
        }
        return n;
    }
}
