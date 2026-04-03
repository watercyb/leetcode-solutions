/*
 * Problem: 2967. Minimum Cost to Make Array Equalindromic
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic/?envType=problem-list-v2&envId=math
 * Language: rust
 * Date: 2026-04-03
 */

impl Solution {
    pub fn minimum_cost(nums: Vec<i32>) -> i64 {
        let mut nums=nums;
        nums.sort();
        let mut res: i64=0;
        let num=nums[(nums.len()-1)/2];
        let mut len=num.ilog10() as i32 + 1;
        let mut res: i64=Self::getCost(&nums, (10 as u32).pow((len-1) as u32) as i32-1);
        if len<1000000000 {
            res=res.min(Self::getCost(&nums, (10 as u32).pow(len as u32) as i32+1));
        } else {
            res=res.min(Self::getCost(&nums, 1000000001));
        }
        if len%2==0 {
            let mut num1=num/((10 as u32).pow((len/2) as u32) as i32);
            let num2=Self::getPal(num1,true);
            res=res.min(Self::getCost(&nums, num2));         
            if num2>num {
                res=res.min(Self::getCost(&nums, Self::getPal(num1-1,true)));
            } else if num2<num {
                res=res.min(Self::getCost(&nums, Self::getPal(num1+1,true)));
            }
        } else {
            let mut num1=num/((10 as u32).pow((len/2) as u32) as i32);
            let num2=Self::getPal(num1,false);
            res=res.min(Self::getCost(&nums, num2));
            if num2>num {
                res=res.min(Self::getCost(&nums, Self::getPal(num1-1,false)));
            } else if num2<num {
                res=res.min(Self::getCost(&nums, Self::getPal(num1+1,false)));
            }
        }
        return res;
    }

    pub fn getCost(nums: &Vec<i32>, target: i32) -> i64 {
        let mut res: i64=0;
        for num in nums {
            res+=(num-target).abs() as i64;
        }
        return res;
    }

    pub fn getPal(num: i32, isEven: bool) -> i32 {
        let mut res=num;
        let mut num=num;
        if isEven {
            while num>0 {
                res=res*10+num%10;
                num/=10;
            }
        } else {
            res/=10;
            while num>0 {
                res=res*10+num%10;
                num/=10;
            }
        }
        return res;
    }
}
