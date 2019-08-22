/**
 * @author Qichao Ying
 * @date 2019/7/25 13:49
 * @Description HashMap Design based on https://leetcode.com/problems/design-hashmap/
 */

public class MyHashMap<K, V> {
    /**
     * @Params  
     * @Return  
     * @Description
     * @CreateTime 14:19
     */
    private class MyEntry<K, V> {
        K key;
        V value;
        MyEntry<K, V> next;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    private static final Integer DEFAULT_CAPACITY = 10;
    private static final Double DEFAULT_LOAD_FACTOR = 0.75;
    private MyEntry[] myEntrySet;
    private Integer size;


    public MyHashMap(Integer cap) {
        // this.myEntrySet = (MyEntry<K, V>[]) (new MyEntry[cap]);
        this.myEntrySet = new MyEntry[cap];
        this.size = 0;
    }
    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    // 0x7FFFFFFF is 0111 1111 1111 1111 1111 1111 1111 1111 : all 1 except the sign bit.
    // (hash & 0x7FFFFFFF) will result in a positive integer.
    // (hash & 0x7FFFFFFF) % tab.length will be in the range of the tab length.
    private Integer hash(K key) {
        if (key == null) {
            return 0;
        }
        Integer hashcode = key.hashCode();
        return hashcode & 0x7FFFFFFF;
    }
    private Integer getIndex(Integer hash) {
        return hash % myEntrySet.length;
    }

    private boolean equalKeys(K k1, K k2) {
        return k1 == k2 || k1 != null && k1.equals(k2);
    }
    private boolean equalValues(V v1, V v2) {
        return v1 == v2 || v1 != null && v1.equals(v2);
    }


    public V put(K key, V value) {
        Integer index = getIndex(hash(key));
        MyEntry<K, V> cur = myEntrySet[index];
        while(cur != null) {
            if (equalKeys(cur.getKey(), key)) {
                V result = cur.getValue();
                cur.setValue(value);
                return result;
            }
            cur = cur.next;
        }
        MyEntry<K, V> newHead = new MyEntry<>(key, value);
        newHead.next = myEntrySet[index];
        myEntrySet[index] = newHead;
        size++;
        // Rehashing
        return null;
    }


    public V get(K key) {
        Integer index = getIndex(hash(key));
        MyEntry<K, V> cur = myEntrySet[index];
        while(cur != null) {
            if (equalKeys(cur.getKey(), key)) {
                return cur.getValue();
            }
            cur = cur.next;
        }
        return null;
    }

    
    public V remove(K key) {
        Integer index = getIndex(hash(key));
        MyEntry<K, V> cur = myEntrySet[index];
        MyEntry<K, V> pre = null;
        while(cur != null) {
            if (equalKeys(cur.getKey(), key)) {
                V result = cur.getValue();
                if (pre == null) {
                    myEntrySet[index] = cur.next;

                } else {
                    pre.next = cur.next;
                }
                cur.next = null;
                size--;
                return result;
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }

    
    public boolean containsKey(K key) {
        Integer index = getIndex(hash(key));
        MyEntry<K, V> cur = myEntrySet[index];
        while(cur != null) {
            if (equalKeys(cur.getKey(), key)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    
    public boolean containsValue(V value) {
        if (this.isEmpty()) {
            return false;
        } else {
            for (MyEntry<K, V> myEntry: myEntrySet) {
                while (myEntry != null) {
                    if (equalValues(myEntry.getValue(), value)) {
                        return true;
                    }
                    myEntry = myEntry.next;
                }
            }
        }
        return false;
    }

    
    public Integer size() {
        return this.size;
    }

    
    public boolean isEmpty() {
        return this.size == 0;
    }
}
