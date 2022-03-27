import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Vector {
    private ArrayList<Double> points;

    public ArrayList<Double> getPoints() {
        return points;
    }

    public double getPoint(int index) {
        return points.get(index);
    }

    public void setPoints(ArrayList<Double> points) {
        this.points = points;
    }

    public Vector(Collection<Double> points) {
        this.points = new ArrayList<>();
        this.points.addAll(points);
    }

    public Vector(List<String> points) {
        this.points = new ArrayList<>();
        for(String s : points)
            this.points.add(Double.parseDouble(s));
    }

    public void normalize() {
        ArrayList<Double> points = new ArrayList<>();

        for (Double d : this.points) {
            points.add(d / getLength());
        }

        this.points = points;
    }

    public double getLength() {
        double sum = 0;
        for(Double d : points) {
            sum += Math.pow(d, 2);
        }

        return Math.sqrt(sum);
    }

    public String toString() {
        return points.toString();
    }

}
