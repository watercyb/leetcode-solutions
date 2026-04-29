/*
 * Problem: 2610. Convert an Array Into a 2D Array With Conditions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int[][] arr=new int[nums.length][nums.length+1];
        int n=0;
        for (int i=0;i<nums.length;i++) {
            int j=0;
            while (arr[j][nums[i]]!=0) j++;
            if (j==n) {
                res.add(new ArrayList<>());
                n++;
            }
                res.get(j).add(nums[i]);
                arr[j][nums[i]]=1;
            
        }
        return res;
        
    }
}
