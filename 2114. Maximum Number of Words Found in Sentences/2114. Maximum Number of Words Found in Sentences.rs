/*
 * Problem: 2114. Maximum Number of Words Found in Sentences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn most_words_found(sentences: Vec<String>) -> i32 {
        return sentences.iter().map(|str| str.split(" ").count()).max().unwrap() as i32
    }
}
