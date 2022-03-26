import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FileLoader {

    private static int lineSize;

    public static int getLineSize() {
        return lineSize;
    }

    public Map<String, ArrayList<Vector>> loadFile(String path) throws FileNotFoundException {

        File fileToLoad;
        if(Files.exists(Path.of(path)))
            fileToLoad = new File(path);
        else
            throw new FileNotFoundException("Could not find a file");

        Map<String, ArrayList<Vector>> vectors = new LinkedHashMap<>();

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

                if(!vectors.containsKey(type))
                    vectors.put(type, new ArrayList<>() {
                    });

                vectors.get(type).add(vector);

                lineSize = parts.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return vectors;
    }
}
