/*
 * Problem: 4084. Last Visited Cell in a Directional Grid
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/last-visited-cell-in-a-directional-grid/
 * Language: rust
 * Date: 2026-10-19
 */

impl Solution {
    pub fn last_visited_cell(grid: Vec<Vec<char>>) -> Vec<i32> {
        let mut visiteds = vec![vec![false; grid[0].len()]; grid.len()];
        let mut x: i32=0;
        let mut y: i32=0;
        let mut x_prv: i32=0;
        let mut y_prv: i32=0;
        while true {
            if x<0 || x==grid.len() as i32 || y<0 || y==grid[0].len() as i32 || visiteds[x as usize][y as usize] {
                return vec![x_prv, y_prv];
            }
            x_prv=x;
            y_prv=y;
            visiteds[x as usize][y as usize]=true;
            if grid[x as usize][y as usize]=='L' {
                y-=1;
            } else if grid[x as usize][y as usize]=='R' {
                y+=1;
            } else if grid[x as usize][y as usize]=='U' {
                x-=1;
            } else {
                x+=1;
            }
        }
        return vec![0;0];
    }
}
