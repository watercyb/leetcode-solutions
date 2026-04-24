/*
 * Problem: 2124. Check if All A's Appears Before All B's
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn check_string(s: String) -> bool {
        let mut seen=false;
        for chr in s.chars() {
            if chr=='b' {
                seen=true;
            } else if seen {
                return false;
            }
        }
        return true;
    }
}
