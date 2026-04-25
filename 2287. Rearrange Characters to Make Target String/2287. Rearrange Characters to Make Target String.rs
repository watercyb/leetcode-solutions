/*
 * Problem: 2287. Rearrange Characters to Make Target String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rearrange-characters-to-make-target-string/
 * Language: rust
 * Date: 2026-04-25
 */

use std::any::type_name;
impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        let counts1=Self::count(&s);
        let counts2=Self::count(&target);
        let mut res=i32::MAX;
        for i in 0..26 {
            if counts2[i]>0 {
                res=res.min(counts1[i]/counts2[i]);
            }
        }
        return res;
    }

    pub fn count(s: &String) -> [i32; 26] {
        let mut res=[0;26];
        for c in s.chars() {
            res[(c as u8 - b'a') as usize]+=1;
        }
        return res;
    }
}
