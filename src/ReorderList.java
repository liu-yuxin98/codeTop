import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        // find mid of the array
        ListNode mid = findMid(head);
        // reverse right half
        reverseRestFromNode(mid);
        //
        ListNode front = head;
        ListNode back = mid.next;
        while (back!=null) {
            if(front==mid){
                break;
            }
            remove(mid, back);
            insert(front,back);
            front = front.next.next;
            back = mid.next;
        }

    }

    public void remove(ListNode front, ListNode node){
        front.next = node.next;
        node.next = null;
    }

    public void insert(ListNode front, ListNode node){
        ListNode next = front.next;
        front.next = node;
        node.next = next;
    }

    public ListNode findMid(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode slow = sentinel;
        ListNode fast = sentinel;

        while (true) {
            if (fast == null || fast.next == null) {
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    public void reverseRestFromNode(ListNode mid) {
        // reverse the list from this node
        mid.next = reverse(mid.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next;
        pre.next = null;
        while (true) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            if (next == null) {
                return cur;
            }
            cur = next;
        }

    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode((2));
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ReorderList sol = new ReorderList();
        sol.reorderList(node);
    }

}
