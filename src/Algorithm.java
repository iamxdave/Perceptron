import java.util.*;

public class Algorithm {

    private final Map<String, ArrayList<Vector>> train;
    private Map<String, Integer> counter;
    private final int k;

    public Algorithm(Map<String, ArrayList<Vector>> train, int k) {
        this.train = train;
        this.k = k;
    }

    public void doAlgorithm(Vector toDetermine, int theta) {
//        Map<String, ArrayList<Double>> distances = new LinkedHashMap<>();
//
//        train.forEach((key, vectorList) -> {
//            if (!distances.containsKey(key))
//                distances.put(key, new ArrayList<>());
//
//            for (Vector vector : vectorList) {
//                distances.get(key).add(vector.euclideanDistance(toDetermine));
//            }
//        });
//
//        distances.forEach((key, value) -> Collections.sort(value));
//
//        counter = new HashMap<>();
//
//        for (int i = 0; i < k; i++) {
//            double min = Double.MAX_VALUE;
//            String type = "";
//
//            for (Map.Entry<String, ArrayList<Double>> entry : distances.entrySet()) {
//                double minType = entry.getValue().get(0);
//
//                if (min > minType) {
//                    min = minType;
//                    type = entry.getKey();
//                }
//            }
//            distances.get(type).remove(0);
//
//            if (!counter.containsKey(type))
//                counter.put(type, 0);
//
//            int count = counter.get(type);
//            counter.put(type, count + 1);
//        }
        Map<String, ArrayList<Double>> outputs = new LinkedHashMap<>();

        train.forEach((key, vectorList) -> {
            if (!outputs.containsKey(key))
                outputs.put(key, new ArrayList<>());

            for (Vector vector : vectorList) {
                outputs.get(key).add(vector.getOutputValue(toDetermine, theta));
            }
        });
    }

    public String getType() {

        Optional<Map.Entry<String, Integer>> entry = counter.entrySet().stream().max(((o1, o2) -> {
            if (o1.getValue().compareTo(o2.getValue()) == 0) {
                return (int) (Math.random() * 2) == 1 ? -1 : 1;
            } else
                return o1.getValue().compareTo(o2.getValue());
        }));


        if (entry.isPresent())
            return entry.get().getKey();
        else
            throw new NoSuchElementException("Couldn't define max entry");

    }
}
