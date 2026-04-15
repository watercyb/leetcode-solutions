/*
 * Problem: 1236. Web Crawler
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/web-crawler/
 * Language: java
 * Date: 2026-04-15
 */

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 * public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        HashSet<String> HS = new HashSet<>();
        List<String> res = new ArrayList<>();
        HS.add(startUrl);
        res.add(startUrl);
        host = startUrl.split("http://")[1].split("/")[0];
        dfs(HS, res, startUrl, htmlParser);
        return res;
    }

    String host;

    public void dfs(HashSet<String> HS, List<String> res, String url, HtmlParser htmlParser) {
        for (String nextUrl : htmlParser.getUrls(url)) {
            if (HS.add(nextUrl)) {
                if (nextUrl.contains(host)) {
                    res.add(nextUrl);
                    dfs(HS, res, nextUrl, htmlParser);
                }
            }
        }
    }
}
