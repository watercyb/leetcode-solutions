/*
 * Problem: 1794. Count Pairs of Equal Substrings With Minimum Difference
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-pairs-of-equal-substrings-with-minimum-difference/
 * Language: rust
 * Date: 2026-04-20
 */

impl Solution {
    pub fn count_quadruples(first_string: String, second_string: String) -> i32 {
        let min = i32::MIN;
        let mut indexes=[min/2;26];
        let mut idx=0;
        for chr in second_string.chars() {
            indexes[(chr as u8 - b'a') as usize]=idx;
            idx+=1;
        }
        let mut l=0;
        let mut r=min/3;
        let mut res=0;
        idx=0;
        for chr in first_string.chars() {
            let id=indexes[(chr as u8 - b'a') as usize];
            if idx-id<l-r {
                l=idx;
                r=id;
                res=1;
            } else if idx-id==l-r {
                res+=1;
            }
            idx+=1;
        }
        return res;
    }
}
