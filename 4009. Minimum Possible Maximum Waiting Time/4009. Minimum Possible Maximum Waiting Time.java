/*
 * Problem: 4009. Minimum Possible Maximum Waiting Time
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-possible-maximum-waiting-time/
 * Language: java
 * Date: 2026-08-06
 */

class Solution {
    public int minMaxWaitingTime(int[] demand, int[] fuel) {
        int sum = fuel[0] + fuel[1];
        HashMap<Integer, Integer> HM = new HashMap<>();
        HashMap<Integer, Integer> HMNext = new HashMap<>();
        HM.put(getH(fuel[0], 0, 0), 0);
        int res = -1;
        for (int d : demand) {
            HMNext.clear();
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
                int[] arr = getArr(entry.getKey());
                int delay = entry.getValue();
                int sumA = arr[0];
                int sumB = sum - arr[0];
                int a = arr[1];
                int b = arr[2];
                if (sumA >= d) {
                    int aNext = a;
                    int bNext = b;
                    int delayNext = delay;
                    delayNext = Math.max(delayNext, a);
                    aNext = d;
                    bNext = Math.max(bNext - a, 0);
                    int sumANext = sumA - d;
                    int h = getH(sumANext, aNext, bNext);
                    HMNext.put(h, Math.min(delayNext, HMNext.getOrDefault(h, delayNext)));
                    min = Math.min(min, delayNext);
                }
                if (sumB >= d) {
                    int aNext = a;
                    int bNext = b;
                    int delayNext = delay;
                    delayNext = Math.max(delayNext, b);
                    aNext = Math.max(aNext - b, 0);
                    bNext = d;
                    int sumANext = sumA;
                    int h = getH(sumANext, aNext, bNext);
                    HMNext.put(h, Math.min(delayNext, HMNext.getOrDefault(h, delayNext)));
                    min = Math.min(min, delayNext);
                }
            }
            sum -= d;
            if (min == Integer.MAX_VALUE)
                break;
            res = min;
            HashMap<Integer, Integer> temp = HM;
            HM = HMNext;
            HMNext = temp;
        }
        return res;
    }

    public void print(HashMap<Integer, Integer> HM, int sum) {
        for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
            int[] arr = getArr(entry.getKey());
            int delay = entry.getValue();
            int sumA = arr[0];
            int sumB = sum - arr[0];
            int a = arr[1];
            int b = arr[2];
            System.out.println("sumA: " + sumA + " sumB: " + sumB + " a: " + a + " b: " + b + " delay: " + delay);
        }
    }

    public int getH(int sum, int a, int b) {
        return (sum << 20) + (a << 10) + b;
    }

    public int[] getArr(int h) {
        int b = (h & 1023);
        h >>= 10;
        int a = (h & 1023);
        return new int[] { h >> 10, a, b };
    }
}
