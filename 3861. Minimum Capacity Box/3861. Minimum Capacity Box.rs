/*
 * Problem: 3861. Minimum Capacity Box
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-capacity-box/
 * Language: rust
 * Date: 2026-05-11
 */

impl Solution {
    pub fn minimum_index(capacity: Vec<i32>, item_size: i32) -> i32 {
        let mut res:i32=-1;
        let mut c=101;
        for i in 0..capacity.len() {
            if capacity[i]>=item_size && c>capacity[i] {
                res=i as i32;
                c=capacity[i];
            }
        }
        return res;
    }
}
