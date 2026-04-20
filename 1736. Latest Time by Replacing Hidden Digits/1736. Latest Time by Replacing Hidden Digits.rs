/*
 * Problem: 1736. Latest Time by Replacing Hidden Digits
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn maximum_time(time: String) -> String {
        let mut chrs: Vec<char> = time.chars().collect();
        if chrs[0]=='?' && chrs[1]=='?' {
            chrs[0]='2';
            chrs[1]='3';
        } else if chrs[0]=='?' {
            if chrs[1]<='3' {
                chrs[0]='2';
            } else {
                chrs[0]='1';
            }
        } else if chrs[1]=='?' {
            if chrs[0]<='1' {
                chrs[1]='9';
            } else {
                chrs[1]='3';
            }
        }
        if chrs[3]=='?' {
           chrs[3]='5';
        }
        if chrs[4]=='?' {
           chrs[4]='9';
        }
        return chrs.into_iter().collect();
    }
}
