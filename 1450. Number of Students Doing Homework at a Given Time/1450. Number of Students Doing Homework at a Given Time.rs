/*
 * Problem: 1450. Number of Students Doing Homework at a Given Time
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
 * Language: rust
 * Date: 2026-04-17
 */

impl Solution {
    pub fn busy_student(start_time: Vec<i32>, end_time: Vec<i32>, query_time: i32) -> i32 {
        let mut res=0;
        for i in 0..start_time.len() {
            if start_time[i]<=query_time && end_time[i]>=query_time {
                res+=1;
            }
        }
        return res;
    }
}
