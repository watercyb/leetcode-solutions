/*
 * Problem: 2305. Fair Distribution of Cookies
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/fair-distribution-of-cookies/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int l = 0;
        int r = 0;
        for (int cookie : cookies) {
            l = Math.max(cookie, l);
            r += cookie;
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (dfs(cookies, new int[k], cookies.length - 1, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean dfs(int[] cookies, int[] children, int i, int mid) {
        if (i < 0)
            return true;
        for (int j = 0; j < children.length; j++) {
            if (children[j] + cookies[i] <= mid) {
                children[j] += cookies[i];
                if (dfs(cookies, children, i - 1, mid))
                    return true;
                children[j] -= cookies[i];
            }
            if (children[j] == 0)
                break;
        }
        return false;
    }
}
