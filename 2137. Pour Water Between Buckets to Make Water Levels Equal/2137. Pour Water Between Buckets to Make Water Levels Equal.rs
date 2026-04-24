/*
 * Problem: 2137. Pour Water Between Buckets to Make Water Levels Equal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/pour-water-between-buckets-to-make-water-levels-equal/
 * Language: rust
 * Date: 2026-04-24
 */

impl Solution {
    pub fn equalize_water(buckets: Vec<i32>, loss: i32) -> f64 {
        let mut arr: Vec<i64>=Vec::new();
        for bucket in &buckets {
            arr.push(*bucket as i64 * 100000 as i64);
        }
        arr.sort();
        let mut l: i64=0;
        let mut r: i64=10000000000;
        while l<r {
            let mut mid=(l+r)/2;
            if !Self::chk(&arr, loss, mid) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return (l as f64)/(100000 as f64);
    }

    pub fn chk(arr: &Vec<i64>, loss: i32, mid: i64) -> bool {
        let mut arr=arr.clone();
        let loss=loss as i64;
        let mut left=0;
        let mut right=arr.len()-1;
        while left<right {
            let a=arr[left];
            let b=arr[right];
            if a>=mid {
                return true;
            }
            if b<mid {
                return false;
            }
            if mid+(mid-a)*100/(100-loss)<=b {
                arr[right]-=(mid-a)*100/(100-loss);
                left+=1;
            } else {
                arr[left]+=(b-mid)*(100-loss)/100;
                right-=1;
            }
        }
        return arr[left]>=mid;
    }
}
