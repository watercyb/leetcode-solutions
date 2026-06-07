/*
 * Problem: 3953. Maximum Score with Co-Prime Element
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-score-with-co-prime-element/
 * Language: java
 * Date: 2026-06-07
 */

class Solution {
    static int[] LPF;
    static int[] arr = new int[100001];

    public int maxScore(int[] nums, int maxVal) {
        if (LPF == null)
            getLPF();
        int max = maxVal;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] counts = new int[max + 1];
        int[] countsOri = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            countsOri[nums[i]]++;
            getFactors(nums, counts, i);
        }
        int res = 1 - nums.length + (countsOri[1] == 0 ? 0 : 1);
        for (int i = max; i > maxVal; i--) {
            if (countsOri[i] > 0)
                res = Math.max(res, getScore(counts, countsOri, i));
        }
        for (int i = maxVal; i > Math.max(res, 1); i--) {
            res = Math.max(res, getScore(counts, countsOri, i));
        }
        return res;
    }

    int[] list = new int[10];
    int lim = 0;

    public int getScore(int[] counts, int[] countsOri, int num) {
        int n = num;
        lim = 0;
        while (n > 1) {
            int factor = LPF[n];
            if (arr[n] != 0) {
                n = arr[n];
            } else {
                int ori = n;
                while (n % factor == 0) {
                    n /= factor;
                }
                arr[ori] = n;
            }
            list[lim++] = factor;
        }
        int count = dfs(list, counts, 1, 0);
        if (countsOri[num] >= 1) {
            return num - count + 1;
        } else {
            return num - Math.max(count, 1);
        }
    }

    public int dfs(int[] list, int[] counts, int num, int i) {
        int res = counts[num];
        if (i == lim)
            return res;
        while (i < lim) {
            res += dfs(list, counts, num * list[i], i + 1);
            i++;
        }
        return res;
    }

    public void getFactors(int[] nums, int[] counts, int i) {
        int num = nums[i];
        int n = 1;
        lim = 0;
        while (num > 1) {
            int factor = LPF[num];
            if (arr[num] != 0) {
                num = arr[num];
            } else {
                int ori = num;
                while (num % factor == 0) {
                    num /= factor;
                }
                arr[ori] = num;
            }
            n *= factor;
            list[lim++] = factor;
        }
        nums[i] = n;
        dfs(list, counts, n, 0, lim);
    }

    public void dfs(int[] list, int[] counts, int num, int i, int n) {
        if (num == 1)
            return;
        counts[num] += ((n & 1) << 1) - 1;
        while (i < lim) {
            dfs(list, counts, num / list[i], i + 1, n - 1);
            i++;
        }
    }

    public void getLPF() {
        LPF = new int[100001];
        List<Integer> list = new ArrayList<>();
        LPF[1] = 1;
        for (int i = 2; i <= 100000; i++) {
            if (LPF[i] == 0) {
                list.add(i);
                LPF[i] = i;
                if ((long) i * i <= 100000) {
                    for (int j = i * i; j <= 100000; j += i) {
                        LPF[j] = i;
                    }
                }
            }
        }
    }
}
