/*
 * Problem: 3646. Next Special Palindrome Number
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/next-special-palindrome-number/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long specialPalindrome(long n) {
        if (arr == null)
            getArr();
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return arr[l];
    }

    List<Long> list = new ArrayList<>();
    static long[] arr;

    public void getArr() {
        dfs(new ArrayList<>(), 2, 0, false);
        for (int i = 1; i <= 9; i += 2) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(list, 2, i, true);
        }
        arr = new long[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
    }

    public void dfs(List<Integer> used, int i, int len, boolean changed) {
        if (len > 16)
            return;
        if (changed)
            insert(used, len);
        if (i > 8)
            return;
        dfs(used, i + 2, len, false);
        used.add(i);
        dfs(used, i + 2, len + i, true);
        used.removeLast();
    }

    public void insert(List<Integer> used, int len) {
        int[] arr = new int[len];
        int[][] counts = new int[used.size()][];
        int idx = 0;
        for (int num : used) {
            if (num % 2 == 1) {
                arr[arr.length / 2] = num;
                counts[idx++] = new int[] { num, num - 1 };
            } else {
                counts[idx++] = new int[] { num, num };
            }
        }
        dfs(counts, arr, arr.length / 2 - 1, (arr.length + 1) / 2);
    }

    public void dfs(int[][] counts, int[] arr, int l, int r) {
        if (l == -1) {
            insert(arr);
        } else {
            for (int[] count : counts) {
                if (count[1] > 0) {
                    arr[l] = arr[r] = count[0];
                    count[1] -= 2;
                    dfs(counts, arr, l - 1, r + 1);
                    count[1] += 2;
                }
            }
        }
    }

    public void insert(int[] arr) {
        long num = 0;
        for (int n : arr) {
            num = num * 10 + n;
        }
        list.add(num);
    }
}
