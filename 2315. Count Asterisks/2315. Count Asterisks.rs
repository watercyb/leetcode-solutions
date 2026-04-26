/*
 * Problem: 2315. Count Asterisks
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-asterisks/
 * Language: rust
 * Date: 2026-04-26
 */

impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        let mut isOut=true;
        let mut res=0;
        for chr in s.chars() {
            if chr=='|' {
                isOut=!isOut;
            } else if chr=='*' && isOut {
                res+=1;
            }
        }
        return res;
    }
}
