import java.util.HashMap;
import java.util.Map;

public class Remove<K, V> implements IOperation {
    HashMap<K,V> map;
    K key;

    public Remove(HashMap<K, V> map, K key) {
        this.map = map;
        this.key = key;
    }

    @Override
    public Map operate() {
        if(map.isEmpty())
            return new HashMap();


        if(map.containsKey(key))
            map.remove(key);
        return map;
    }

}
