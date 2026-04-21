/*
 * Problem: 1816. Truncate Sentence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/truncate-sentence/
 * Language: rust
 * Date: 2026-04-21
 */

impl Solution {
    pub fn truncate_sentence(s: String, k: i32) -> String {
        return s.split(" ").take(k as usize).collect::<Vec<_>>().join(" ");
    }
}
