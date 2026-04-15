/*
 * Problem: 1268. Search Suggestions System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-suggestions-system/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int l = 0;
        int r = products.length - 1;
        List<List<String>> res = new ArrayList<>();
        int length = searchWord.length();
        for (int i = 0; i < length; i++) {
            List<String> Li = new ArrayList<>();
            char chr = searchWord.charAt(i);
            while (l <=r && (products[l].length() <= i || products[l].charAt(i) != chr)) {
                l++;
            }
            while (r >= l && (products[r].length() <= i || products[r].charAt(i) != chr)) {
                r--;
            }
            int lim = Math.min(r, l + 2);
            for (int j = l; j <= lim; j++) {
                Li.add(products[j]);
            }
            res.add(Li);
        }
        return res;
    }
}
