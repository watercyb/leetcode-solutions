/*
 * Problem: 2746. Decremental String Concatenation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/decremental-string-concatenation/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn minimize_concatenated_length(words: Vec<String>) -> i32 {
        let mut dp: [[usize; 26]; 26] = [[100000000; 26]; 26];
        let (l, r)=Self::getPair(&words[0]);
        dp[l][r]=words[0].len();
        for i in 1..words.len() {
            let mut dp_next: [[usize; 26]; 26] = [[100000000; 26]; 26];
            let (l, r)=Self::getPair(&words[i]);
            let length=words[i].len();
            for j in 0..26 {
                for k in 0..26 {
                    if k==l {
                        dp_next[j][r]=dp_next[j][r].min(dp[j][k]+length-1);
                    } else {
                        dp_next[j][r]=dp_next[j][r].min(dp[j][k]+length);
                    }
                    if j==r {
                        dp_next[l][k]=dp_next[l][k].min(dp[j][k]+length-1);
                    } else {
                        dp_next[l][k]=dp_next[l][k].min(dp[j][k]+length);
                    }
                }
            }
            dp=dp_next;
        }
        let mut res=100000000;
        for i in 0..26 {
            for j in 0..26 {
                res=res.min(dp[i][j]);
            }
        }
        return res as i32;
    }

    pub fn getPair(word: &String) -> (usize, usize) {
        return ((word.as_bytes()[0] - b'a') as usize, (word.as_bytes()[word.len()-1] - b'a') as usize);
    }
}
