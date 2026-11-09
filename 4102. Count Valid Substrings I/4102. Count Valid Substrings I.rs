/*
 * Problem: 4102. Count Valid Substrings I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-valid-substrings-i/
 * Language: rust
 * Date: 2026-11-09
 */

impl Solution {
    pub fn count_valid_substrings(s: String) -> i64 {
        let chrs: Vec<char>=s.chars().collect();
        let mut h = 0;
        let mut res = 0;
        let mut count = 0;
        for chr in s.chars() {
            if chr=='a' {
                h=1;
                count+=1;
            } else if chr=='b' {
                if h==1 {
                    h=2;
                } else {
                    h=0;
                }
                count+=1;
            } else {
                if h==2 {
                    count=2;
                } else {
                    count+=1;
                }
                h=0;
            }
            res+=count;
        }
        return res;
    }
}
