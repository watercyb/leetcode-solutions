/*
 * Problem: 241. Different Ways to Add Parentheses
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/different-ways-to-add-parentheses/
 * Language: java
 * Date: 2026-03-28
 */

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<int[]> list = new ArrayList<>();
        int num = 0;
        int sign = 0;
        for (char chr : expression.toCharArray()) {
            if (Character.isDigit(chr)) {
                num = num * 10 + chr - '0';
            } else {
                list.add(new int[] { sign, num });
                num = 0;
                switch (chr) {
                    case '+':
                        sign = 0;
                        break;
                    case '-':
                        sign = 1;
                        break;
                    case '*':
                        sign = 2;
                        break;
                }
            }
        }
        list.add(new int[] { sign, num });
        int[][] arr = new int[list.size()][2];
        list.toArray(arr);
        List<Integer>[][] DP = new ArrayList[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            DP[i][i] = new ArrayList<>();
            DP[i][i].add(arr[i][1]);
            for (int j = i + 1; j < arr.length; j++) {
                DP[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i < arr.length; i++) {
            DP[i - 1][i].add(cal(arr[i - 1], arr[i]));
            for (int j = i - 2; j >= 0; j--) {
                for (int k = j; k < i; k++) {
                    cal(arr, DP, j, k, i);
                }
            }
        }
        return DP[0][arr.length - 1];
    }

    public int cal(int[] a, int[] b) {
        switch (b[0]) {
            case 0:
                return a[1] + b[1];
            case 1:
                return a[1] - b[1];
            case 2:
                return a[1] * b[1];
        }
        return -1;
    }

    public void cal(int[][] arr, List<Integer>[][] meme, int i, int j, int k) {
        switch (arr[j + 1][0]) {
            case 0:
                for (int a : meme[i][j]) {
                    for (int b : meme[j + 1][k]) {
                        meme[i][k].add(a + b);
                    }
                }
                break;
            case 1:
                for (int a : meme[i][j]) {
                    for (int b : meme[j + 1][k]) {
                        meme[i][k].add(a - b);
                    }
                }
                break;
            case 2:
                for (int a : meme[i][j]) {
                    for (int b : meme[j + 1][k]) {
                        meme[i][k].add(a * b);
                    }
                }
                break;
        }
    }
}
