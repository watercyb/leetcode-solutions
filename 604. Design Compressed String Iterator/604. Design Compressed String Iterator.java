/*
 * Problem: 604. Design Compressed String Iterator
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/design-compressed-string-iterator/
 * Language: java
 * Date: 2026-04-05
 */

class StringIterator {
    char[] chrs;
    int idx = 0;
    char chr = '#';
    int count = 0;

    public StringIterator(String compressedString) {
        chrs = compressedString.toCharArray();
        if (chrs.length > 0) {
            chr = chrs[idx++];
            count = 0;
            while (idx < chrs.length && Character.isDigit(chrs[idx])) {
                count *= 10;
                count += chrs[idx] - '0';
                idx++;
            }
        }
    }

    public char next() {
        if (idx == chrs.length && count == 0) {
            return ' ';
        } else {
            char res = chr;
            if (count-- == 1) {
                if (idx < chrs.length) { 
                    chr = chrs[idx++];
                    count = 0;
                    while (idx < chrs.length && Character.isDigit(chrs[idx])) {
                        count *= 10;
                        count += chrs[idx] - '0';
                        idx++;
                    }
                }
            }
            return res;
        }
    }

    public boolean hasNext() {
        return idx < chrs.length || count > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
