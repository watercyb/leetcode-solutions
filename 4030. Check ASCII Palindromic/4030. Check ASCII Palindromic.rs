/*
 * Problem: 4030. Check ASCII Palindromic
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-ascii-palindromic/
 * Language: rust
 * Date: 2026-08-26
 */

impl Solution {
    pub fn is_palindromic(s: String) -> bool {
        let chrs: Vec<char>=s.chars().collect();
        let mut l=0 as i32;
        let mut r=(s.len()-1) as i32;
        while l<=r {
            if chrs[l as usize]!=Self::rev(chrs[r as usize]) {
                return false;
            }
            l+=1;
            r-=1;
        }
        return true;
    }

    pub fn rev(chr: char) -> char {
        let mut num=chr as u8;
        let mut res=0;
        for i in 0..8 {
            res=res*2+num%2;
            num/=2;
        }
        return res as char;
    }
}
