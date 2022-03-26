import java.io.Console;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        try {
            if (args.length != 3)
                throw new ArrayIndexOutOfBoundsException("Invalid args size");

            FileLoader fl = new FileLoader();
            Map<String, ArrayList<Vector>> train = fl.loadFile(args[0]);
            Map<String, ArrayList<Vector>> test = fl.loadFile(args[1]);

            int k = Integer.parseInt(args[2]);

            if (k < 1)
                throw new IllegalArgumentException("K needs to be positive natural number");

            Algorithm algorithm = new Algorithm(train, Integer.parseInt(args[2]));

            int counter = 0;
            int sum = 0;

            for(Map.Entry<String, ArrayList<Vector>> entry : test.entrySet()) {
                for(Vector vector : entry.getValue()) {
                    algorithm.doAlgorithm(vector);
                    String vectorType = algorithm.getType();

                    System.out.println(vector + " : " + vectorType);

                    if(entry.getKey().equals(vectorType)) {
                        counter++;
                    }
                }
                sum += entry.getValue().size();
            }

            double accuracy = (double)counter * 100 / sum;

            System.out.println("ACCURACY: " + accuracy + '%');


            //Console console = new Console(train);

            while(true) {
                console.run();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
