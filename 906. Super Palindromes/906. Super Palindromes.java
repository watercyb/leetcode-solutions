/*
 * Problem: 906. Super Palindromes
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/super-palindromes/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    static long[] arr = new long[71];

    public int superpalindromesInRange(String left, String right) {
         if (arr[1] == 0) {
            arr[1]=1;
            arr[2]=2;
            arr[3]=3;
            int ans = 3;
            for (int i = 4; i < 19684; i++) {
                String num = Integer.toString(i, 3);
                if (isPal(num)) {
                    long square = Long.parseLong(num) * Long.parseLong(num);
                    if (square >= Long.parseLong(left) && isPal(Long.toString(square))) {
                        ans++;
                        arr[ans] = Long.parseLong(num);
                    }
                }
            }
        }
        double tmp = Math.sqrt(Long.parseLong(left));
        long r = (long) Math.sqrt(Long.parseLong(right));
        long l = (long) tmp;
        if (l < tmp)
            l++;
        int idxL = Arrays.binarySearch(arr, l);
        if (idxL < 0) {
            idxL=-idxL-1;
        }
        idxL--;
        int idxR = Arrays.binarySearch(arr, r);
        if (idxR < 0) {
            idxR=-idxR-2;
        }
        return idxR-idxL;
    }

    private boolean isPal(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j))
                return false;
        return true;
    }
}
