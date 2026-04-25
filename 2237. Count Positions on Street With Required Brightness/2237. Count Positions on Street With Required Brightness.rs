/*
 * Problem: 2237. Count Positions on Street With Required Brightness
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-positions-on-street-with-required-brightness/
 * Language: rust
 * Date: 2026-04-25
 */

use std::cmp::Reverse;
use std::collections::BinaryHeap;

impl Solution {
    pub fn meet_requirement(n: i32, lights: Vec<Vec<i32>>, requirement: Vec<i32>) -> i32 {
        let mut lights=lights.clone();
        lights.sort_by_key(|v| v[0]);
        let mut pq = BinaryHeap::new();
        let mut arr: Vec<i32> = Vec::new();
        let mut idx=0;
        print!("{:?}\n", lights);
        for i in 0..requirement.len() {
            while idx<lights.len() && lights[idx][0]==i as i32 {
                pq.push(Reverse(i as i32+lights[idx][1]));
                idx+=1;
            }
            while let Some(&Reverse(top_val)) = pq.peek() {
                if top_val < i as i32 {
                    pq.pop();
                } else {
                    break;
                }
            }
            arr.push(requirement[i]-pq.len() as i32);
        }
        let mut pq = BinaryHeap::new();
        let mut idx=lights.len();
        let mut res=0;
        for i in (0..requirement.len()).rev() {
            while let Some(&top_val) = pq.peek() {
                if top_val > i as i32 {
                    pq.pop();
                } else {
                    break;
                }
            }
            arr[i]-=pq.len() as i32;
            while idx>0 && lights[idx-1][0]==i as i32 {
                pq.push(i as i32-lights[idx-1][1]);
                idx-=1;
            }
            if arr[i]<=0 {
                res+=1;
            }
        }
        return res;
    }
}
