/*
 * Problem: 2613. Beautiful Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/beautiful-pairs/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int[] beautifulPair(int[] nums1, int[] nums2) {
        int max = 0;
        for (int num : nums2) {
            max = Math.max(num, max);
        }
        HashMap<Long, Integer> HM = new HashMap<>(nums1.length, 0.99f);
        int[][] arr = new int[nums1.length][3];
        for (int i = 0; i < nums1.length; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
            arr[i][2] = i;
            long h = 100001l * nums1[i] + nums2[i];
            if (HM.containsKey(h) && (res[0] == -1 || res[0] > HM.get(h))) {
                res[0] = HM.get(h);
                res[1] = i;
            } else {
                HM.put(h, i);
            }
        }
        if (res[0] != Integer.MAX_VALUE)
            return res;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        arrTemp = new int[nums1.length][];
        sort(arr, 0, nums1.length - 1);
        return res;
    }

    int min = Integer.MAX_VALUE;
    int[] res = { Integer.MAX_VALUE, Integer.MAX_VALUE };
    int[][] arrTemp;

    public void sort(int[][] arr, int l, int r) {
        if (l == r)
            return;
        int mid = (l + r) >>> 1;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        int max = Integer.MIN_VALUE / 2;
        int maxIdx = -1;
        int leftIdx = l;
        int rightIdx = mid + 1;
        while (rightIdx <= r) {
            while (leftIdx <= mid && arr[leftIdx][1] <= arr[rightIdx][1]) {
                int sum = arr[leftIdx][0] + arr[leftIdx][1];
                if (max < sum || (max == sum && maxIdx > arr[leftIdx][2])) {
                    max = sum;
                    maxIdx = arr[leftIdx][2];
                }
                leftIdx++;
            }
            if (maxIdx != -1) {
                int sum = arr[rightIdx][0] + arr[rightIdx][1];
                int a = Math.min(maxIdx, arr[rightIdx][2]);
                int b = Math.max(maxIdx, arr[rightIdx][2]);
                if (sum - max < min || (sum - max == min && (a < res[0] || (a == res[0] && b < res[1])))) {
                    min = sum - max;
                    res[0] = a;
                    res[1] = b;
                }
            }
            rightIdx++;
        }

        max = Integer.MIN_VALUE / 2;
        maxIdx = -1;
        leftIdx = mid;
        rightIdx = r;
        while (rightIdx > mid) {
            while (leftIdx >= l && arr[leftIdx][1] >= arr[rightIdx][1]) {
                int sum = arr[leftIdx][0] - arr[leftIdx][1];
                if (max < sum || (max == sum && maxIdx > arr[leftIdx][2])) {
                    max = sum;
                    maxIdx = arr[leftIdx][2];
                }
                leftIdx--;
            }
            if (maxIdx != -1) {
                int sum = arr[rightIdx][0] - arr[rightIdx][1];
                int a = Math.min(maxIdx, arr[rightIdx][2]);
                int b = Math.max(maxIdx, arr[rightIdx][2]);
                if (sum - max < min || (sum - max == min && (a < res[0] || (a == res[0] && b < res[1])))) {
                    min = sum - max;
                    res[0] = a;
                    res[1] = b;
                }
            }
            rightIdx--;
        }

        int idx = l;
        leftIdx = l;
        rightIdx = mid + 1;
        while (leftIdx <= mid && rightIdx <= r) {
            if (arr[leftIdx][1] <= arr[rightIdx][1]) {
                arrTemp[idx++] = arr[leftIdx++];
            } else {
                arrTemp[idx++] = arr[rightIdx++];
            }
        }
        while (leftIdx <= mid) {
            arrTemp[idx++] = arr[leftIdx++];
        }
        for (int i = l; i < idx; i++) {
            arr[i] = arrTemp[i];
        }
    }
}
