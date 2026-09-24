/*
 * Problem: 4057. Number of Intersecting Interval Pairs II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-intersecting-interval-pairs-ii/
 * Language: rust
 * Date: 2026-09-24
 */

use std::collections::HashSet;
use std::collections::HashMap;

impl Solution {
    pub fn count_intersecting_intervals(intervals: Vec<Vec<i32>>) -> i64 {
        let mut starts: Vec<i32>=Vec::new();
        let mut ends: Vec<i32>=Vec::new();
        for pair in &intervals {
            starts.push(pair[0]);
            ends.push(pair[1]);
        }
        starts.sort();
        ends.sort();
        let mut res: i64=0;
        let mut j=0;
        for i in 0..starts.len() {
            while ends[j]<starts[i] {
                j+=1;
            }
            res+=(i-j) as i64;
        }
        return res;
    }
}
