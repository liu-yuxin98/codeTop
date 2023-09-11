import java.util.Scanner;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {

        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode temp = sentinel;
        while(canSwap(temp)){
            swap(temp);
            temp = temp.next.next;
        }
        return sentinel.next;
    }
    public boolean canSwap(ListNode head){
        if(head == null || head.next == null || head.next.next==null){
            return false;
        }
        return true;
    }

    public void swap(ListNode sentinel){
        ListNode first = sentinel.next;
        ListNode second = sentinel.next.next;
        ListNode nextFirst = sentinel.next.next.next;
        second.next = null;
        first.next = null;
        sentinel.next = second;
        second.next = first;
        first.next = nextFirst;
    }

    public static void main(String[] args) {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("You entered string " + s);

        int a = in.nextInt();
        System.out.println("You entered integer " + a);

        float b = in.nextFloat();
        System.out.println("You entered float " + b);
    }

}
