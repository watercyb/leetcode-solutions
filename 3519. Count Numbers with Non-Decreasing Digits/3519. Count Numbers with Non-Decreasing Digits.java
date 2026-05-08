/*
 * Problem: 3519. Count Numbers with Non-Decreasing Digits
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-numbers-with-non-decreasing-digits/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int countNumbers(String l, String r, int b) {
        return (int) ((getCount(getArr(r, b), b, true) - getCount(getArr(l, b), b, false)) % 1_000_000_007);
    }

    public long getCount(int[] arr, int b, boolean isTop) {
        boolean isVaild = true;
        int prv = 0;
        long[] DP = new long[b];
        for (int i = 0; i < arr.length; i++) {
            for (int j = b - 2; j >= 0; j--) {
                for (int k = j + 1; k < b; k++) {
                    DP[k] += DP[j];
                }
            }
            if (isVaild) {
                for (int j = arr[i] - 1; j >= prv; j--) {
                    DP[j]++;
                }
                if (arr[i] < prv)
                    isVaild = false;
                prv = arr[i];
            }
        }
        long res = 0;
        for (long num : DP) {
            res += num;
        }
        if (isTop && isVaild)
            res++;
        return res;
    }

    public int[] getArr(String str, int b) {
        char[] chrs = str.toCharArray();
        int[] arr = new int[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            arr[i] = chrs[i] - '0';
        }
        List<Integer> list = new ArrayList<>();
        while (true) {
            int num = 0;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                num = num * 10 + arr[i];
                arr[i] = num / b;
                num %= b;
                if (arr[i] == 0)
                    count++;
            }
            list.add(num);
            if (count == arr.length)
                break;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - i - 1);
        }
        return res;
    }
}
