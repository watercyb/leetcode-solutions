/*
 * Problem: 295. Find Median from Data Stream
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-median-from-data-stream/
 * Language: java
 * Date: 2026-03-31
 */

class MedianFinder {
    int[] BITree;
    int n = 0;

    public MedianFinder() {
        BITree = new int[200002];
    }

    public void addNum(int num) {
        insertTree(num + 100001);
        n++;
    }

    public double findMedian() {
        if (n % 2 == 1) {
            return (double) BS(1, 200001, n / 2 + 1) - 100001;
        } else {
            int l = BS(1, 200001, n / 2 + 1);
            return (double) (l + BS(1, l, n / 2)) / 2 - 100001;
        }
    }

    public int BS(int l, int r, int target) {
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (getTree(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public void insertTree(int i) {
        while (i <= 200001) {
            BITree[i]++;
            i += i & -i;
        }
    }

    public int getTree(int i) {
        int res = 0;
        while (i > 0) {
            res += BITree[i];
            i -= i & -i;
        }
        return res;
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
