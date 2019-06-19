
import ListNode.ListNode;
import ListNode.ListNodeUtil;

public class ReverseListNodeKGroups {
    public static void main(String[] a){

        ListNode root = ListNodeUtil.buildListNodeFromLists(new int[]{1,2,3,4,5,6});
        ListNode res = reverseKGroups(root,3);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }


    }

    public static ListNode reverseKGroups(ListNode root,int K){
        ListNode fakeHead = new ListNode(0);fakeHead.next = root;
        ListNode back = root;ListNode front = back;ListNode prev = fakeHead;int count = 0;
        while(front!=null){
            if(count!=K-1){
                front = front.next;
                count++;
            }else{
                ListNode tmp = front.next;front.next = null;
                reverseList(back);
                prev.next = front;prev = back;
                front = tmp;back = tmp;
                count = 0;
            }


        }

        prev.next = back;

        return fakeHead.next;

    }


    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)   return head;
        ListNode pre = head;ListNode cur = head.next;
        pre.next = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }

}
