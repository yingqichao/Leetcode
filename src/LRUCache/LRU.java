package LRUCache;

import ListNode.DoublyLinkedList;

import java.util.*;
public class LRU {
    public Map<Integer, DoublyLinkedList<Integer>> map = new HashMap<>();

    public DoublyLinkedList<Integer> head;

    public DoublyLinkedList<Integer> tail;

    public int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        head = new DoublyLinkedList<>(0,0);
        tail = new DoublyLinkedList<>(0,0);
        head.next = tail;tail.prev = head;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            DoublyLinkedList<Integer> list = map.get(key);
            //delete node
            list.prev.next = list.next;
            list.next.prev = list.prev;
            //insert before tail
            list.prev = tail.prev;
            list.next = tail;
            tail.prev.next = list;
            tail.prev = list;

            print();
            return list.value;


        }else {
            print();
            return -1;
        }


    }

    public void print(){
        DoublyLinkedList<Integer> list = head;list = list.next;
        while(list!=null && list!=tail){
            System.out.print(list.key);System.out.print(" ");
            list = list.next;
        }
        System.out.print("\n");

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DoublyLinkedList<Integer> list = map.get(key);
            list.value = value;
            list.prev.next = list.next;
            list.next.prev = list.prev;
            list.prev = tail.prev;
            list.next = tail;
            tail.prev.next = list;
            tail.prev = list;


        }else{
            DoublyLinkedList<Integer> list = new DoublyLinkedList<>(key,value);
            if(map.size()>=capacity){
                //remove the node after head
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.prev = head;

            }
            map.put(key,list);
            list.prev = tail.prev;
            list.next = tail;
            tail.prev.next = list;
            tail.prev = list;
        }

        print();
    }
}

