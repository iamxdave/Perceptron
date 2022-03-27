import java.util.*;
import java.util.stream.Collectors;

public class Console implements Runnable {

    private Perceptron perceptron;

    public Console(Perceptron perceptron) {
        this.perceptron = perceptron;
    }

    @Override
    public void run() {
        System.out.println("Type vector dimensions");
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.nextLine().split(",");

        while (parts.length != FileLoader.getLineSize() - 1) {
            System.out.println("Invalid vector dimensions. Try again:");
            parts = sc.nextLine().split(",");
        }

        List<String> dimensions = Arrays.stream(parts)
                .collect(Collectors.toList());

        Vector vector = new Vector(dimensions);

        System.out.println(vector + " : " + perceptron.getType(vector).getName());
    }
}
