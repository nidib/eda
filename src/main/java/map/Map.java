package map;

import java.util.Objects;

public class Map<K, V> {
    static class KeyValue<K, V> {
        K key;
        V value;

        KeyValue(K key) {
            this.key = key;
            this.value = null;
        }

        KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyValue<?, ?> keyValue = (KeyValue<?, ?>) o;
            return Objects.equals(key, keyValue.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    DoublyLinkedList<KeyValue<K, V>> list;

    public Map() {
        this.list = new DoublyLinkedList<>();
    }

    public V get(K key) {
        var candidate = this.list.getByValue(new KeyValue<>(key));

        if (candidate == null) {
            return null;
        }

        return candidate.value;
    }

    public V put(K key, V value) {
        var item = new KeyValue<>(key, value);
        var existing = this.list.getByValue(item);
        var exists = existing != null;

        if (exists) {
            this.list.removeByValue(item);
            this.list.insertAtEnd(item);
            return existing.value;
        }

        this.list.insertAtEnd(item);

        return null;
    }

    public void remove(K key) {}

    public int size() {
        return this.list.size();
    }
}
