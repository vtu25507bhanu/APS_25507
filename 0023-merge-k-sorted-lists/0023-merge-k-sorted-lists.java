import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode n : lists)
            if (n != null) pq.add(n);

        ListNode dummy = new ListNode(0), tail = dummy;

        while (!pq.isEmpty()) {
            tail = tail.next = pq.poll();
            if (tail.next != null) pq.add(tail.next);
        }

        return dummy.next;
    }
}