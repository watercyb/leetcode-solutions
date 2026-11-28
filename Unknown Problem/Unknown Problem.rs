/*
 * Problem: Unknown Problem
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/?envType=daily-question&envId=2026-11-28
 * Language: rust
 * Date: 2026-11-28
 */

use std::collections::HashMap;

impl Solution {
    pub fn maximum_sale_items(items: Vec<Vec<i32>>, budget: i32) -> i32 {
        let mut counts: [i64; 100001] = [0; 100001];
        let mut min=1000000000;
        let mut items=items;
        items.sort_by_key(|x| -x[0]);
        let mut map: HashMap<i64, i64> = HashMap::new();
        for i in 0..items.len() {
            let f=items[i][0] as usize;
            let v=items[i][1];
            counts[f]+=1;
            min=min.min(v);
            if i==items.len()-1 || items[i][0]!=items[i+1][0] {
                let mut count=0;
                for j in (f..=items[0][0] as usize).step_by(f) {
                    count+=counts[j];
                }
                let mut idx = i;
                loop {
                    if items[idx][0] != items[i][0] { 
                        break;
                    }
                    map.insert(items[idx][1] as i64, map.get(&(items[idx][1] as i64)).copied().unwrap_or(0) + count - 1);
                    if idx == 0 {
                        break;
                    }
                    idx -= 1;
                }
            }
        }
        let mut arr: Vec<Vec<i64>>=Vec::new();
        for (key, val) in &map {
            if *val>0 && *key<2*min as i64 {
                arr.push(vec![*key, *val]);
            }
        }
        arr.sort_by_key(|x| x[0]);
        let mut budget=budget as i64;
        let mut res=0;
        for pair in arr {
            let count=(budget as i64/pair[0]).min(pair[1]);
            if count>0 {
                    res+=2*count;
                    budget-=pair[0]*count;
            } else {
                break;
            }
        }
        return (res+budget/min as i64) as i32;
    }
}
