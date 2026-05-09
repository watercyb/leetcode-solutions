/*
 * Problem: 3621. Number of Integers With Popcount-Depth Equal to K I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-integers-with-popcount-depth-equal-to-k-i/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long popcountDepth(long n, int k) {
        if (k == 0)
            return 1;
        lims = new int[k];
        lims[k - 1] = 1;
        long num = n;
        for (int i = 0; i < k - 1; i++) {
            int count = 64 - Long.numberOfLeadingZeros(num);
            lims[i] = count;
            num = count;
        }
        List<Integer> list = new ArrayList<>();
        num = n;
        while (num > 0) {
            list.add((int) (num % 2));
            num >>= 1;
        }
        arr = new int[list.size()];
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
            count += arr[i];
        }
        dfs(arr, 1, k - 1);
        return res;
    }

    int[] lims;
    int[] arr;
    int count;
    long res = 0;

    public void dfs(int[] arr, int num, int k) {
        if (k == 0) {
            int cnt = count;
            if (cnt == num || (arr[0] == 1 && cnt - 1 == num))
                res++;
            cnt -= arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 1) {
                    cnt--;
                    if (cnt <= num && num - cnt <= i)
                        res += C(i, num - cnt);
                }
            }
            if (num == 1)
                res--;
        } else {
            for (int i = 2; i <= lims[k - 1]; i++) {
                if (Integer.bitCount(i) == num)
                    dfs(arr, i, k - 1);
            }
        }
    }

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a / i;
            a--;
        }
        return res;
    }
}
