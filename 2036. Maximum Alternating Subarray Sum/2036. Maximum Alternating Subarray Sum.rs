/*
 * Problem: 2036. Maximum Alternating Subarray Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-alternating-subarray-sum/
 * Language: rust
 * Date: 2026-04-23
 */

impl Solution {
    pub fn maximum_alternating_subarray_sum(nums: Vec<i32>) -> i64 {
        let mut even=0;
        let mut odd=i64::MIN/2;
        let mut sum=0 as i64;
        let mut p=1;
        let mut res=i64::MIN;
        for num in &nums {
            sum+=(p*num) as i64;
            res=res.max(sum-even).max(odd-sum);
            if p==-1 {
                even=even.min(sum);
            } else {
                odd=odd.max(sum);
            }
            p=-p;
        }
        return res;
    }
}
