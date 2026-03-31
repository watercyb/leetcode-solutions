/*
 * Problem: 303. Range Sum Query - Immutable
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/range-sum-query-immutable/
 * Language: java
 * Date: 2026-03-31
 */

class NumArray {
    int[] nums;
    int[] res;
    public NumArray(int[] nums) {
        this.nums=nums;
        res=new int[nums.length];
        res[0]=nums[0];
        for (int i=1;i<nums.length;i++) {
            res[i]=res[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
            return res[right]-res[left]+nums[left];
    }
        
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
