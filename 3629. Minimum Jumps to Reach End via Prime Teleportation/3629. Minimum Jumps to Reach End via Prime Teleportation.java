/*
 * Problem: 3629. Minimum Jumps to Reach End via Prime Teleportation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int minJumps(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(num, max);
        int[] SPF = getSPF(max);
        HashMap<Integer, List<Integer>> HM = new HashMap<>();
        boolean[] has = new boolean[max + 1];
        for (int num : nums) {
            if (num != 1 && SPF[num] == num) {
                has[num] = true;
                HM.put(num, new ArrayList<>());
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1)
                continue;
            while (SPF[num] != num) {
                int f = SPF[num];
                if (has[f])
                    HM.get(f).add(i);
                while (num % f == 0) {
                    num /= f;
                }
            }
            if (has[num])
                HM.get(num).add(i);
        }
        boolean[] seens = new boolean[nums.length];
        int[] arr = new int[nums.length];
        int l = 0;
        int r = 1;
        seens[0] = true;
        int stp = 0;
        while (l < r) {
            int lim = r;
            while (l < lim) {
                int idx = arr[l++];
                if (idx == nums.length - 1)
                    return stp;
                if (idx > 0 && !seens[idx - 1]) {
                    seens[idx - 1] = true;
                    arr[r++] = idx - 1;
                }
                if (!seens[idx + 1]) {
                    seens[idx + 1] = true;
                    arr[r++] = idx + 1;
                }
                if (has[nums[idx]]) {
                    for (int next : HM.get(nums[idx])) {
                        if (!seens[next]) {
                            seens[next] = true;
                            arr[r++] = next;
                        }
                    }
                    has[nums[idx]] = false;
                }
            }
            stp++;
        }
        return -1;
    }

    public int[] getSPF(int n) {
        int[] SPF = new int[n + 1];
        int lim = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            if (SPF[i] != 0)
                continue;
            SPF[i] = i;
            if (i > lim)
                continue;
            for (int j = i * i; j <= n; j += i) {
                if (SPF[j] == 0)
                    SPF[j] = i;
            }
        }
        SPF[1] = 1;
        return SPF;
    }
}
