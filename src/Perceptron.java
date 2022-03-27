import java.util.ArrayList;

public class Perceptron {

    private Vector weights;
    private double threshold;
    private double bias;
    ArrayList<Type> types;


    public Perceptron(double threshold, double bias, ArrayList<Type> types) {
        this.threshold = threshold;
        this.bias = bias;
        this.types = types;

        weights = new Vector(new ArrayList<Double>());
    }

    public void setWeights(int size) {
        for(int i = 0; i < size; i++)
            weights.getPoints().add(Math.random() * 10 - 5);
    }

    public void learn(Vector vector, String toCheck) {

        Type type = getType(vector);


        if (!type.getName().equals(toCheck)) {

            if (type.getValue() == 1) {
                changeWeight(vector, 0, 1);
                modifythreshold(0, 1);
            }
            else {
                changeWeight(vector, 1, 0);
                modifythreshold(1, 0);
            }
        }
        System.out.println(threshold + "..." + "W: " + weights);
    }

    public void changeWeight(Vector vector, int d, int y) {
        ArrayList<Double> points = new ArrayList<>();

        int counter = 0;
        for(Double w : weights.getPoints())
            points.add(w + ((d - y) * bias * vector.getPoint(counter++)));

        weights.setPoints(points);
    }

    public void modifythreshold(int d, int y) {
        threshold -= ((d - y) * bias);
    }

    public Type getType(Vector vector) {
        double net = 0;
        int counter = 0;

        for (Double d : vector.getPoints())
            net += d * weights.getPoint(counter++);

        return net < threshold ? types.get(0) : types.get(1);
    }


}
