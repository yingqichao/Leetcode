package LRUCache;

public class LRUTest {
    public static void main(String[] args) {

        LRU cache = new LRU(1);
        cache.put(2, 1);
//        cache.put(2, 2);
        cache.get(2);       // returns 1
        cache.put(3, 2);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4



    }

}
