/*
 * Problem: 271. Encode and Decode Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/encode-and-decode-strings/
 * Language: java
 * Date: 2026-03-31
 */

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < strs.size() - 1; i++) {
            SB.append(strs.get(i));
            SB.append("π");
        }
        SB.append(strs.getLast());
        return SB.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        return Arrays.asList(s.split("π",-1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
