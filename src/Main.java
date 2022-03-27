import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        try {
            if (args.length != 2)
                throw new ArrayIndexOutOfBoundsException("Invalid args size");

            FileLoader fl = new FileLoader();
            ArrayList<Line> train = fl.loadFile(args[0]);
            ArrayList<Line> test = fl.loadFile(args[1]);

            double threshold = Math.random() * 10 - 5;

            ArrayList<Type> types = FileLoader.getTypes();
            System.out.println(types);

            if (types.size() != 2)
                throw new ArrayIndexOutOfBoundsException("There needs to be only two classes");

            double bias = 0.5;

            Perceptron perceptron = new Perceptron(threshold, bias, types);

            perceptron.setWeights(FileLoader.getLineSize() - 1);

            Algorithm algorithm = new Algorithm(train, test);

            algorithm.doAlgorithm(perceptron);

            algorithm.checkAlgorithm(perceptron);


            System.out.println("bias: " + bias);
            Console console = new Console(perceptron);

            while(true) {
                console.run();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
