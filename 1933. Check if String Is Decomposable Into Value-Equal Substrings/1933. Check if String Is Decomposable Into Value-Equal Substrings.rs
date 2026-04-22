/*
 * Problem: 1933. Check if String Is Decomposable Into Value-Equal Substrings
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-string-is-decomposable-into-value-equal-substrings/
 * Language: rust
 * Date: 2026-04-22
 */

impl Solution {
    pub fn is_decomposable(s: String) -> bool {
        let mut seen=false;
        let mut count=0;
        let mut prv='#';
        for chr in s.chars() {
            if chr==prv {
                count+=1;
            } else {
                if count%3==1 {
                    return false;
                } else if count%3==2 {
                    if seen {
                        return false;
                    }
                    seen=true;
                }
                count=1;
                prv=chr;
            }
        }
        if count%3==1 {
            return false;
        } else if count%3==2 {
            if seen {
                return false;
            }
            seen=true;
        }
        return seen;
    }
}
