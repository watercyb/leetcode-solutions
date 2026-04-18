/*
 * Problem: 1551. Minimum Operations to Make Array Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 * Language: rust
 * Date: 2026-04-18
 */

impl Solution {
    pub fn min_operations(n: i32) -> i32 {
        if n%2==1 {
            return (n-1)*(n+1)/4
        } else {
            return n*n/4
        }
    }
}
