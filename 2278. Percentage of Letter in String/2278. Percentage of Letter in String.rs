/*
 * Problem: 2278. Percentage of Letter in String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/percentage-of-letter-in-string/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn percentage_letter(s: String, letter: char) -> i32 {
        let mut count=0;
        for chr in s.chars() {
            if chr==letter {
                count+=1;
            }
        }
        return count*100/s.len() as i32;
    }
}
