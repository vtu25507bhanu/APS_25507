class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;

        // Check if there are at least k nodes
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If yes, reverse first k nodes
        if (count == k) {
            curr = reverseKGroup(curr, k); // recursive call for next groups
            
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }
            head = curr;
        }

        return head;
    }
}