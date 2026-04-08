/*
 * Problem: 721. Accounts Merge
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/accounts-merge/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> HM = new HashMap<>();
        int[] links = new int[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            links[i] = i;
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (HM.containsKey(email)) {
                    links[unionFind(links, links[i])] = unionFind(links, HM.get(email));
                } else {
                    HM.put(email, i);
                }
            }
        }
        List<String>[] lists = new ArrayList[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            lists[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();
            lists[unionFind(links, v)].add(k);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            if (!lists[i].isEmpty()) {
                Collections.sort(lists[i]);
                lists[i].addFirst(accounts.get(i).get(0));
                res.add(lists[i]);
            }
        }
        return res;
    }

    public int unionFind(int[] links, int i) {
        if (links[i] != i)
            links[i] = unionFind(links, links[i]);
        return links[i];
    }
}
