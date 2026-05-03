/*
 * Problem: 3065. Minimum Operations to Exceed Threshold Value I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i/
 * Language: rust
 * Date: 2026-05-03
 */

impl Solution {
    pub fn min_operations(nums: Vec<i32>, k: i32) -> i32 {
        let mut res=0;
        for num in nums {
            if num<k {
                res+=1;
            }
        }
        return res;
    }
}
