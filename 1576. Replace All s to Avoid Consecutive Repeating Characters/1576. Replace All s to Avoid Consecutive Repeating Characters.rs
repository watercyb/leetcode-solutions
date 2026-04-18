/*
 * Problem: 1576. Replace All ?'s to Avoid Consecutive Repeating Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * Language: rust
 * Date: 2026-04-18
 */

impl Solution {
    pub fn modify_string(s: String) -> String {
        let mut chrs:Vec<char>=s.chars().collect();
        let mut prv=' ';
        for i in 0..chrs.len() {
            if chrs[i]=='?' {
                let next = if i == chrs.len() - 1 {
                    ' '
                } else {
                    chrs[i+1]
                };
                if prv=='a'||next=='a' {
                    if prv=='b'||next=='b' {
                        chrs[i]='c';
                    } else {
                        chrs[i]='b';
                    }
                } else {
                    chrs[i]='a';
                }
            }
            prv=chrs[i];
        }
        return chrs.into_iter().collect();
    }
}
