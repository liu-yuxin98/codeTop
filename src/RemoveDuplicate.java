import java.util.List;

public class RemoveDuplicate {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode pre = sentinel;
        ListNode cur = sentinel.next;
        while (true) {
            if (cur == null) {
                pre.next = null;
                return sentinel.next;
            }
            int freq = countFre(cur);
//            System.out.println(cur.val);
//            System.out.println(freq);
            if (freq == 1) {
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
            } else {
                for (int i = 0; i < freq; i++) {
                    cur = cur.next;
                }
            }
        }
    }


    public int countFre(ListNode cur) {
        int val = cur.val;
        int cnt = 1;
        while (true) {
            if (cur.next == null || cur.next.val != val) {
                return cnt;
            }
            cur = cur.next;
            cnt += 1;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        RemoveDuplicate sol = new RemoveDuplicate();
        ListNode res = sol.deleteDuplicates(head);

        ListNode temp = res;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;

        }
    }
}
