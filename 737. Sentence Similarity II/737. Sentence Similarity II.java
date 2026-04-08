/*
 * Problem: 737. Sentence Similarity II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/sentence-similarity-ii/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;
        HashMap<String, Integer> HM = new HashMap<>();
        for (List<String> list : similarPairs) {
            for (String str : list) {
                if (!HM.containsKey(str))
                    HM.put(str, HM.size());
            }
        }
        int[] links = new int[HM.size()];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        for (List<String> list : similarPairs) {
            int a = find(links, HM.get(list.get(0)));
            int b = find(links, HM.get(list.get(1)));
            links[a] = b;
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) && (!HM.containsKey(sentence1[i]) || !HM.containsKey(sentence2[i])
                    || find(links, HM.get(sentence1[i])) != find(links, HM.get(sentence2[i]))))
                return false;
        }
        return true;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
