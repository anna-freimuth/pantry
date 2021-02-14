import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;

public class SimplePantrySerialization {
    public static void simplePantrySerialization(HashMap<String, LocalDate> map, String path){

        try {
            FileOutputStream fos = new FileOutputStream(path + "hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
