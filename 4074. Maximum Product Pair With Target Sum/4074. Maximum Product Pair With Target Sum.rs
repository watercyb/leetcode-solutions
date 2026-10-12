/*
 * Problem: 4074. Maximum Product Pair With Target Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-product-pair-with-target-sum/
 * Language: rust
 * Date: 2026-10-12
 */

impl Solution {
    pub fn max_product_pair(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut indexes=[-1; 201];
        let mut pro=-10001;
        let mut l: i32=-1;
        let mut r: i32=-1;
        for i in 0..nums.len() {
            if nums[i]*2!=target {
                let left=target-nums[i];
                if left<=100 && left>=-100 && left*nums[i]>pro {
                    let idx=indexes[(left+100) as usize];
                    if idx>=0 {
                        pro=left*nums[i];
                        l=idx;
                        r=i as i32;
                    }
                }
            }
            indexes[nums[i] as usize+100]=i as i32;
        }
        if l==-1 || nums[l as usize]>nums[r as usize] {
            return [l, r].to_vec();
        } else {
            return [r, l].to_vec();
        }
    }
}
