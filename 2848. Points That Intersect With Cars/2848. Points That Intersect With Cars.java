/*
 * Problem: 2848. Points That Intersect With Cars
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/points-that-intersect-with-cars/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] Ln=new int[102];
        for (List<Integer> num:nums) {
            Ln[num.get(0)]++;
            Ln[num.get(1)+1]--;
        }

        int res=0;
        int tmp=0;
        for (int i=0;i<101;i++) {
            tmp+=Ln[i];
            if (tmp!=0) {
                res++;
            }
        }
        return res;

    }
}
