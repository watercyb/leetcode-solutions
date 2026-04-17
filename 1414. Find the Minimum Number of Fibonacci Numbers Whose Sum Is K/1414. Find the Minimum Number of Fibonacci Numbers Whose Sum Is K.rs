/*
 * Problem: 1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 * Language: rust
 * Date: 2026-04-17
 */

impl Solution {
    pub fn find_min_fibonacci_numbers(k: i32) -> i32 {
        let mut arr=vec![1,1];
        while arr[arr.len()-1]<=k {
            arr.push(arr[arr.len()-1]+arr[arr.len()-2]);
        }
        let mut res=0;
        let mut idx=arr.len()-1;
        let mut target=k;
        while target>0 {
            if arr[idx]<=target {
                target-=arr[idx];
                res+=1;
            }
            idx-=1;
        }
        return res;
    }
}
