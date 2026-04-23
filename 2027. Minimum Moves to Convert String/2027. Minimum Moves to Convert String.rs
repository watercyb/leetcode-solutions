/*
 * Problem: 2027. Minimum Moves to Convert String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-moves-to-convert-string/
 * Language: rust
 * Date: 2026-04-23
 */

impl Solution {
    pub fn minimum_moves(s: String) -> i32 {
        let chars=s.as_bytes();
        let mut idx=0;
        let mut res=0;
        while idx<s.len() {
            if chars[idx] as char=='X' {
                res+=1;
                idx+=3;
            } else {
                idx+=1;
            }
        }
        return res
    }
}
