/*
 * Problem: 2871. Split Array Into Maximum Number of Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/split-array-into-maximum-number-of-subarrays/
 * Language: rust
 * Date: 2026-05-01
 */

impl Solution {
    pub fn max_subarrays(nums: Vec<i32>) -> i32 {
        let mut target=nums[0];
        for i in 1..nums.len() {
            target&=nums[i];
        }
        if target!=0 {
            return 1;
        }
        let mut res=0;
        let mut and=0;
        for &num in &nums {
            if and==0 {
                res+=1;
                and=num;
            } else {
                and&=num;
            }
        }
        if and!=0 {
            res-=1;
        }
        return res;
    }
}
