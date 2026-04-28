/*
 * Problem: 2548. Maximum Price to Fill a Bag
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-price-to-fill-a-bag/
 * Language: rust
 * Date: 2026-04-28
 */

impl Solution {
    pub fn max_price(items: Vec<Vec<i32>>, capacity: i32) -> f64 {
        let mut items=items;
        items.sort_by(|a, b| (b[0] * a[1]).cmp(&(a[0] * b[1])));
        print!("{:?}", items);
        let mut capacity=capacity as f64;
        let mut res: f64=0.0;
        for item in &items {
            let mut p=item[0] as f64;
            let mut w=item[1] as f64;
            if w<capacity {
                capacity-=w;
                res+=p;
            } else {
                res+=p/w*capacity;
                capacity=0.0;
                break;
            }
        }
        if capacity>0.0 {
            return -1.0;
        }
        return res;
    }
}
