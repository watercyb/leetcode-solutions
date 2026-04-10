/*
 * Problem: 927. Three Equal Parts
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/three-equal-parts/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int count = 0;
        for (int num : arr) {
            count += num;
        }
        if (count % 3 != 0)
            return new int[] { -1, -1 };
        if (count == 0)
            return new int[] { 0, 2 };
        int idx = 0;
        int target = count / 3;
        while (target > 0) {
            target -= arr[idx++];
        }
        int lastOneOfPart1 = idx - 1;

        idx = arr.length - 1;
        while (arr[idx] != 1) {
            idx--;
        }
        int tailZeroCount = arr.length - 1 - idx;
        int lastOneOfPart3 = idx;
        target = count / 3;
        int l = lastOneOfPart1;
        int r = lastOneOfPart3;
        while (target > 0) {
            if (arr[l] != arr[r])
                return new int[] { -1, -1 };
            target -= arr[l];
            l--;
            r--;
        }
        int firstOneOfPart1 = l + 1;
        int firstOneOfPart3 = r + 1;
        idx = r;
        while (arr[idx] != 1) {
            idx--;
        }
        int lastOneOfPart2 = idx;
        if (firstOneOfPart3 - lastOneOfPart2 - 1 < tailZeroCount)
            return new int[] { -1, -1 };
        idx = lastOneOfPart1 + 1;
        while (arr[idx] != 1) {
            idx++;
        }
        int firstOneOfPart2 = idx;
        if (firstOneOfPart2 - lastOneOfPart1 - 1 < tailZeroCount)
            return new int[] { -1, -1 };

        for (int i = 0; i <= lastOneOfPart1 - firstOneOfPart1; i++) {
            if (arr[firstOneOfPart1 + i] != arr[firstOneOfPart2 + i])
                return new int[] { -1, -1 };
        }
        return new int[] { lastOneOfPart1 + tailZeroCount, lastOneOfPart2 + tailZeroCount + 1 };
    }
}
