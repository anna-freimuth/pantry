import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class List<K, V> implements IOperation {
    HashMap<K, V> map;

    public List(HashMap<K, V> map) {
        this.map = map;
    }

    @Override
    public Map<K, V> operate() {
        for (Map.Entry<K, V> pair : map.entrySet()) {
            System.out.println(
                    pair.getKey() +
                    " -> " +
                    ((LocalDate) pair.getValue()).format(DateTimeFormatter.ofPattern("y-M-d"))
            );
        }
        return map;
    }
}



