/*
 * Problem: 2255. Count Prefixes of a Given String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-prefixes-of-a-given-string/
 * Language: rust
 * Date: 2026-04-25
 */

use std::collections::HashSet;

impl Solution {
    pub fn count_prefixes(words: Vec<String>, s: String) -> i32 {
        let mut set = HashSet::new();
        for i in 0..s.len() {
            set.insert(&s[0..i+1]);
        }
        let mut res=0;
        for word in &words {
            if set.contains(word.as_str()) {
                res+=1;
            }
        }
        return res;
    }
}
