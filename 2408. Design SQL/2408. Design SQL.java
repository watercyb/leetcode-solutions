/*
 * Problem: 2408. Design SQL
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-sql/
 * Language: java
 * Date: 2026-04-27
 */

class SQL {
    HashMap<String, List<List<String>>> HM = new HashMap<>();;

    public SQL(List<String> names, List<Integer> columns) {
        for (String name : names) {
            HM.put(name, new ArrayList<>());
        }
    }

    public void insertRow(String name, List<String> row) {
        HM.get(name).add(row);
    }

    public void deleteRow(String name, int rowId) {
        // HM.get(name).set(rowId - 1, null);
    }

    public String selectCell(String name, int rowId, int columnId) {
        return HM.get(name).get(rowId - 1).get(columnId - 1);
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * obj.insertRow(name,row);
 * obj.deleteRow(name,rowId);
 * String param_3 = obj.selectCell(name,rowId,columnId);
 */
