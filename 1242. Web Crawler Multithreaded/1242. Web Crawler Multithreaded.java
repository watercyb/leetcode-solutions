/*
 * Problem: 1242. Web Crawler Multithreaded
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/web-crawler-multithreaded/
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
    HtmlParser htmlParser;
    TaskCountLatch latch = new TaskCountLatch();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        try {
            this.htmlParser = htmlParser;
            HS.add(startUrl);
            latch.inc();
            Multithreading object = new Multithreading(getHostname(startUrl), startUrl);
            object.start();
            latch.await();
            List<String> res = new ArrayList<>();
            for (String str : HS) {
                res.add(str);
            }
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    HashSet<String> HS = new HashSet<>();

    public String getHostname(String url) {
        return url.split("/")[2];
    }

    class Multithreading extends Thread {
        String hostname;
        String url;

        public Multithreading(String hostname, String url) {
            this.hostname = hostname;
            this.url = url;
        }

        public void run() {
            try {
                // System.out.println(hostname + " " + url);
                List<String> list = htmlParser.getUrls(url);
                for (String next : list) {
                    if (getHostname(next).equals(hostname) && HS.add(next)) {
                        latch.inc();
                        Multithreading object = new Multithreading(hostname, next);
                        object.start();
                    }
                }
            } catch (Exception e) {
            }
            latch.dec();
        }
    }
}

class TaskCountLatch {
    int n = 0;

    public synchronized void inc() {
        n++;
    }

    public synchronized void dec() {
        n--;
        if (n == 0)
            this.notify();
    }

    public synchronized void await() {
        if (n != 0) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
    }
}
