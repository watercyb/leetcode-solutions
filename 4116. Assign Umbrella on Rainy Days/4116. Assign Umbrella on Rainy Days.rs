/*
 * Problem: 4116. Assign Umbrella on Rainy Days
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/assign-umbrella-on-rainy-days/
 * Language: rust
 * Date: 2026-11-24
 */

impl Solution {
    pub fn assign_umbrella(rain: Vec<i32>) -> Vec<String> {
        let mut res:Vec<String>=Vec::new();
        let mut a=0;
        let mut b=0;
        for i in 0..rain.len() {
            if rain[i]==0 {
                res.push("None".to_string());
            } else {
                if i==rain.len()-1 || rain[i+1]==0 || a>b {
                    res.push("Bob".to_string());
                    b+=1;
                } else {
                    res.push("Alice".to_string());
                    a+=1;
                }
            }
        }
        return res;
    }
}
