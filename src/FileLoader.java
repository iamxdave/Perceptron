import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileLoader {

    private static int lineSize;

    private static Set<String> names;

    public static int getLineSize() {
        return lineSize;
    }

    public static ArrayList<Type> getTypes() {
        ArrayList<Type> types = new ArrayList<>();

        int counter = 0;
        for(String name : names)
            types.add(new Type(name, counter++));

        return types;
    }

    public FileLoader() {
        lineSize = 0;
        names = new LinkedHashSet<>();
    }

    public ArrayList<Line> loadFile(String path) throws FileNotFoundException {

        File fileToLoad;
        if(Files.exists(Path.of(path)))
            fileToLoad = new File(path);
        else
            throw new FileNotFoundException("Could not find a file");

        ArrayList<Line> vectors = new ArrayList<>();

        String line;
        String[] parts;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileToLoad)));
            while((line = br.readLine()) != null) {
                parts = line.split(",");
                List<Double> points  = Arrays.stream(parts)
                        .limit(parts.length - 1)
                        .map(Double::parseDouble).toList();
                Vector vector = new Vector(points);
                String type = parts[parts.length - 1];

                vectors.add(new Line(vector, type));

                if(names.size() != 2) {
                    names.add(type);
                }

                if(lineSize == 0)
                    lineSize = parts.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vectors;
    }

}
