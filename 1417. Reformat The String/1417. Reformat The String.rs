/*
 * Problem: 1417. Reformat The String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reformat-the-string/
 * Language: rust
 * Date: 2026-04-17
 */

impl Solution {
    pub fn reformat(s: String) -> String {
        let mut count=0;
        for chr in s.chars() {
            if chr.is_alphabetic() {
                count+=1;
            }
        }
        if (2*count-s.len() as i32).abs()>1 {
            return "".to_string();
        }
        let mut i=0;
        let mut j=1;
        let mut res=vec![' '; s.len()];
        if 2*count>s.len() as i32 {
            for chr in s.chars() {
                if chr.is_alphabetic() {
                    res[i]=chr;
                    i+=2;
                } else {
                    res[j]=chr;
                    j+=2;
                }
            }
        } else {
            for chr in s.chars() {
                if chr.is_alphabetic() {
                    res[j]=chr;
                    j+=2;
                } else {
                    res[i]=chr;
                    i+=2;
                }
            }
        }
        return res.into_iter().collect();
    }
}
