// Remove Duplicates from Sorted List
public class LC83 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while(current != null && current.next != null){
            if(current.next.val != current.val){
                current = current.next;
                continue;
            }
            current.next = current.next.next;
        }

        return head;
    }
}
