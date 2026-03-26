/*
 * Problem: 167. Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        
        while (left<right) {
            int mid=(right-left)/2+left;
            if (numbers[mid]+numbers[left]>target) {
                right=mid;
                continue;
            }
            if (numbers[mid]+numbers[right]<target) {
                left=mid+1;
                continue;
            }
            int sum=numbers[left]+numbers[right];
            if (sum==target) return new int[] {left+1,right+1};
            if (sum>target) {
                right--;
            } else {
                left++;
            }
            
        }
        return new int[] {left+1,right+1};
        
    }
}
