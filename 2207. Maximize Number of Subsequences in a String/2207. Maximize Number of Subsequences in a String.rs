/*
 * Problem: 2207. Maximize Number of Subsequences in a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn maximum_subsequence_count(text: String, pattern: String) -> i64 {
        let p:Vec<char>=pattern.chars().collect();
        let mut count1=0;
        let mut count2=0;
        let mut res=0 as i64;
        for chr in text.chars() {
            if chr==p[1] {
                res+=count1;
                count2+=1;
            }
            if chr==p[0] {
                count1+=1;
            } 
        }
        return res+count1.max(count2);
    }
}
