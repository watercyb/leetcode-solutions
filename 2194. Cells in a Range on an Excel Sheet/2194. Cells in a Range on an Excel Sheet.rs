/*
 * Problem: 2194. Cells in a Range on an Excel Sheet
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn cells_in_range(s: String) -> Vec<String> {
        let chrs:Vec<char>=s.chars().collect();
        let c1=chrs[0];
        let r1=chrs[1];
        let c2=chrs[3];
        let r2=chrs[4];
        let mut res: Vec<String> = Vec::new();
        for i in c1..=c2 {
            for j in r1..=r2 {
                let mut str=String::new();
                str.push(i as char);
                str.push(j as char);
                res.push(str);
            }
        }
        return res;
    }
}
