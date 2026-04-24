/*
 * Problem: 2103. Rings and Rods
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rings-and-rods/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn count_points(rings: String) -> i32 {
        let chrs: Vec<char>=rings.chars().collect();
        let mut Hs=[0;10];
        for i in (0..rings.len()).step_by(2) {
            let idx=chrs[i+1] as usize-b'0' as usize;
            if chrs[i]=='B' {
                Hs[idx]|=1;
            } else  if chrs[i]=='R' {
                Hs[idx]|=2;
            } else {
                Hs[idx]|=4;
            }
        }
        let mut res=0;
        for h in Hs {
            if h==7 {
                res+=1;
            }
        }
        return res;
    }
}
