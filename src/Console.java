import java.util.*;
import java.util.stream.Collectors;

public class Console implements Runnable {

    private Map<String, ArrayList<Vector>> train;
    public Console(Map<String, ArrayList<Vector>> train) {
        this.train = train;
    }

    @Override
    public void run() {
        System.out.println("Type vector dimensions and k value");
        Scanner sc = new Scanner(System.in);

        String[] parts = sc.nextLine().split(",");

        while (parts.length != FileLoader.getLineSize()) {
            System.out.println("Invalid vector dimensions. Try again:");
            parts = sc.nextLine().split(",");
        }

        List<String> dimensions = Arrays.stream(parts)
                .limit(parts.length - 1)
                .collect(Collectors.toList());

        int k = Integer.parseInt(parts[parts.length - 1]);
        Vector vector = new Vector(dimensions);

        Algorithm algorithm = new Algorithm(train, k);
        algorithm.doAlgorithm(vector);

        String vectorType = algorithm.getType();
        System.out.println(vector + " : " + vectorType);
    }
}
