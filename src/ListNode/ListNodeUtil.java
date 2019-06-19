package ListNode;

import Tree.TreeNode;

public class ListNodeUtil {

    public static ListNode buildListNodeFromLists(int[] lists){
        ListNode root = new ListNode(lists[0]);ListNode curr = root;
        for(int i=1;i<lists.length;i++){
            ListNode listNode = new ListNode(lists[i]);
            curr.next = listNode;
            curr = listNode;
        }

        return root;

    }
}
