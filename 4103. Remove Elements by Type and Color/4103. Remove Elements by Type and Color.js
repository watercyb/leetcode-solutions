/*
 * Problem: 4103. Remove Elements by Type and Color
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/remove-elements-by-type-and-color/
 * Language: javascript
 * Date: 2026-11-08
 */

/**
 * @param {number[]} types
 * @param {number[]} colors
 * @param {number[]} groupSize
 * @return {boolean}
 */
var canRemoveAll = function (types, colors, groupSize) {
    const st = [];
    for (let i = 0; i < types.length; i++) {
        const t = types[i];
        const c = colors[i];
        if (st.length == 0 || (st[st.length - 1][0] != t || st[st.length - 1][1] != c)) {
            st.push([t, c, 1]);
        } else {
            st[st.length - 1][2]++;
        }
        const last = st[st.length - 1];
        const lt = last[0];
        const ls = last[2];
        if (groupSize[lt] == ls)
            st.pop();
    }
    return st.length == 0;
};
