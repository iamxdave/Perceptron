import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vector {
    private final ArrayList<Double> points = new ArrayList<>();


    public Vector(Collection<Double> points) {
        this.points.addAll(points);
    }

    public Vector(List<String> points) {
        for(String s : points)
            this.points.add(Double.parseDouble(s));
    }

    public ArrayList<Double> normalizedPoints() {
        ArrayList<Double> list = new ArrayList<>();
        list.forEach(d -> d = d / getLength());
        return list;
    }

    public Double getLength() {
        double sum = 0;
        for(Double d : points) {
            sum += Math.pow(d, 2);
        }

        return Math.sqrt(sum);
    }
    public double getOutputValue(Vector input, int theta) {
        double net = 0;

        for(Double oPoint : normalizedPoints()) {
            for(Double iPoint : input.normalizedPoints()) {
                net += oPoint * iPoint;
            }
        }

        return net < theta? 0 : 1;
    }



    public ArrayList<Double> getPoints() {
        return points;
    }

    public String toString() {
        return points.toString();
    }

}
