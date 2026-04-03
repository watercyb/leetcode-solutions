/*
 * Problem: 374. Guess Number Higher or Lower
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/guess-number-higher-or-lower/
 * Language: java
 * Date: 2026-04-03
 */

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left=1;
        int right=n;
        
        while (left<right) {
            int mid=(right-left)/2+left;
            int gu= guess(mid);
            if (gu==0) return mid;
            if (gu<0) right=mid-1;
            if (gu>0) left=mid+1;
        }
        
        return left;
        
        
    }
}
