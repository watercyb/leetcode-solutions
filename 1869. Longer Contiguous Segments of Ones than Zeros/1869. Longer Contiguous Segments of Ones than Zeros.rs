/*
 * Problem: 1869. Longer Contiguous Segments of Ones than Zeros
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 * Language: rust
 * Date: 2026-04-21
 */

impl Solution {
    pub fn check_zero_ones(s: String) -> bool {
        let mut zero=0;
        let mut one=0;
        let mut prv='#';
        let mut count=0;
        for chr in s.chars() {
            if chr==prv {
                count+=1;
            } else if chr=='0' {
                if count>one {
                    one=count;
                }
                count=1;
                prv='0';
            } else {
                if count>zero {
                    zero=count;
                }
                count=1;
                prv='1';
            }
        }
        if prv=='1' {
            if count>one {
                one=count;
            }
        } else {
            if count>zero {
                zero=count;
            }
        }
        return one>zero;
    }
}
