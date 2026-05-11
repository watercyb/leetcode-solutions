/*
 * Problem: 3865. Reverse K Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-k-subarrays/
 * Language: rust
 * Date: 2026-05-11
 */

impl Solution {
    pub fn reverse_subarrays(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut res=nums.clone();
        let len=nums.len()/(k as usize);
        for i in 0..k {
            let mut l=(i as usize)*len;
            let mut r=(i as usize+1)*len-1;
            while l<r {
                let temp=res[l];
                res[l]=res[r];
                res[r]=temp;
                l+=1;
                r-=1;
            }
        }
        return res;
    }
}
