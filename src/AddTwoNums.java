import java.net.SocketOption;

public class AddTwoNums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode p  = res;
        int digit = 0;
        int sum;
        while(l1!=null && l2!=null){
            sum = l1.val+l2.val+digit;
            digit = sum/10;
            sum = sum%10;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            sum = l1.val+digit;
            digit = sum/10;
            sum = sum%10;
            p.next = new ListNode(sum);
            p = p.next;
            l1 = l1.next;
        }

        while(l2!=null){
            sum = l2.val+digit;
            digit = sum/10;
            sum = sum%10;
            p.next = new ListNode(sum);
            p = p.next;
            l2 = l2.next;
        }

        if(digit==1){
            p.next = new ListNode(1);
        }

        return res.next;
    }

    public static void main(String[] args) {

        System.out.println(9/10);
        System.out.println(11/10);
    }
}
