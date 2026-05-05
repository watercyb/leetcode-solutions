/*
 * Problem: 3215. Count Triplets with Even XOR Set Bits II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-ii/
 * Language: rust
 * Date: 2026-05-05
 */

impl Solution {
    pub fn triplet_count(a: Vec<i32>, b: Vec<i32>, c: Vec<i32>) -> i64 {
        let mut n=Self::getEven(&a) as i64;
        let mut even=n as i64;
        let mut odd=a.len() as i64-n;
        n=Self::getEven(&b) as i64;
        let mut temp=even;
        even=even*n+odd*(b.len() as i64-n);
        odd=temp*(b.len() as i64-n)+odd*n;
        n=Self::getEven(&c) as i64;
        return even*n+odd*(c.len() as i64-n);
    }

    pub fn getEven(a: &Vec<i32>) -> i32{
        let mut res: i32=0;
        for num in a {
            res+=1-(num.count_ones()%2) as i32;
        }
        return res;
    }
}
