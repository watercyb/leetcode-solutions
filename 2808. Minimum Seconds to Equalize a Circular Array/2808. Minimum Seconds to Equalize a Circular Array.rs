/*
 * Problem: 2808. Minimum Seconds to Equalize a Circular Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array/?envType=problem-list-v2&envId=hash-table
 * Language: rust
 * Date: 2026-03-30
 */

use std::collections::HashMap;

impl Solution {
    pub fn minimum_seconds(nums: Vec<i32>) -> i32 {
        let mut hm: HashMap<i32, Vec<i32>> = HashMap::new();
        for i in 0..nums.len() {
            if hm.contains_key(&nums[i]) {
                hm.get_mut(&nums[i]).unwrap().push(i as i32);
            } else {
                let mut arr: Vec<i32>=Vec::new();
                arr.push(i as i32);
                hm.insert(nums[i],arr);
            }
        }
        let mut res=i32::MAX;
        for arr in hm.values() {
            let mut max=(arr[0]+nums.len() as i32 - arr[arr.len()-1])/2;
            for i in 1..arr.len() {
                max=max.max((arr[i]-arr[i-1])/2);
            }
            res=res.min(max);
        }
        return res;
    }
}
