/*
 * Problem: 3996. Even Number of Knight Moves
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/even-number-of-knight-moves/
 * Language: rust
 * Date: 2026-07-19
 */

use std::collections::VecDeque;

impl Solution {
    pub fn can_reach(start: Vec<i32>, target: Vec<i32>) -> bool {
        let moves: [[i32;2];6]=[[1,2],[-1,2],[1,-2],[-2,-1],[-2,1],[2,-1]];
        let mut dq: VecDeque<[i32;3]> = VecDeque::new();
        let mut seens: [[[bool; 2]; 8]; 8] = [[[false; 2]; 8]; 8];
        dq.push_back([start[0],start[1],0]);
        seens[start[0] as usize][start[1] as usize][0]=true;
        while dq.len()>0 {
            let current=dq.pop_front().unwrap();
            let x=current[0];
            let y=current[1];
            let stp=current[2];
            let stp_next=1-stp;
            if x==target[0] && y==target[1] && stp==0 {
                return true;
            }
            for m in &moves {
                let x_next=x+m[0];
                let y_next=y+m[1];
                if x_next>=0 && x_next<8 && y_next>=0 && y_next<8 && !seens[x_next as usize][y_next as usize][stp_next as usize] {
                    seens[x_next as usize][y_next as usize][stp_next as usize]=true;
                    dq.push_back([x_next,y_next,stp_next]);
                }
            }
        }
        return false;
    }
}
