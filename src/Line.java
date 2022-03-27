public class Line {

    private Vector vector;
    private String type;

    public Line(Vector vector, String type) {
        this.vector = vector;
        this.type = type;
    }

    public Vector getVector() {
        return vector;
    }

    public String getType() {
        return type;
    }
}
