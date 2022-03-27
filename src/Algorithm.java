import java.util.*;

public class Algorithm {

    private final ArrayList<Line> train;
    private final ArrayList<Line> test;

    public Algorithm(ArrayList<Line> train, ArrayList<Line> test) {
        this.train = train;
        this.test = test;
    }

    public void doAlgorithm(Perceptron perceptron) {

        for(int i = 0; i < 10; i++) {
            shuffleArray(train);
            train.forEach(line -> {
                perceptron.learn(line.getVector(), line.getType());
            });
        }
    }

    public void checkAlgorithm(Perceptron perceptron) {

        int counter = 0;
        int sum = 0;

        shuffleArray(test);
        for(Line line : test) {
            Vector vector = line.getVector();
            Vector copy = new Vector(vector.getPoints());


            Type type = perceptron.getType(vector);

            if(type.getName().equals(line.getType())) {
                counter++;
            }
            System.out.println(copy + " : " + type);
        }

        sum += test.size();


        double accuracy = (double)counter * 100 / sum;

        System.out.println("ACCURACY: " + accuracy + '%');
    }

    public void shuffleArray(ArrayList<Line> ar)
    {
        Random rnd = new Random();
        for (int i = ar.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            Line a = ar.get(index);
            ar.set(index, ar.get(i));
            ar.set(i, a);
        }
    }
}
