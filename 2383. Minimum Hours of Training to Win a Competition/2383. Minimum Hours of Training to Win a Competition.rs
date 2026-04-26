/*
 * Problem: 2383. Minimum Hours of Training to Win a Competition
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/
 * Language: rust
 * Date: 2026-04-26
 */

impl Solution {
    pub fn min_number_of_hours(initial_energy: i32, initial_experience: i32, energy: Vec<i32>, experience: Vec<i32>) -> i32 {
        let mut res=std::cmp::max(energy.iter().sum::<i32>()-initial_energy+1,0);
        let mut exp=initial_experience;
        for ex in experience {
            if ex>=exp {
                res+=ex-exp+1;
                exp=ex+1;
            }
            exp+=ex;
        }
        return res;
    }
}
