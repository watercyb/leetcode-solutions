/*
 * Problem: 2575. Find the Divisibility Array of a String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-divisibility-array-of-a-string/
 * Language: rust
 * Date: 2026-04-28
 */

impl Solution {
    pub fn divisibility_array(word: String, m: i32) -> Vec<i32> {
        let mut sum: i64=0;
        let m=m as i64;
        let mut res: Vec<i32>=Vec::new();
        for chr in word.chars() {
            sum=(sum*10+(chr as u8 - b'0') as i64)%m;
            if sum==0 {
                res.push(1);
            } else {
                res.push(0);
            }
        }
        return res;
    }
}
