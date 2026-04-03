/*
 * Problem: 421. Maximum XOR of Two Numbers in an Array
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        int res=0;
        for (int num:nums) {
            max=Math.max(max,num);
        }
        HashSet<Integer> HS=new HashSet<>();
        int maxLength=31-Integer.numberOfLeadingZeros(max);
        for (int i=maxLength;i>=0;i--) {
            HS.clear();
            res=res<<1;
            int next=res+1;
            for (int num:nums) {
                num=num>>i;
                if (HS.contains(next^num)) {
                    res=next;
                    break;
                }
                HS.add(num);
            }
        }
        return res;
    }
}
