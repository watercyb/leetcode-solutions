/*
 * Problem: 3120. Count the Number of Special Characters I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-the-number-of-special-characters-i/
 * Language: rust
 * Date: 2026-05-04
 */

impl Solution {
    pub fn number_of_special_chars(word: String) -> i32 {
        let mut seens=[0;26];
        for chr in word.chars() {
            if chr.is_ascii_lowercase() {
                let idx=(chr as u8 - b'a') as usize;
                seens[idx]|=1;
            } else {
                let idx=(chr as u8 - b'A') as usize;
                seens[idx]|=2;
            }
        }
        let mut res=0;
        for c in seens {
            if c==3 {
                res+=1;
            }
        }
        return res;
    }
}
