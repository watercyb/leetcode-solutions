/*
 * Problem: 399. Evaluate Division
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/evaluate-division/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Link> HM = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> tmp = equations.get(i);
            String a = tmp.get(0);
            String b = tmp.get(1);
            if (!HM.containsKey(a)) {
                HM.put(a, new Link(a, 1.0));
            }
            if (!HM.containsKey(b)) {
                HM.put(b, new Link(b, 1.0));
            }
            Link aLink = getFirst(HM, a);
            Link bLink = getFirst(HM, b);
            if (aLink.key.equals(bLink.key))
                continue;
            Link aFirst = HM.get(aLink.key);
            Link bFirst = HM.get(bLink.key);
            if (aLink.key.compareTo(bLink.key) > 0) {
                aFirst.key = bFirst.key;
                aFirst.val = bLink.val / aLink.val * values[i];
            } else {
                bFirst.key = aFirst.key;
                bFirst.val = aLink.val / bLink.val / values[i];
            }
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> tmp = queries.get(i);
            String a = tmp.get(0);
            String b = tmp.get(1);
            if (!HM.containsKey(a) || !HM.containsKey(b)) {
                res[i] = -1;
            } else {
                Link aLink = getFirst(HM, a);
                Link bLink = getFirst(HM, b);
                if (aLink.key != bLink.key) {
                    res[i] = -1;
                } else {
                    res[i] = aLink.val / bLink.val;
                }
            }
        }
        return res;
    }

    public Link getFirst(HashMap<String, Link> HM, String str) {
        Link res = HM.get(str);
        if (str != res.key ) {
            Link tmp=getFirst(HM,res.key);
            res.key = tmp.key;
            res.val *= tmp.val;
        }
        return res;
    }
}

class Link {
    String key;
    double val;

    public Link(String key, double val) {
        this.key = key;
        this.val = val;
    }
}
