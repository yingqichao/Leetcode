package ListNode;

import java.util.*;

public class SortList {

    public static void main(String[] args) {
//        ListNode head = ListNodeUtil.buildListNodeFromLists(new int[]{1,3,2,4,7,5,6,9,0,8});
//
//        insertionSortList(head);
//
//        ListNodeUtil.print(head);

        int[][] list = new int[][]{new int[]{1,0},new int[]{0,1}};

        System.out.print(canFinish(2,list));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] pair:prerequisites){
            Set<Integer> set = map.getOrDefault(pair[0],new HashSet<>());set.add(pair[1]);
            map.put(pair[0],set);
        }
        Set<Integer> visited = new HashSet<>();Set<Integer> parents = new HashSet<>();

        for(int key:map.keySet()){
            if(!visited.contains(key)){
                if(!dfs(map,visited,parents,key))   return false;

            }

        }
        return true;
    }

    public static boolean dfs(Map<Integer,Set<Integer>> map,Set<Integer> visited,Set<Integer> parents,int key){
        if(!map.containsKey(key))   return true;

        Set<Integer> must = map.get(key);

        for(int musts:must){
            if(parents.contains(musts)) return false;
            parents.add(musts);
            if(!dfs(map,visited,parents,musts)) return false;
            parents.remove(musts);

        }

        visited.add(key);
        return true;
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next == null)  return head;
        ListNode fakeHead = new ListNode(0);fakeHead.next = head;
        ListNode finish = fakeHead;ListNode next = fakeHead.next;
        ListNode first = fakeHead;ListNode second = first.next;
        boolean remove;
        while(next!=null){
            remove = false;
            while(second!=null && second!=next){
                if(second.val>next.val){
                    ListNode newListNode = new ListNode(next.val);first.next = newListNode;newListNode.next = second;
                    remove = true;
                    break;
                }
                first = first.next;second = second.next;
            }
            if(!remove)  {
                finish.next = next;finish = finish.next;
            }
            else finish.next = null;
            first = fakeHead;second = first.next;
            next = next.next;
        }
        return fakeHead.next;
    }


    public static ListNode sortList(ListNode head) {
        if(head==null)  return null;
        if(head.next==null) return head;
        ListNode[] nodes = split(head);
        ListNode A = sortList(nodes[0]);ListNode B = sortList(nodes[1]);
        ListNode fakeHead = new ListNode(0);ListNode curr = fakeHead;
        while(A!=null || B!=null){
            if(A==null)  {
                curr.next = B;   B = B.next;
            }else if(B==null){
                curr.next = A;   A = A.next;
            }
            else if(A.val>B.val){
                curr.next = B;   B = B.next;
            }else{
                curr.next = A;   A = A.next;
            }
            curr = curr.next;
        }

        return fakeHead.next;

    }

    public static ListNode[] split(ListNode head){
        ListNode fakeHead = new ListNode(0);fakeHead.next = head;
        ListNode slow = fakeHead;ListNode fast = fakeHead;
        while(fast!=null && fast.next!=null){
            slow = slow.next;fast = fast.next.next;

        }
        ListNode second = slow.next;slow.next = null;
        return new ListNode[]{fakeHead.next,second};


    }

}
