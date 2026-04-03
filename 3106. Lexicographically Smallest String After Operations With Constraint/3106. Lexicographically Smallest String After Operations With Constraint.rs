/*
 * Problem: 3106. Lexicographically Smallest String After Operations With Constraint
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/lexicographically-smallest-string-after-operations-with-constraint/?envType=problem-list-v2&envId=string
 * Language: rust
 * Date: 2026-04-03
 */

impl Solution {
    pub fn get_smallest_string(s: String, k: i32) -> String {
        let mut res="".to_string();
        let mut k=k;
        for chr in s.chars() {
            let idx=(chr as u8 - b'a') as i32;
            let a=26-idx;
            if 26-idx<=k||idx<=k {
                k-=(26-idx).min(idx);
                res.push('a');
            } else {
                res.push(((idx-k) as u8 + b'a') as char);
                k=0;
            }
        }
        return res;
    }
}
