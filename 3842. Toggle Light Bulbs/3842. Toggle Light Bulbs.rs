/*
 * Problem: 3842. Toggle Light Bulbs
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/toggle-light-bulbs/
 * Language: rust
 * Date: 2026-05-11
 */

impl Solution {
    pub fn toggle_light_bulbs(bulbs: Vec<i32>) -> Vec<i32> {
        let mut isOns=[false;101];
        for &num in &bulbs {
            isOns[num as usize]=!isOns[num as usize];
        }
        let mut res=Vec::new();
        for i in 1..=100 {
            if isOns[i as usize] {
                res.push(i);
            }
        }
        return res;
    }
}
