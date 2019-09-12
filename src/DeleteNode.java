import ListNode.ListNode;

import java.util.HashMap;
import java.util.Map;

import static ListNode.ListNodeUtil.buildListNodeFromLists;

/**
 * @author Qichao Ying
 * @date 2019/8/26 14:33
 * @Description DEFAULT
 */
public class DeleteNode {
    public static void main(String[] args) {
        ListNode node = buildListNodeFromLists(new int[]{1,-1});
        removeZeroSumSublists(node);
    }

    public static ListNode removeZeroSumSublists(ListNode head) {
        //当前为x，保存的是前一个节点的值
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode fakeHead = new ListNode(0);int sum = 0;fakeHead.next = head;
        while(head!=null){
            sum+=head.val;
            if(sum==0) fakeHead.next = head.next;
            else if(map.containsKey(sum)){
                //remove
                ListNode pre = map.get(sum);
                pre.next = head.next;
            }
            else {
                map.put(sum, head);
            }
            head = head.next;
        }

        return fakeHead.next;
    }
}
