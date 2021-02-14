import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    private static String path;

    public static void main(String[] args) {

        path = System.getenv("HOME") + "/.pantry/";

        createPathIfNotExists();

        if (args.length == 0) {

            usage();
            System.exit(1);
        }

        switch (args[0]) {
            case "add":
                add(args);
                break;
            case "list":
                list(args);
                break;
            case "delete":
                delete(args);
                break;
            default:
                System.err.println("Unknown command " + args[0]);
                System.exit(1);
        }
    }

    private static void createPathIfNotExists() {

        File directory = new File(path);
        if (!directory.exists())
            directory.mkdir();
    }

    private static void delete(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: pantry delete <key>");
            System.exit(1);
        }
        HashMap<String, LocalDate> map = SimplePantryDeSerialization.simplePantryDeSerialization(path);
        IOperation operation = new Remove<>(map, args[1]);
        operation.operate();
        SimplePantrySerialization.simplePantrySerialization(map, path);
    }


    private static void add(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: pantry add <key> <value>");
            System.exit(1);
        }
        HashMap<String, LocalDate> map = SimplePantryDeSerialization.simplePantryDeSerialization(path);
        IOperation operation = new Add<>(map, args[1], LocalDate.parse(args[2]));
        operation.operate();
        SimplePantrySerialization.simplePantrySerialization(map, path);
    }

    private static void list(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: pantry list");
            System.exit(1);
        }
        HashMap<String, LocalDate> map = SimplePantryDeSerialization.simplePantryDeSerialization(path);
        IOperation operation = new List<>(map);
        operation.operate();
    }

    private static void usage() {

        System.out.println("pantry {add|delete|list}");
    }
}
