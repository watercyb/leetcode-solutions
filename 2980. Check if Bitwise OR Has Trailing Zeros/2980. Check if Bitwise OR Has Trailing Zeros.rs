/*
 * Problem: 2980. Check if Bitwise OR Has Trailing Zeros
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-bitwise-or-has-trailing-zeros/
 * Language: rust
 * Date: 2026-05-02
 */

impl Solution {
    pub fn has_trailing_zeros(nums: Vec<i32>) -> bool {
        let mut count=0;
        for num in nums {
            count+=1-(num&1);
        }
        return count>=2;
    }
}
