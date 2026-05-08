/*
 * Problem: 3590. Kth Smallest Path XOR Sum
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/kth-smallest-path-xor-sum/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] kthSmallest(int[] par, int[] vals, int[][] queries) {
        getArr(par, vals, queries);
        int[] res = new int[queries.length];
        dfs(vals, res, 0);
        for (int i = 0; i < res.length; i++) {
            if (res[i] != -1)
                res[i] = idxToXor[res[i]];
        }
        return res;
    }

    public void getArr(int[] par, int[] vals, int[][] queries) {
        links = new ArrayList[par.length];
        ques = new ArrayList[par.length];
        for (int i = 0; i < links.length; i++) {
            links[i] = new ArrayList<>();
            ques[i] = new ArrayList<>();
        }
        for (int i = 1; i < par.length; i++) {
            links[par[i]].add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            ques[queries[i][0]].add(new int[] { queries[i][1], i });
        }
        boolean[] seens = new boolean[200000];
        hasQueries = new boolean[par.length];
        childCounts = new int[par.length];
        dfs(seens, vals, 0, 0);
        for (int i = 0; i < links.length; i++) {
            Collections.sort(links[i], (a, b) -> childCounts[b] - childCounts[a]);
        }
        int[] xorToIdx = new int[200000];
        idxToXor = new int[count];
        int idx = 0;
        for (int i = 0; i < seens.length; i++) {
            if (seens[i]) {
                idxToXor[idx] = i;
                xorToIdx[i] = idx++;
            }
        }
        for (int i = 0; i < vals.length; i++) {
            vals[i] = xorToIdx[vals[i]];
        }
    }

    List<Integer>[] links;
    List<int[]>[] ques;
    int count = 0;
    boolean[] hasQueries;
    int[] idxToXor;
    int[] childCounts;

    public boolean dfs(boolean[] seens, int[] vals, int i, int xor) {
        xor ^= vals[i];
        vals[i] = xor;
        if (!seens[xor]) {
            seens[xor] = true;
            count++;
        }
        boolean res = false;
        childCounts[i] = 1;
        for (int next : links[i]) {
            if (dfs(seens, vals, next, xor))
                res = true;
            childCounts[i] += childCounts[next];
        }
        hasQueries[i] = res;
        if (!ques[i].isEmpty())
            res = true;
        return res;
    }

    public void dfs(int[] vals, Sort sort, int i) {
        sort.insert(vals[i]);
        for (int next : links[i]) {
            dfs(vals, sort, next);
        }
    }

    public Sort dfs(int[] vals, int[] res, int i) {
        if (!hasQueries[i]) {
            Sort sort = new Sort(idxToXor.length);
            dfs(vals, sort, i);
            for (int[] pair : ques[i]) {
                res[pair[1]] = sort.get(pair[0]);
            }
            return sort;
        } else {
            Sort sort = null;
            for (int next : links[i]) {
                if (sort == null) {
                    sort = dfs(vals, res, next);
                } else {
                    sort.merge(dfs(vals, res, next));
                }
            }
            if (sort == null)
                sort = new Sort(idxToXor.length);
            sort.insert(vals[i]);
            for (int[] pair : ques[i]) {
                res[pair[1]] = sort.get(pair[0]);
            }
            return sort;
        }
    }
}

class Sort {
    HashSet<Integer> HS = new HashSet<>();
    boolean[][] seens;
    int[] counts;

    public Sort(int n) {
        int c = (int) Math.ceil(Math.sqrt(n));
        int r = n / c;
        if (r * c < n)
            r++;
        seens = new boolean[r][c];
        counts = new int[r];
    }

    public void merge(Sort sort) {
        for (int num : sort.HS) {
            insert(num);
        }
    }

    public void insert(int num) {
        if (HS.add(num)) {
            int r = num / seens[0].length;
            int c = num % seens[0].length;
            seens[r][c] = true;
            counts[r]++;
        }
    }

    public int get(int k) {
        if (k > HS.size())
            return -1;
        int idx = 0;
        while (counts[idx] < k) {
            k -= counts[idx++];
        }
        for (int i = 0; i < seens[0].length; i++) {
            if (seens[idx][i]) {
                if (--k == 0)
                    return idx * seens[0].length + i;
            }
        }
        return -1;
    }
}
