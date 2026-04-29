/*
 * Problem: 3912. Valid Elements in an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-elements-in-an-array/
 * Language: rust
 * Date: 2026-04-29
 */

impl Solution {
    pub fn find_valid_elements(nums: Vec<i32>) -> Vec<i32> {
        let mut arr: Vec<bool>=Vec::new();
        let mut max=0;
        for i in 0..nums.len() {
            if nums[i]>max {
                arr.push(true);
                max=nums[i];
            } else {
                arr.push(false);
            }
        }
        max=0;
        for i in (0..nums.len()).rev() {
            if nums[i]>max {
                arr[i]=true;
                max=nums[i];
            }
        }
        let mut res: Vec<i32>=Vec::new();
        for i in 0..nums.len() {
            if arr[i] {
                res.push(nums[i]);
            }
        }
        return res;
    }
}
