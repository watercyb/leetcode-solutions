/*
 * Problem: 600. Non-negative Integers without Consecutive Ones
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int findIntegers(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 2);
            n >>= 1;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[arr.length - i - 1] = list.get(i);
        }
        int res = 1;
        boolean isGood = true;
        for (int i = 1; i < arr.length; i++) {
            res += getCount(arr.length - i - 1, 0, 1);
            if (isGood && arr[i] == 1)
                res += getCount(arr.length - i - 1, 1, 0);
            if (arr[i] == 1 && arr[i - 1] == 1)
                isGood = false;
        }
        if (isGood)
            res++;
        return res;
    }
    
    public int getCount(int len, int a, int b) {
        for (int i = 0; i < len; i++) {
            int temp = a;
            a += b;
            b = temp;
        }
        return a + b;
    }
}
