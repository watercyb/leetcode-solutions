/*
 * Problem: 2157. Groups of Strings
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/groups-of-strings/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int[] groupStrings(String[] words) {
        int[] arr = new int[words.length];
        int[] links = new int[words.length];
        int[] counts = new int[words.length];
        HashMap<Integer, Integer> HM = new HashMap<>(words.length * 26, 0.99f);
        for (int i = 0; i < words.length; i++) {
            int h = getH(words[i]);
            arr[i] = h;
            links[i] = i;
            counts[i] = 1;
            insert(HM, links, counts, h, i);
            for (int j = 0; j < 26; j++) {
                if ((h & (1 << j)) != 0)
                    continue;
                insert(HM, links, counts, h + (1 << j), i);
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (links[i] == i) {
                res[0]++;
                if (counts[i] > res[1])
                    res[1] = counts[i];
            }
        }
        return res;
    }

    public void insert(HashMap<Integer, Integer> HM, int[] links, int[] counts, int h, int i) {
        if (HM.containsKey(h)) {
            int a = find(links, HM.get(h));
            int b = find(links, i);
            if (a != b) {
                links[a] = b;
                counts[b] += counts[a];
            }
        } else {
            HM.put(h, i);
        }
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }

    public int getH(String word) {
        int res = 0;
        for (char chr : word.toCharArray()) {
            res += 1 << (chr - 'a');
        }
        return res;
    }
}
