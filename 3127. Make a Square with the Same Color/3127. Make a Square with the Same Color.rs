/*
 * Problem: 3127. Make a Square with the Same Color
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/make-a-square-with-the-same-color/
 * Language: rust
 * Date: 2026-05-04
 */

impl Solution {
    pub fn can_make_square(grid: Vec<Vec<char>>) -> bool {
        for i in 0..grid.len()-1 {
            for j in 0..grid[0].len()-1 {
                let mut count=0;
                if grid[i][j]=='B' {
                    count+=1;
                }
                if grid[i+1][j]=='B' {
                    count+=1;
                }
                if grid[i][j+1]=='B' {
                    count+=1;
                }
                if grid[i+1][j+1]=='B' {
                    count+=1;
                }
                if count!=2 {
                    return true;
                }
            }
        }
        return false;
    }
}
