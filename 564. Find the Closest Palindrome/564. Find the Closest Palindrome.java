/*
 * Problem: 564. Find the Closest Palindrome
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-closest-palindrome/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public String nearestPalindromic(String n) {
        char[] chrs = n.toCharArray();
        char[] smaller = getSmaller(chrs.clone());
        char[] larger = getLarger(chrs.clone());
        if (larger[0] == ':' && larger.length > 1) {
            larger[larger.length - 1] = '1';
        }
        if (smaller[0] == '0' && smaller.length > 1) {
            smaller[smaller.length - 1] = '9';
        }
        int[] smallerDiff = new int[chrs.length];
        int[] largerDiff = new int[chrs.length];
        int carrySmaller = 0;
        int carryLarger = 0;
        for (int i = chrs.length - 1; i >= 0; i--) {
            largerDiff[i] = larger[i] - chrs[i] - carryLarger + '0';
            if (largerDiff[i] < '0') {
                largerDiff[i] += 10;
                carryLarger = 1;
            } else {
                carryLarger = 0;
            }
            smallerDiff[i] = chrs[i] - smaller[i] - carrySmaller + '0';
            if (smallerDiff[i] < '0') {
                smallerDiff[i] += 10;
                carrySmaller = 1;
            } else {
                carrySmaller = 0;
            }
        }
        for (int i = 0; i < chrs.length; i++) {
            if (largerDiff[i] < smallerDiff[i]) {
                return getResStr(larger);
            } else if (largerDiff[i] > smallerDiff[i]) {
                return getResStr(smaller);
            }
        }
        return getResStr(smaller);
    }

    public String getResStr(char[] chrs) {
        if (chrs[0] == '0') {
            if (chrs.length > 1) {
                return new String(chrs, 1, chrs.length - 1);
            } else {
                return new String(chrs);
            }
        } else if (chrs[0] == ':') {
            return new StringBuilder("10").append(chrs, 1, chrs.length - 1).toString();
        }
        return new String(chrs);
    }

    public char[] getLarger(char[] chrs) {
        boolean changed = false;
        int midLeft = (chrs.length - 1) / 2;
        int midRight = chrs.length / 2;
        int l = midLeft;
        int r = midRight;
        while (l >= 0) {
            if (chrs[l] > chrs[r]) {
                chrs[r] = chrs[l];
                changed = true;
            } else if (chrs[l] < chrs[r]) {
                if (changed) {
                    chrs[r] = chrs[l];
                } else {
                    int lTemp = midLeft;
                    int rTemp = midRight;
                    while (lTemp > l && chrs[lTemp] == '9') {
                        lTemp--;
                        rTemp++;
                    }
                    chrs[lTemp]++;
                    chrs[rTemp] = chrs[lTemp];
                    for (int i = lTemp + 1; i < rTemp; i++) {
                        chrs[i] = '0';
                    }
                    chrs[r] = chrs[l];
                    changed = true;
                }
            }
            l--;
            r++;
        }
        if (!changed) {
            l = midLeft;
            r = midRight;
            while (l > 0 && chrs[l] == '9') {
                l--;
                r++;
            }
            chrs[l]++;
            chrs[r] = chrs[l];
            l++;
            r--;
            while (l <= r) {
                chrs[l] = '0';
                chrs[r] = '0';
                l++;
                r--;
            }
        }
        return chrs;
    }

    public char[] getSmaller(char[] chrs) {
        boolean changed = false;
        int midLeft = (chrs.length - 1) / 2;
        int midRight = chrs.length / 2;
        int l = midLeft;
        int r = midRight;
        while (l >= 0) {
            if (chrs[l] < chrs[r]) {
                chrs[r] = chrs[l];
                changed = true;
            } else if (chrs[l] > chrs[r]) {
                if (changed) {
                    chrs[r] = chrs[l];
                } else {
                    int lTemp = midLeft;
                    int rTemp = midRight;
                    while (lTemp > l && chrs[lTemp] == '0') {
                        lTemp--;
                        rTemp++;
                    }
                    chrs[lTemp]--;
                    chrs[rTemp] = chrs[lTemp];
                    for (int i = lTemp + 1; i < rTemp; i++) {
                        chrs[i] = '9';
                    }
                    chrs[r] = chrs[l];
                    changed = true;
                }
            }
            l--;
            r++;
        }
        if (!changed) {
            l = midLeft;
            r = midRight;
            while (l > 0 && chrs[l] == '0') {
                l--;
                r++;
            }
            chrs[l]--;
            chrs[r] = chrs[l];
            l++;
            r--;
            while (l <= r) {
                chrs[l] = '9';
                chrs[r] = '9';
                l++;
                r--;
            }
        }
        return chrs;
    }
}
