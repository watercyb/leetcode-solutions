/*
 * Problem: 1618. Maximum Font to Fit a Sentence in a Screen
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen/
 * Language: java
 * Date: 2026-04-19
 */

/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 * // Return the width of char ch when fontSize is used.
 * public int getWidth(int fontSize, char ch) {}
 * // Return Height of any char when fontSize is used.
 * public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        char[] chrs = text.toCharArray();
        int r = height(chrs, h, fonts, fontInfo);
        if (r == 0)
            return -1;
        int idx = width(chrs, w, fonts, fontInfo, r);
        if (idx < 0)
            return -1;
        return fonts[idx];
    }

    public int height(char[] chrs, int h, int[] fonts, FontInfo fontInfo) {
        int l = 0;
        int r = fonts.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (fontInfo.getHeight(fonts[mid]) > h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int width(char[] chrs, int w, int[] fonts, FontInfo fontInfo, int r) {
        int l = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(chrs, w, fonts[mid], fontInfo)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(char[] chrs, int w, int font, FontInfo fontInfo) {
        for (char chr : chrs) {
            w -= fontInfo.getWidth(font, chr);
            if (w < 0)
                return false;
        }
        return true;
    }
}
