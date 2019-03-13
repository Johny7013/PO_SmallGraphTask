package zadanieGrafowe.utils;

public class Pair <K, V>{

    private K first;
    private V second;

    public static <K, V> Pair<K, V> createPair(K first, V second){
        return new Pair<K, V>(first, second);
    }

    private Pair(K first, V second){
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
