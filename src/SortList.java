import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        head = mergeSort(head);
        return head;
    }


    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
        ListNode sortedHead = mergeSortedList(left, right);
        return sortedHead;
    }

    public ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeSortedList(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        ListNode head;
        ListNode temp;
        if (p1.val <= p2.val) {
            head = p1;
            temp = head;
            p1 = p1.next;
        } else {
            head = p2;
            temp = head;
            p2 = p2.next;
        }
        while (true) {
            if (p1 == null) {
                temp.next = p2;
                break;
            }
            if (p2 == null) {
                temp.next = p1;
                break;
            }
            if (p1.val <= p2.val) {
                temp.next = p1;
                p1 = p1.next;
                temp = temp.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
                temp = temp.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        SortList sol = new SortList();
        ListNode res = sol.sortList(head);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
