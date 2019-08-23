package theSourceCode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMap {

    //内部
    transient Entry[] table;

    /**
     * Entry 存储着键值对。它包含了四个字段，从 next 字段我们可以看出 Entry 是一个链表。
     * 即数组中的每个位置被当成一个桶，一个桶存放一个链表。
     * HashMap 使用拉链法来解决冲突，同一个链表中存放哈希值和散列桶取模运算结果相同的 Entry。
     *
     *
     *
     *
     * 拉链法的工作原理：
     *              HashMap<String, String> map = new HashMap<>();
     *              map.put("K1", "V1");
     *              map.put("K2", "V2");
     *              map.put("K3", "V3");
     *
     * 新建一个 HashMap，默认大小为 16；
     * 插入 <K1,V1> 键值对，先计算 K1 的 hashCode 为 115，使用除留余数法得到所在的桶下标 115%16=3。
     * 插入 <K2,V2> 键值对，先计算 K2 的 hashCode 为 118，使用除留余数法得到所在的桶下标 118%16=6。
     * 插入 <K3,V3> 键值对，先计算 K3 的 hashCode 为 118，使用除留余数法得到所在的桶下标 118%16=6，插在 <K2,V2> 前面。
     *
     * 链表的插入是头插入
     *
     *
     * 查找：
     *      1.计算键值对所在的桶
     *      2.在链表中查找，时间复杂度与链表长度成正比
     *
     * @param <K>
     * @param <V>
     */
    static class Entry<K,V> implements Map.Entry<K,V> {
        final K key;
        V value;
        Entry<K, V> next;
        int hash;

        Entry(int h, K k, V v, Entry<K, V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry) o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }


        /**
         * HashMap 允许插入键为 null 的键值对。
         * 但是因为无法调用 null 的 hashCode() 方法，也就无法确定该键值对的桶下标，
         * 只能通过强制指定一个桶下标来存放。HashMap 使用第 0 个桶存放键为 null 的键值对。
         *
         *
         * public V put(K key, V value) {
         *     if (table == EMPTY_TABLE) {
         *         inflateTable(threshold);
         *     }
         *     // 键为 null 单独处理
         *     if (key == null)
         *         return putForNullKey(value);
         *     int hash = hash(key);
         *     // 确定桶下标
         *     int i = indexFor(hash, table.length);
         *     // 先找出是否已经存在键为 key 的键值对，如果存在的话就更新这个键值对的值为 value
         *     for (Entry<K,V> e = table[i]; e != null; e = e.next) {
         *         Object k;
         *         if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
         *             V oldValue = e.value;
         *             e.value = value;
         *             e.recordAccess(this);
         *             return oldValue;
         *         }
         *     }
         *
         *     modCount++;
         *     // 插入新键值对
         *     addEntry(hash, key, value, i);
         *     return null;
         * }
         *
         */


        /**
         * 令 x = 1<<4，即 x 为 2 的 4 次方，它具有以下性质：
         *
         * x   : 00010000
         * x-1 : 00001111
         *
         * y       : 10110010
         * x-1     : 00001111
         *
         * y&(x-1) : 00000010
         * y%x : 00000010
         *
         * 位运算的代价比求模运算小的多，因此在进行这种计算时用位运算的话能带来更高的性能。
         *
         * 确定桶下标的最后一步是将 key 的 hash 值对桶个数取模：hash%capacity，
         * 如果能保证 capacity 为 2 的 n 次方，那么就可以将这个操作转换为位运算。
         *
         * static int indexFor(int h, int length) {
         *     return h & (length-1);
         * }
         *
         */


        Map<String, String> map = new ConcurrentHashMap<>();

    }




}
