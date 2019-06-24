package ListNode;

public class DoublyLinkedList<T> {
    public DoublyLinkedList next;
    public DoublyLinkedList prev;
    public T key;
    public T value;

    public DoublyLinkedList(T key,T value){
        this.key = key;this.value = value;
    }

}
