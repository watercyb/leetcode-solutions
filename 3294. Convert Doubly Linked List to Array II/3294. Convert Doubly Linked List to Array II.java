/*
 * Problem: 3294. Convert Doubly Linked List to Array II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-doubly-linked-list-to-array-ii/
 * Language: java
 * Date: 2026-05-05
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node node) {
        int count = 1;
        Node left = node;
        while (left.prev != null) {
            left = left.prev;
            count++;
        }
        while (node.next != null) {
            node = node.next;
            count++;
        }
        int[] res = new int[count];
        int idx = 0;
        while (left != null) {
            res[idx++] = left.val;
            left = left.next;
        }
        return res;
    }
}
