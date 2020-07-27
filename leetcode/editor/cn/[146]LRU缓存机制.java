//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    private int capacity;
    private LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>();
    //    LinkedHashMap默认的LRU算法是根据键的进入顺序来定的，对于更新值和获取值的操作是忽视的，
    //    因此在更新值和获取值时我们需要先把原值删除再添进一个新值，提高优先级
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
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
