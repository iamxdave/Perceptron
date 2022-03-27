

public class Type {

    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public Type(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
