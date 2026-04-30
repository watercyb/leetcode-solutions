/*
 * Problem: 2789. Largest Element in an Array after Merge Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn max_array_value(nums: Vec<i32>) -> i64 {
        let mut res: i64=0;
        let mut sum=nums[nums.len()-1] as i64;
        for i in (0..nums.len()-1).rev() {
            let num=nums[i] as i64;
            if num<=sum {
                sum+=num;
            } else {
                res=res.max(sum);
                sum=num;
            }
        }
        res=res.max(sum);
        return res;
    }
}
