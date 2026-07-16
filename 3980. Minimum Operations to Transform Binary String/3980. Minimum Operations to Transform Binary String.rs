/*
 * Problem: 3980. Minimum Operations to Transform Binary String
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-operations-to-transform-binary-string/
 * Language: rust
 * Date: 2026-07-16
 */

impl Solution {
    pub fn min_operations(s1: String, s2: String) -> i32 {
        if s1=="1" && s2=="0" {
            return -1;
        }
        let chrs1: Vec<char>=s1.chars().collect();
        let chrs2: Vec<char>=s2.chars().collect();
        let mut a=0;
        let mut b=1000000;
        for i in 0..chrs1.len() {
            let mut a_next=1000000;
            let mut b_next=1000000;
            if chrs1[i]==chrs2[i] {
                if chrs1[i]=='1' {
                    a_next=a.min(b+1);
                    b_next=(a+2).min(b+3);
                } else {
                    a_next=a.min(b+1);
                    b_next=(b+3).min(a+2);
                }
            } else {
                if chrs1[i]=='1' {
                    a_next=b;
                    b_next=(b+2).min(a+1);
                } else {
                    a_next=(a+1).min(b+2);
                    b_next=(a+3).min(b+4);
                }
            }
            a=a_next;
            b=b_next;
        }
        return a;
    }
}
