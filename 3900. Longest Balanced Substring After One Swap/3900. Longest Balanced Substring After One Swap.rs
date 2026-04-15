/*
 * Problem: 3900. Longest Balanced Substring After One Swap
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-balanced-substring-after-one-swap/
 * Language: rust
 * Date: 2026-04-15
 */

use std::collections::HashMap;

impl Solution {
    pub fn longest_balanced(s: String) -> i32 {
        let chrs: Vec<char>=s.chars().collect();
        let offset=chrs.len()+2;
        let mut indexes=vec![-2;2*offset+1];
        let mut zero_indexes=vec![-2;2*offset+1];
        let mut one_indexes=vec![-2;2*offset+1];
        let mut zero_count=0;
        let mut one_count=0;
        for chr in &chrs {
            if *chr=='0' {
                zero_count+=1;
            } else {
                one_count+=1;
            }
        }
        indexes[0+offset]=-1;
        let mut res=0;
        let mut sum=0;
        let mut has_zero=false;
        let mut has_one=false;
        for i in 0..chrs.len() {
            let digit=(chrs[i] as u8 - b'0') as i32;
            if digit==0 {
                zero_count-=1;
                has_zero=true;
            } else {
                one_count-=1;
                has_one=true;
            }
            sum+=digit * 2 -1;
            let h=sum as usize + offset;
            let idx=i as i32;
            if indexes[h]>=-1 {
                res=res.max(idx - indexes[h]);
            } else {
                indexes[h]=idx;
            }
            if zero_count>0 {
                if indexes[h-2]>=-1 {
                    res=res.max(idx - indexes[h-2]);
                }
            } else {
                if zero_indexes[h-2]>=-1 {
                    res=res.max(idx - zero_indexes[h-2]);
                }
            }
            if one_count>0 {
                if indexes[h+2]>=-1 {
                    res=res.max(idx - indexes[h+2]);
                }
            } else {
                if one_indexes[h+2]>=-1 {
                    res=res.max(idx - one_indexes[h+2]);
                }
            }
            if has_zero && zero_indexes[h]==-2 {
                zero_indexes[h]=idx;
            }
            if has_one && one_indexes[h]==-2 {
                one_indexes[h]=idx;
            }
        }
        return res;
    }
}
