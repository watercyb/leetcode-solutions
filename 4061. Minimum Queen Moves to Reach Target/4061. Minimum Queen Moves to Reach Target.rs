/*
 * Problem: 4061. Minimum Queen Moves to Reach Target
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-queen-moves-to-reach-target/
 * Language: rust
 * Date: 2026-09-27
 */

impl Solution {
    pub fn min_queen_moves(source: Vec<i32>, target: Vec<i32>) -> i32 {
        if source[0]==target[0]&&source[1]==target[1] {
            return 0;
        } else if source[0]==target[0]||source[1]==target[1]||(source[0]-target[0]).abs()==(source[1]-target[1]).abs() {
            return 1;
        } else {
            return 2;
        }
    }
}
