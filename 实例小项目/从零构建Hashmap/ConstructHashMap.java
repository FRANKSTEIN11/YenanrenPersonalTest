package com.heaboy.EqualsAndHashcode;

public class ConstructHashMap {

    public static final int DEFAULT_INITIAL_CAPACITY = 16;

    public static Entry[] entries = new Entry[DEFAULT_INITIAL_CAPACITY];

    static class Entry<K, V> {
        private int hash;
        private K key;
        private V value;
        private Entry next;

        public Entry() {

        }

        public Entry(Entry<K, V> entry) {
            this.hash = entry.hash;
            this.key = entry.key;
            this.value = entry.value;
        }

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public void set(K key, V value) {
            int hash = setHashCode(key);
            Integer integer = hash % 16;
            Entry entry = entries[integer];
            if (entry == null) {
                entries[integer] = new Entry(hash, key, value);
                return;
            }

            while (entry.next != null) {
                entry = entry.next;
            }
            entry.next = new Entry(hash, key, value);
        }

        private Entry get(K key) {
            int hash = setHashCode(key);
            Integer integer = hash % 16;
            Entry entry = entries[integer];
            while (entry != null) {
                if (entry.key == key) {
                    return new Entry(entry);
                }
                entry = entry.next;
            }
            return null;
        }

        private Integer setHashCode(K key) {
            int h;
            //为了更好的均匀散列表的下标
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        }

        @Override
        public String toString() {
            return "key=" + key +
                    ", value=" + value;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Entry<Integer, String> entry = new Entry<>();
            entry.set(i, "第" + i + "个表");
        }

        Entry<Integer, String> entry = new Entry<>();
        for (int i = 0; i < 6; i++) {
            System.out.println(entry.get(i));
        }
    }
}
