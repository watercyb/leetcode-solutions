/*
 * Problem: 1784. Check if Binary String Has at Most One Segment of Ones
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        let mut hasZero=false;
        for chr in s.chars() {
            if chr=='1'&&hasZero {
                return false;
            }
            if chr=='0' {
                hasZero=true;
            }
        }
        return true;
    }
}
