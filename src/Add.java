import java.util.HashMap;
import java.util.Map;

public class Add<K, V> implements IOperation {
    HashMap<K, V> map;
    K key;
    V value;

    public Add(HashMap<K, V> map, K key, V value) {
        this.map = map;
        this.key = key;
        this.value = value;
    }

    @Override
    public Map operate() {
        map.put(key, value);
        return map;
    }
}
