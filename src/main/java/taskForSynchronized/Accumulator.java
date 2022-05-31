package taskForSynchronized;

public class Accumulator {

    private double sum;

    public Accumulator() {}
    public synchronized void addToSum(double number){
        sum+=number;
    }

    public synchronized double getSum() {
        return sum;
    }
}
