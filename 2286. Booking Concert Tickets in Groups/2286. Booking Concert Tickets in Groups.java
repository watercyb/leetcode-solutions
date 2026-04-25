/*
 * Problem: 2286. Booking Concert Tickets in Groups
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/booking-concert-tickets-in-groups/
 * Language: java
 * Date: 2026-04-25
 */

class BookMyShow {
    int n;
    int m;
    int[] SGTMin;
    long[] SGTSum;
    int max;

    public BookMyShow(int n, int m) {
        this.n = n;
        this.m = m;
        int l = (int) Math.ceil(Math.log(n) / Math.log(2));
        max = (int) Math.pow(2, l) - 1;
        SGTMin = new int[2 * max + 1];
        SGTSum = new long[2 * max + 1];
    }

    public int[] gather(int k, int maxRow) {
        int idx=getMin(0, maxRow, 0, max, 0, m - k);
        if (idx==-1) return new int[] {}; 
        int tmp = SGTMin[idx];
        add(idx, k);
        return new int[] { idx-max, tmp };
    }

    int full = 0;

    public boolean scatter(int k, int maxRow) {
        if ((long) (maxRow + 1) * m - getSum(0, maxRow, 0, max, 0) < k)
            return false;
        for (int i = full; i <= maxRow; i++) {
            if (m - SGTMin[i + max] >= k) {
                add(i + max, k);
                return true;
            } else {
                full = i + 1;
                k -= m - SGTMin[i + max];
                add(i + max, m - SGTMin[i + max]);
            }
        }
        return true;
    }

    public void add(int i, int num) {
        SGTMin[i] += num;
        SGTSum[i] += num;
        int min = SGTMin[i];
        while (i > 0) {
            if (i % 2 == 1) {
                min = Math.min(SGTMin[i], SGTMin[i + 1]);
            } else if (i % 2 == 0) {
                min = Math.min(SGTMin[i - 1], SGTMin[i]);
            }
            i = (i - 1) / 2;
            SGTMin[i] = min;
            SGTSum[i] += num;
        }
    }

    public int getMin(int l, int r, int left, int right, int i, int k) {
        if (right < l || left > r || SGTMin[i] > k)
            return -1;
        if (left == right)
            return i;
        int mid = (left + right) >>> 1;
        int res = getMin(l, r, left, mid, 2 * i + 1, k);
        if (res >= 0)
            return res;
        return getMin(l, r, mid + 1, right, 2 * i + 2, k);
    }

    public long getSum(int l, int r, int left, int right, int i) {
        if (right < l || left > r)
            return 0;
        if (left >= l && right <= r)
            return SGTSum[i];
        int mid = (left + right) >>> 1;
        return getSum(l, r, left, mid, 2 * i + 1) + getSum(l, r, mid + 1, right, 2 * i + 2);
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
