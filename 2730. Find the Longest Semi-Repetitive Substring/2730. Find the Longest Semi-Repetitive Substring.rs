/*
 * Problem: 2730. Find the Longest Semi-Repetitive Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn longest_semi_repetitive_substring(s: String) -> i32 {
        let mut dp1=0;
        let mut dp2=0;
        let mut prv='#';
        let mut res=0;
        for chr in s.chars() {
            if chr==prv {
                res=res.max(dp1).max(dp2);
                dp2=dp1+1;
                dp1=1;
            } else {
                dp1+=1;
                dp2+=1;
                prv=chr;
            }
        }
        return res.max(dp1).max(dp2);
    }
}
