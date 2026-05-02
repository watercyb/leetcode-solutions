/*
 * Problem: 2923. Find Champion I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-champion-i/
 * Language: rust
 * Date: 2026-05-02
 */

impl Solution {
    pub fn find_champion(grid: Vec<Vec<i32>>) -> i32 {
        for i in 0..grid.len() {
            let mut count=0;
            for j in 0..grid[0].len() {
                count+=grid[i][j];
            }
            if count==(grid[0].len()-1) as i32 {
                return i as i32;
            }
        }
        return -1;
    }
}
