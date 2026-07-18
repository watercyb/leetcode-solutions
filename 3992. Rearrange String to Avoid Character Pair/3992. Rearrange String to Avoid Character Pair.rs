/*
 * Problem: 3992. Rearrange String to Avoid Character Pair
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rearrange-string-to-avoid-character-pair/
 * Language: rust
 * Date: 2026-07-18
 */

impl Solution {
    pub fn rearrange_string(s: String, x: char, y: char) -> String {
        let mut chrs: Vec<char>=s.chars().collect();
        let mut l=0;
        let mut r=chrs.len()-1;
        while l<r {
            if chrs[l]!=x {
                l+=1;
            } else if chrs[r]!=y {
                r-=1;
            } else {
                let mut temp=chrs[l];
                chrs[l]=chrs[r];
                chrs[r]=temp;
                l+=1;
                r-=1;
            }
        }
       return String::from_iter(chrs);
    }
}
