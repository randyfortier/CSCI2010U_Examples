public class Pair<X, Y> {
    public X key;
    public Y value;

    public Pair(X key, Y value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "Pair(" + key + "," + value + ")";
    }
}