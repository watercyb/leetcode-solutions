/*
 * Problem: 278. First Bad Version
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/first-bad-version/
 * Language: java
 * Date: 2026-03-31
 */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right){
            int mid = left + (right - left)/2;
            if (isBadVersion(mid) == false){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
