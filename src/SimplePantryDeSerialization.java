import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

public class SimplePantryDeSerialization {

    public static HashMap<String, LocalDate> simplePantryDeSerialization(String path) {


        HashMap map = null;
        try{
            FileInputStream fis = new FileInputStream(path + "hashmap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            map = (HashMap)ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            // do nothing
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            e.printStackTrace();
        }

        return map == null ? new HashMap<>() : map;
    }
}
