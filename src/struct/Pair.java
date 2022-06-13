package struct;

/**
 * @ClassName Pair
 * @Author conglindeng
 * @Date 2022/5/20 15:19
 * @Version 1.0
 */
public class Pair<K, V> {

    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
