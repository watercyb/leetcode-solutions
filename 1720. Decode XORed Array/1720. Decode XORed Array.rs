/*
 * Problem: 1720. Decode XORed Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/decode-xored-array/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn decode(encoded: Vec<i32>, mut first: i32) -> Vec<i32> {
        let mut res:Vec<i32>=vec![first];
        for num in encoded {
            first^=num;
            res.push(first);
        }
        return res;
    }
}
