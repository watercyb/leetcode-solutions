/*
 * Problem: 2094. Finding 3-Digit Even Numbers
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/finding-3-digit-even-numbers/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        boolean[] seens = new boolean[1000];
        int count = 0;
        int[] has = new int[10];
        for (int digit : digits) {
            has[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            if (has[i] == 0)
                continue;
            int num = i * 100;
            has[i]--;
            for (int j = 0; j < 10; j++) {
                if (has[j] == 0)
                    continue;
                num += j * 10;
                has[j]--;
                for (int k = 0; k < 10; k += 2) {
                    if (has[k] == 0)
                        continue;
                    count += add(seens, num + k);
                }
                has[j]++;
                num -= j * 10;
            }
            has[i]++;
        }
        int[] res = new int[count];
        int idx = 0;
        for (int i = 0; i < 1000; i++) {
            if (seens[i])
                res[idx++] = i;
        }
        return res;
    }

    public int add(boolean[] seens, int num) {
        if (num < 100)
            return 0;
        if (!seens[num]) {
            seens[num] = true;
            return 1;
        }
        return 0;
    }
}
