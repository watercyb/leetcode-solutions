/*
 * Problem: 2847. Smallest Number With Given Digit Product
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/smallest-number-with-given-digit-product/?envType=problem-list-v2&envId=math
 * Language: rust
 * Date: 2026-04-02
 */

impl Solution {
    pub fn smallest_number(n: i64) -> String {
        let mut res="".to_string();
        let mut n=n;
        for i in (2..=9).rev() {
            while n%(i as i64)==0 {
                res.push((b'0' + i as u8) as char);
                n/=i as i64;
            }
        }
        if n!=1 {
            return "-1".to_string();
        }
        if res.len()==0 {
            return "1".to_string();
        }
        return res.chars().rev().collect();
    }
}
