/*
 * Problem: 1507. Reformat Date
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reformat-date/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public String reformatDate(String date) {
        String[] strs = date.split(" ");
        StringBuilder SB = new StringBuilder();
        SB.append(strs[2]).append('-');
        switch (strs[1]) {
            case "Jan":
                SB.append("01-");
                break;
            case "Feb":
                SB.append("02-");
                break;
            case "Mar":
                SB.append("03-");
                break;
            case "Apr":
                SB.append("04-");
                break;
            case "May":
                SB.append("05-");
                break;
            case "Jun":
                SB.append("06-");
                break;
            case "Jul":
                SB.append("07-");
                break;
            case "Aug":
                SB.append("08-");
                break;
            case "Sep":
                SB.append("09-");
                break;
            case "Oct":
                SB.append("10-");
                break;
            case "Nov":
                SB.append("11-");
                break;
            case "Dec":
                SB.append("12-");
                break;
        }
        int num = 0;
        int idx = 0;
        while (Character.isDigit(strs[0].charAt(idx))) {
            num = num * 10 + strs[0].charAt(idx++) - '0';
        }
        if (num < 10)
            SB.append('0');
        SB.append(num);
        return SB.toString();
    }
}
