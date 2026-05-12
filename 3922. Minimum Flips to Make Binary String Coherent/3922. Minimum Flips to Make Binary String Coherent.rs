/*
 * Problem: 3922. Minimum Flips to Make Binary String Coherent
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-flips-to-make-binary-string-coherent/
 * Language: rust
 * Date: 2026-05-12
 */

impl Solution {
    pub fn min_flips(s: String) -> i32 {
        if s.len()<=2 {
            return 0;
        }
        let mut zero=0;
        let mut one=0;
        let chrs: Vec<char>=s.chars().collect();
        for i in 0..chrs.len() {
            if chrs[i]=='0' {
                zero+=1;
            } else {
                one+=1;
            }
        }
        if chrs[0]=='1' && chrs[chrs.len()-1]=='1' {
            return zero.min(one-2);
        } else {
            return zero.min(one-1).max(0);
        }
    }
}
