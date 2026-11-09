/*
 * Problem: 4108. Minimum Cost to Make Red Nodes Connected
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-make-red-nodes-connected/
 * Language: javascript
 * Date: 2026-11-09
 */

/**
 * @param {number} n
 * @param {string} colors
 * @param {number[][]} edges
 * @return {number}
 */
var minCost = function (n, colors, edges) {
    const links = [];
    for (let i = 0; i < n; i++) {
        links.push([]);
    }
    for (let edge of edges) {
        links[edge[0]].push(edge[1]);
        links[edge[1]].push(edge[0]);
    }
    const sizes = Array(n).fill(0);
    const sums = Array(n).fill(0);
    let re = dfs(links, colors, sizes, sums, 0, -1);
    let res = Math.min(re[0], re[1]);
    dfsLeft(links, colors, sizes, sums, 0, -1, 0);
    re = dfsRight(links, colors, sizes, sums, 0, -1, 0, 0);
    return Math.min(res, re[1]);
};

var dfs = (links, colors, sizes, sums, i, prv) => {
    let a = 0;
    let b = 0;
    let size = 1;
    for (let next of links[i]) {
        if (next != prv) {
            const res = dfs(links, colors, sizes, sums, next, i);
            a += Math.min(res[0], res[1]);
            b += res[1];
            size += res[2];
        }
    }
    if (colors[i] == 'R') {
        b += size;
    } else {
        a += size;
    }
    sizes[i] = size;
    sums[i] = a;
    return [a, b, size];
};

var dfsLeft = (links, colors, sizes, sums, i, prv, sum) => {
    sums[i] += sum;
    let res = 0;
    if (colors[i] == 'R') res += sizes[i];
    for (let next of links[i]) {
        if (next != prv)
            res += dfsLeft(links, colors, sizes, sums, next, i, sum + res);
    }
    return res;
}

var dfsRight = (links, colors, sizes, sums, i, prv, sum, sum1) => {
    let res = [0, sums[i] + sum - sum1];
    let current = 0;
    if (colors[i] == 'R') {
        res[0] += sizes[i];
        current = sizes[i];
    }
    for (let j = links[i].length - 1; j >= 0; j--) {
        const next = links[i][j];
        if (next != prv) {
            const re = dfsRight(links, colors, sizes, sums, next, i, sum + res[0], sum1 + current);
            res[0] += re[0];
            res[1] = Math.min(res[1], re[1]);
        }
    }
    return res;
}
