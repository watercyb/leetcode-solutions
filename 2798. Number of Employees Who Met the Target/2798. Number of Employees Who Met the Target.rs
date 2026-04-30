/*
 * Problem: 2798. Number of Employees Who Met the Target
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-employees-who-met-the-target/
 * Language: rust
 * Date: 2026-04-30
 */

impl Solution {
    pub fn number_of_employees_who_met_target(hours: Vec<i32>, target: i32) -> i32 {
        let mut res=0;
        for hour in hours {
            if hour>=target {
                res+=1;
            }
        }
        return res;
    }
}
