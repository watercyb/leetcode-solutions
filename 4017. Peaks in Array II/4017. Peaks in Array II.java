/*
 * Problem: 4017. Peaks in Array II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/peaks-in-array-ii/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public long[] countOfPeaks(int[] nums, int[][] queries) {
        BIT sums = new BIT(nums.length);
        BitSet BS = new BitSet(nums.length);
        BS.set(0);
        BS.set(nums.length - 1);
        int prv = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (isPeak(nums, i)) {
                BS.set(i);
                sums.insert(prv, (long) prv * (i - prv));
                prv = i;
            }
        }
        sums.insert(prv, (long) prv * (nums.length - 1 - prv));
        int count = 0;
        for (int[] query : queries) {
            if (query[0] == 1)
                count++;
        }
        long[] res = new long[count];
        int idx = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                if (BS.nextSetBit(query[1] + 1) >= query[2]) {
                    res[idx++] = 0;
                } else {
                    long sum = sums.get(query[2] - 1) - sums.get(query[1])
                            - (long) query[1] * (query[2] - BS.nextSetBit(query[1] + 1))
                            - (long) BS.previousSetBit(query[2] - 1) * (BS.nextSetBit(query[2]) - query[2]);
                    res[idx++] = sum;
                }
            } else {
                int index = query[1];
                int num = query[2];
                int h = chk(nums, index, num);
                int base = 4;
                for (int i = index - 1; i <= index + 1; i++) {
                    if ((h & base) != 0)
                        fix(nums, sums, BS, i);
                    base >>= 1;
                }
            }
        }
        return res;
    }

    public void fix(int[] nums, BIT sums, BitSet BS, int i) {
            int prv = BS.previousSetBit(i - 1);
            int next = BS.nextSetBit(i + 1);
        if (isPeak(nums, i)) {
            BS.set(i);
            sums.insert(i, (long) i * (next - i));
            sums.insert(prv, -(long) prv * (next - i));
        } else {
            BS.clear(i);
            sums.insert(i, -(long) i * (next - i));
            sums.insert(prv, (long) prv * (next - i));
        }
    }

    public boolean isPeak(int[] nums, int i) {
        return i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }

    public int chk(int[] nums, int i, int num) {
        int a = 0;
        for (int j = i - 1; j <= i + 1; j++) {
            a <<= 1;
            if (isPeak(nums, j))
                a++;
        }
        nums[i] = num;
        int b = 0;
        for (int j = i - 1; j <= i + 1; j++) {
            b <<= 1;
            if (isPeak(nums, j))
                b++;
        }
        return a ^ b;
    }
}

class BIT {
    long[] bit;

    public BIT(int n) {
        bit = new long[n + 1];
    }

    public void insert(int i, long num) {
        i++;
        while (i < bit.length) {
            bit[i] += num;
            i += i & -i;
        }
    }

    public long get(int i) {
        i++;
        long res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i;
        }
        return res;
    }
}
