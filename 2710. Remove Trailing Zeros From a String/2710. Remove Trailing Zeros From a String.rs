/*
 * Problem: 2710. Remove Trailing Zeros From a String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-trailing-zeros-from-a-string/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn remove_trailing_zeros(num: String) -> String {
        let mut idx=num.len()-1;
        let chrs: Vec<char>=num.chars().collect();
        while idx>=0 && chrs[idx]=='0' {
            idx-=1;
        }
        return num[..idx+1].to_string();
    }
}
