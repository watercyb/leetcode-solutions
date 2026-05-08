/*
 * Problem: 3582. Generate Tag for Video Caption
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/generate-tag-for-video-caption/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public String generateTag(String caption) {
        char[] res = new char[100];
        res[0] = '#';
        int idx = 1;
        boolean isFirst = false;
        for (char chr : caption.toCharArray()) {
            if (chr == ' ') {
                isFirst = true;
            } else if (!Character.isLetter(chr)) {
                continue;
            } else {
                if (isFirst) {
                    if (idx == 1) {
                        if (Character.isLowerCase(chr)) {
                            res[idx] = chr;
                        } else {
                            res[idx] = (char) (chr - 'A' + 'a');
                        }
                    } else {
                        if (Character.isLowerCase(chr)) {
                            res[idx] = (char) (chr - 'a' + 'A');
                        } else {
                            res[idx] = chr;
                        }
                    }
                    isFirst = false;
                } else {
                    if (Character.isLowerCase(chr)) {
                        res[idx] = chr;
                    } else {
                        res[idx] = (char) (chr - 'A' + 'a');
                    }
                }
                if (++idx == 100)
                    break;
            }
        }
        return new String(res, 0, idx);
    }
}
