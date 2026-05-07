/*
 * Problem: 3484. Design Spreadsheet
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-spreadsheet/
 * Language: java
 * Date: 2026-05-07
 */

class Spreadsheet {
    int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[26][rows + 1];
    }

    public void setCell(String cell, int value) {
        int num = 0;
        for (int i = 1; i < cell.length(); i++) {
            num = num * 10 + cell.charAt(i) - '0';
        }
        sheet[cell.charAt(0) - 'A'][num] = value;
    }

    public void resetCell(String cell) {
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        char[] chrs = formula.toCharArray();
        int idx = 1;
        int res = 0;
        if (Character.isLetter(chrs[1])) {
            idx++;
            int num = 0;
            while (chrs[idx] != '+') {
                num = num * 10 + chrs[idx] - '0';
                idx++;
            }
            res = sheet[chrs[1] - 'A'][num];
        } else {
            int num = 0;
            while (chrs[idx] != '+') {
                num = num * 10 + chrs[idx] - '0';
                idx++;
            }
            res = num;
        }
        idx++;
        if (Character.isLetter(chrs[idx])) {
            int a = chrs[idx] - 'A';
            idx++;
            int num = 0;
            while (idx < chrs.length) {
                num = num * 10 + chrs[idx] - '0';
                idx++;
            }
            res += sheet[a][num];
        } else {
            int num = 0;
            while (idx < chrs.length) {
                num = num * 10 + chrs[idx] - '0';
                idx++;
            }
            res += num;
        }
        return res;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
