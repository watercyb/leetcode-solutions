/*
 * Problem: 692. Top K Frequent Words
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/top-k-frequent-words/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> HM = new HashMap<>();
        for (String word : words) {
            HM.put(word, HM.getOrDefault(word, 0) + 1);
        }
        MaxHp MH = new MaxHp();
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            MH.insert(entry.getKey(), entry.getValue());
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(MH.pop());
        }
        return res;

    }
}

class SN {
    String str;
    int in;

    public SN(String str,int in) {
        this.str=str;
        this.in=in;
    }

    public boolean Cmp(SN Sn) {
        if (in > Sn.in || in == Sn.in && str.compareTo(Sn.str) < 0)
            return true;
        return false;
    }
}

class MaxHp {
    ArrayList<SN> Sn;

    public MaxHp() {
        Sn = new ArrayList<SN>();
    }

    public void insert(String str, int in) {
        Sn.add(new SN(str,in));
        MoveUp(Sn.size() - 1);
    }

    public String pop() {
        int n = Sn.size();
        if (n > 0) {
            String str = Sn.get(0).str;
            Swap(0,n-1);
            Sn.remove(n-1);
            if (n>2) {
                MoveDown(0);
            }
            return str;
        }
        return null;
    }

    public void MoveUp(int n) {
        int p = (n - 1) / 2;
        if (Sn.get(p).in < Sn.get(n).in) {
            Swap(p, n);
        }
        if (Sn.get(p).in == Sn.get(n).in && Sn.get(p).str.compareTo(Sn.get(n).str) > 0) {
            Swap(p, n);
        }
        if (p > 0)
            MoveUp(p);
    }

    public void MoveDown(int n) {
        int size = Sn.size();
        int c1 = 2 * n + 1;
        int c2 = 2 * n + 2;
        int c = size;

        if (c2 < size) {
            SN Sn1=Sn.get(c1);
            SN Sn2=Sn.get(c2);
            SN Snn=Sn.get(n);
            if (Sn1.Cmp(Snn) && Sn1.Cmp(Sn2)) {
                Swap(n, c1);
                c = c1;
            }
            if (Sn2.Cmp(Snn) && Sn2.Cmp(Sn1)) {
                Swap(n, c2);
                c = c2;
            }
        }

        if (c2 == size && Sn.get(c1).Cmp(Sn.get(n))) {  
                Swap(n, c1);
                c = c1;
        }

        if (c < size) {
            MoveDown(c);
        }

    }

    public void Swap(int n1, int n2) {
        SN tmp = Sn.get(n1);
        Sn.set(n1, Sn.get(n2));
        Sn.set(n2, tmp);
    }

}
