/*
 * Problem: 2839. Check if Strings Can be Made Equal With Operations I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/
 * Language: rust
 * Date: 2026-05-01
 */

impl Solution {
    pub fn can_be_equal(s1: String, s2: String) -> bool {
        let mut counts=[[0; 26]; 2];
        let mut idx=0;
        for chr in s1.chars() {
            counts[idx][(chr as u8 - b'a') as usize]+=1;
            idx=1-idx;
        }
        idx=0;
        for chr in s2.chars() {
            counts[idx][(chr as u8 - b'a') as usize]-=1;
            if (counts[idx][(chr as u8 - b'a') as usize]<0) {
                return false;
            }
            idx=1-idx;
        }
        return true;
    }
}
