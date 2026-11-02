/*
 * Problem: 4097. Minimum Value of Merged Integers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-value-of-merged-integers/
 * Language: rust
 * Date: 2026-11-02
 */

impl Solution {
    pub fn min_merged_integer(nums: Vec<i32>) -> i32 {
        let mut res=100000000;
        for i in (0..nums.len()).step_by(2) {
            let mut num=nums[i];
            let mut n=nums[i+1];
            while n>0 {
                num*=10;
                n/=10;
            }
            num+=nums[i+1];
            res=res.min(num);
        }
        return res;
    }
}
