/*
 * Problem: 2288. Apply Discount to Prices
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apply-discount-to-prices/
 * Language: rust
 * Date: 2026-04-25
 */

impl Solution {
    pub fn discount_prices(sentence: String, discount: i32) -> String {
        let mut strs: Vec<String> = sentence.split(' ').map(|s| s.to_string()).collect();
        for i in 0..strs.len() {
            let chrs: Vec<char>=strs[i].chars().collect();
            if chrs.len()<2 || chrs[0]!='$' {
                continue;
            }
            let mut num=0;
            for j in 1..chrs.len() {
                let digit=(chrs[j] as u8 - b'0') as i64;
                if digit<0 || digit>=10 {
                    num=-1;
                    break;
                }
                num=num*10+digit;
            }
            if num!=-1 {
                strs[i]=format!("${}", format!("{:.2}", (num as f64)*(1.0-(discount as f64)/100.0)));
            }
        }
        return strs.join(" ");
    }
}
