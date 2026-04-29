/*
 * Problem: 2651. Calculate Delayed Arrival Time
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/calculate-delayed-arrival-time/
 * Language: rust
 * Date: 2026-04-29
 */

impl Solution {
    pub fn find_delayed_arrival_time(arrival_time: i32, delayed_time: i32) -> i32 {
        return (arrival_time+delayed_time)%24;
    }
}
