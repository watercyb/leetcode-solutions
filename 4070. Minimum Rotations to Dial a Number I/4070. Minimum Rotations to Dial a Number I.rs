/*
 * Problem: 4070. Minimum Rotations to Dial a Number I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-rotations-to-dial-a-number-i/
 * Language: rust
 * Date: 2026-10-05
 */

impl Solution {
    pub fn min_rotations(s: String) -> i32 {
        let mut current=0;
        let mut res=0;
        for chr in s.chars() {
            let idx=(chr as u8 - b'0') as i32;
            let diff=(current-idx).abs();
            res+=diff.min(10-diff);
            current=idx;
        }
        return res;
    }
}
