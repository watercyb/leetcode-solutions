/*
 * Problem: 3849. Maximum Bitwise XOR After Rearrangement
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-bitwise-xor-after-rearrangement/
 * Language: rust
 * Date: 2026-07-18
 */

impl Solution {
    pub fn maximum_xor(s: String, t: String) -> String {
        let mut counts=[0;2];
        for chr in t.chars() {
            counts[(chr as u8-b'0')as usize]+=1;
        }
        let mut res=String::new();
        for chr in s.chars() {
            let idx=(chr as u8-b'0') as usize;
            if counts[idx^1]>0 {
                counts[idx^1]-=1;
                res.push_str("1");
            } else {
                counts[idx]-=1;
                res.push_str("0");
            }
        }
        return res;
    }
}
