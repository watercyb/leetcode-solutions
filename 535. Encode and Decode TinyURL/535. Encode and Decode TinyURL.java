/*
 * Problem: 535. Encode and Decode TinyURL
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/encode-and-decode-tinyurl/
 * Language: java
 * Date: 2026-04-03
 */

public class Codec {
    HashMap<Integer, String> HM = new HashMap<>();
    int n = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        HM.put(n, longUrl);
        return new StringBuilder("http://tinyurl.com/").append(n++).toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] strs = shortUrl.split("/");
        return HM.get(Integer.valueOf(strs[strs.length - 1]));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
