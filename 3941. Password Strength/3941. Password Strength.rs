/*
 * Problem: 3941. Password Strength
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/password-strength/
 * Language: rust
 * Date: 2026-05-26
 */

impl Solution {
    pub fn password_strength(password: String) -> i32 {
        let mut seens=vec![false;256];
        let mut res=0;
        for chr in password.chars() {
            let idx=chr as usize;
            if !seens[idx] {
                seens[idx]=true;
                if chr.is_lowercase() {
                    res+=1;
                } else if chr.is_uppercase() {
                    res+=2;
                } else if chr.is_ascii_digit() {
                    res+=3;
                } else {
                    res+=5;
                }
            }
        }
        return res;
    }
}
