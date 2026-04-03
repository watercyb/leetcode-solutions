/*
 * Problem: 430. Flatten a Multilevel Doubly Linked List
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * Language: java
 * Date: 2026-04-03
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node tmp=head;
        while (tmp!=null) {
            if (tmp.child!=null) {
                Node next=tmp.next;
                Node res=flatten(tmp.child);
                tmp.next=res;
                tmp.child=null;
                res.prev=tmp;
                while (tmp.next!=null) tmp=tmp.next;
                if (next!=null) {
                    tmp.next=next;
                    next.prev=tmp;
                }
            }
            tmp=tmp.next;
        }
        return head;
    }
}
