public class MergeList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode head;
        ListNode temp;
        if(list1.val>list2.val){
            head = list2;
            temp = head;
            list2 = list2.next;
        }else{
            head = list1;
            temp = head;
            list1 = list1.next;
        }

        while(true){

            if(list1 ==null){
                temp.next = list2;
                break;
            }
            if(list2==null){
                temp.next = list1;
                break;
            }
            if(list1.val<list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }

        }
    return head;
    }
}
