package taskForTreads;

public class Pair <T,V> {
    private T firstElement;
    private V secondElement;

    public Pair(T firstElement, V secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public T getFirstElement() {return firstElement;}
    public V getSecondElement() {return secondElement;}
}
