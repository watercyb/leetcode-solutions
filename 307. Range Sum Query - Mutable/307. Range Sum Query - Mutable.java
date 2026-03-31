/*
 * Problem: 307. Range Sum Query - Mutable
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/range-sum-query-mutable/
 * Language: java
 * Date: 2026-03-31
 */

class NumArray {
    int[] BT;
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        BT = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            updateSum(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        updateSum(index + 1, val - nums[index]);
        nums[index]=val;
    }

    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
    }

    public void updateSum(int i, int num) {
        while (i < BT.length) {
            BT[i] += num;
            i += i & -i;
        }
    }

    public int getSum(int i) {
        if (i == 0)
            return 0;
        int sum = 0;
        while (i > 0) {
            sum += BT[i];
            i -= i & -i;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
