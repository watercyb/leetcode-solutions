/*
 * Problem: 2949. Count Beautiful Substrings II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-beautiful-substrings-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long beautifulSubstrings(String s, int k) {
        int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };
        int num = 1;
        for (int p : primes) {
            boolean need = true;
            while (k % p == 0) {
                if (need)
                    num *= p;
                k /= p;
                need = !need;
            }
        }
        if (k > 0)
            num *= k;
        k = num;
        int[] arr = new int['z' + 1];
        arr['a'] = arr['e'] = arr['i'] = arr['o'] = arr['u'] = 1;
        HashMap<Integer, Integer>[] HMs = new HashMap[k];
        for (int i = 0; i < HMs.length; i++) {
            HMs[i] = new HashMap<>();
        }
        HMs[0].put(0, 1);
        int count = 0;
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            count += arr[s.charAt(i)];
            res += HMs[count % k].merge(i + 1 - 2 * count, 1, Integer::sum) - 1;
        }
        return res;
    }
}
