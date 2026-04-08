/*
 * Problem: 744. Find Smallest Letter Greater Than Target
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target<letters[0]||target>=letters[letters.length-1]) return letters[0];
        
        int left=0;
        int right=letters.length-1;
        
        while (left<right) {
            int mid=(right-left)/2+left;
            if (letters[mid]>target) right=mid;
            if (letters[mid]<=target) left=mid+1;
            
        }
        return letters[left];
    }
}
