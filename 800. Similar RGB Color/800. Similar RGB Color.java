/*
 * Problem: 800. Similar RGB Color
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/similar-rgb-color/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public String similarRGB(String color) {
        StringBuilder SB = new StringBuilder().append('#');
        for (int i = 1; i < 7; i += 2) {
            int a = hexToDec(color.charAt(i));
            int b = hexToDec(color.charAt(i + 1));
            if (a < b) {
                if (b - a <= 8) {
                    SB.append(color.charAt(i)).append(color.charAt(i));
                } else {
                    char chr = decToHex(a + 1);
                    SB.append(chr).append(chr);
                }
            } else if (a > b) {
                if (a - b <= 8) {
                    SB.append(color.charAt(i)).append(color.charAt(i));
                } else {
                    char chr = decToHex(a - 1);
                    SB.append(chr).append(chr);
                }
            } else {
                SB.append(color.charAt(i)).append(color.charAt(i + 1));
            }
        }
        return SB.toString();
    }

    public char decToHex(int num) {
        if (num <= 9)
            return (char) (num + '0');
        return (char) (num - 10 + 'a');
    }

    public int hexToDec(char chr) {
        if (chr <= '9')
            return chr - '0';
        return chr - 'a' + 10;
    }
}
