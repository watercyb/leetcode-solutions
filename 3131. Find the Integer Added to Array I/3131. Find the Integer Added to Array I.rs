/*
 * Problem: 3131. Find the Integer Added to Array I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-integer-added-to-array-i/
 * Language: rust
 * Date: 2026-05-04
 */

impl Solution {
    pub fn added_integer(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        return nums2.iter().min().unwrap()-nums1.iter().min().unwrap();
    }
}
