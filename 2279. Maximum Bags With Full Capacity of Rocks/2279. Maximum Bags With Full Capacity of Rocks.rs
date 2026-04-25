/*
 * Problem: 2279. Maximum Bags With Full Capacity of Rocks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn maximum_bags(capacity: Vec<i32>, rocks: Vec<i32>, additional_rocks: i32) -> i32 {
        let mut arr: Vec<i32>=Vec::new();
        let mut count=additional_rocks;
        for i in 0..capacity.len() {
            arr.push(capacity[i]-rocks[i])
        }
        arr.sort();
        for i in 0..arr.len() {
            count-=arr[i];
            if count<0 {
                return i as i32;
            }
        }
        return arr.len() as i32;
    }
}
