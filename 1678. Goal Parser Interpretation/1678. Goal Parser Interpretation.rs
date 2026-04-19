/*
 * Problem: 1678. Goal Parser Interpretation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/goal-parser-interpretation/
 * Language: rust
 * Date: 2026-04-19
 */

impl Solution {
    pub fn interpret(command: String) -> String {
        return command.replace("(al)", "al").replace("()", "o");
    }
}
