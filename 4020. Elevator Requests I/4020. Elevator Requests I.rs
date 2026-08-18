/*
 * Problem: 4020. Elevator Requests I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/elevator-requests-i/
 * Language: rust
 * Date: 2026-08-18
 */

impl Solution {
    pub fn elevator_requests(n: i32, requests: Vec<i32>) -> i32 {
        let mut res=0;
        let mut lv=0;
        for request in requests {
            res+=(request-lv).abs();
            lv=request;
        }
        return res;
    }
}
