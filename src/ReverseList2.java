import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode front = sentinel;
        ListNode rightNode = sentinel;

        for(int i=0;i<right;i++){
            if(i<left-1){
                front = front.next;
                rightNode = rightNode.next;
            }else{
                rightNode = rightNode.next;
            }
        }
        ListNode leftNode = front.next;
        ListNode back = rightNode.next;
        front.next = null;
        rightNode.next = null;
        LinkedList<ListNode> reversed =  reverse(leftNode,rightNode);
        ListNode reversehead = reversed.get(0);
        ListNode reversedTail = reversed.get(1);

        front.next = reversehead;
        reversedTail.next = back;

        return sentinel.next;
    }

    public LinkedList<ListNode> reverse(ListNode left, ListNode right){
        LinkedList<ListNode> res = new LinkedList<>();
        if(left==right){
         // no need to reverse
            res.add(left);
            res.add(right);
            return res;
        }else if(left.next==right){
            // len =2;
            right.next = left;
            left.next = null;
            res.add(right);
            res.add(left);
            return res;
        }else{
            ListNode pre = left;
            ListNode cur = left.next;
            pre.next = null;
            ListNode next;

            while(cur!=null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode temp = pre;
            while (temp.next!=null){
                temp = temp.next;
            }
            res.add(pre);
            res.add(temp);

        }

        return res;
    }


    public static void main(String[] args) {
        ReverseList2 sol = new ReverseList2();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode res = sol.reverseBetween(head,1,2);

        ListNode temp = res;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

}
