/*
 * Problem: 1844. Replace All Digits with Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/replace-all-digits-with-characters/
 * Language: rust
 * Date: 2026-04-21
 */

impl Solution {
    pub fn replace_digits(s: String) -> String {
        let mut res=String::new();
        let mut prv='#';
        for chr in s.chars() {
            if prv=='#' {
                res.push(chr);
                prv=chr;
            } else {
                res.push(((prv as u8 - b'a' + chr as u8 - b'0')%26 + b'a') as char);
                prv='#';
            }
        }
        return res;
    }
}
