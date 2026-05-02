/*
 * Problem: 2917. Find the K-or of an Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-the-k-or-of-an-array/
 * Language: rust
 * Date: 2026-05-02
 */

impl Solution {
    pub fn find_k_or(nums: Vec<i32>, k: i32) -> i32 {
        let mut counts=[0;31];
        for mut num in nums {
            let mut idx=0;
            while num>0 {
                counts[idx]+=num%2;
                num/=2;
                idx+=1;
            }
        }
        let mut res=0;
        for i in 0..31 {
            if counts[i]>=k {
                res+=1<<i;
            }
        }
        return res;
    }
}
