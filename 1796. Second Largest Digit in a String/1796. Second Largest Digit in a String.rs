/*
 * Problem: 1796. Second Largest Digit in a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/second-largest-digit-in-a-string/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn second_highest(s: String) -> i32 {
        let mut seens=[false;10];
        for c in s.chars() {
            if c.is_numeric() {
                let idx=c as usize - b'0' as usize;
                seens[idx]=true;
            }
        }
        let mut count=0;
        for i in (0..=9).rev() {
            if seens[i] {
                if count==1 {
                    return i as i32;
                } else {
                    count+=1;
                }
            }
        }
        return -1;
    }
}
