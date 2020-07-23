import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private int capacity;
    private LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>();
    //    LinkedHashMap默认的LRU算法是根据键的进入顺序来定的，对于更新值和获取值的操作是忽视的，
    //    因此在更新值和获取值时我们需要先把原值删除再添进一个新值
    private class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            if (size() > capacity) {
                return true;
            } else {
                return false;
            }
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = lruLinkedHashMap.get(key);
        if (null == value) {
            return -1;
        }
        lruLinkedHashMap.remove(key);
        lruLinkedHashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (lruLinkedHashMap.containsKey(key)) {
            lruLinkedHashMap.remove(key);
        }
        lruLinkedHashMap.put(key, value);
    }
}