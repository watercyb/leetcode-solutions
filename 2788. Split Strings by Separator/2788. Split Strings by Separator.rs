/*
 * Problem: 2788. Split Strings by Separator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/split-strings-by-separator/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn split_words_by_separator(words: Vec<String>, separator: char) -> Vec<String> {
        let mut res:Vec<String>=Vec::new();
        for word in &words {
            let strs:Vec<&str>= word.split(separator).collect();
            for &str in &strs {
                if str.len()>0 {
                    res.push(str.to_string());
                }
            }
        }
        return res;
    }
}
