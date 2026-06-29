/*
 * Problem: 3974. Maximum Total Sum of K Selected Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-sum-of-k-selected-elements/
 * Language: rust
 * Date: 2026-06-29
 */

impl Solution {
    pub fn max_sum(nums: Vec<i32>, k: i32, mul: i32) -> i64 {
        let mut nums=nums;
        nums.sort();
        let mut res=0 as i64;
        let mut mul=mul as i64;
        let mut k=k;
        for i in (0..nums.len()).rev() {
            if k==0 {
                break;
            }
            if mul>0 {
                res+=nums[i] as i64 * mul;
                mul-=1;
            } else {
                res+=nums[i] as i64;
            }
            k-=1;
        }
        return res;
    }
}
