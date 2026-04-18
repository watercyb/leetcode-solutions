/*
 * Problem: 1592. Rearrange Spaces Between Words
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/rearrange-spaces-between-words/
 * Language: rust
 * Date: 2026-04-18
 */

impl Solution {
    pub fn reorder_spaces(text: String) -> String {
        let mut strs=Vec::new();
        let mut str=String::new();
        let mut count=0;
        for chr in text.chars() {
            if chr==' ' {
                count+=1;
                if str.len()>0 {
                    strs.push(std::mem::take(&mut str));
                }
            } else {
                str.push(chr);
            }
        }
        if str.len()>0 {
            strs.push(std::mem::take(&mut str));
        }
        let len=if strs.len()-1==0 {
            0
        } else {
            count/(strs.len()-1)
        };
        let rem=if strs.len()-1==0 {
            count
        } else {
            count%(strs.len()-1)
        };
        let mut res=String::new();
        res.push_str(strs[0].as_str());
        for i in 1..strs.len() {
            for _ in 0..len {
                res.push(' ');
            }
            res.push_str(strs[i].as_str());
        }
        for _ in 0..rem {
            res.push(' ');
        }
        return res;
    }
}
