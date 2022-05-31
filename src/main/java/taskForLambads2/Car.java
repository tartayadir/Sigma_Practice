package taskForLambads2;

public class Car {

        private int maxSpeed;

        public Car(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                '}';
    }
}


