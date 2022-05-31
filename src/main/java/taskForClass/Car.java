package taskForClass;

import java.util.ArrayList;
import java.util.Objects;

class Car extends Vehicle {

    private boolean isElectric;
    private String typeOfTransmission;

    public Car(String model, String owner, int price, int produceYear, double weight,
               double maxSpeed, boolean isElectric, String typeOfTransmission) {
        super(model, owner, price, produceYear, weight, maxSpeed);
        this.isElectric = isElectric;
        this.typeOfTransmission = typeOfTransmission;
    }

    public Car(String model, String owner, int price, int produceYear) {
        super(model, owner, price, produceYear);
        this.isElectric = false;
        this.typeOfTransmission = "automatic";
    }

    public boolean isElectric() {return isElectric;}
    public void setElectric(boolean electric) {isElectric = electric;}

    public String getTypeOfTransmission() {return typeOfTransmission;}
    public void setTypeOfTransmission(String typeOfTransmission) {this.typeOfTransmission = typeOfTransmission;}

    @Override
    public String toString() {
        return "Car{" +
                "model='" + super.getModel() + '\'' +
                ", owner='" + super.getOwner() + '\'' +
                ", price=" + super.getPrice() +
                ", produceYear=" + super.getProduceYear() +
                ", weight=" + super.getWeight() +
                ", maxSpeed=" + super.getMaxSpeed() +
                "isElectric=" + isElectric +
                ", typeOfTransmission='" + typeOfTransmission + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (!super.equals(o)) return false;
        Car car = (Car) o;
        return this.getOwner()==car.getOwner();
    }


    //Работет , но немного костылем
//------------------------------------------------------------------------------------
    public static void searchNameOfOwnerIntoListOfCar(String name, ArrayList<Car> listOfCar){

        Car car = new Car("H",name,10222 , 1998);
        if(listOfCar.contains(car)){
            System.out.println("В списке есть машина с владельцем \"Serg\" .");
        }else{
            System.out.println("В списке нет машины с владельцем \"Serg\" .");
        }
    }

//-----------------------------------------------------------------------------------

    public static void searchNameOfOwnerIntoListOfCar2(String name, ArrayList<Car> listOfCar){

        boolean result = false;
        for (Car car : listOfCar) {

            if (car.getOwner().equals(name)){
                result=true;
                break;
            }
        }
        if(result){
            System.out.println("В списке есть машина с владельцем \"Serg\" .");
        }else{
            System.out.println("В списке нет машины с владельцем \"Serg\" .");
        }
    }


    public static ArrayList<Car> createListOfCar(int sizeOfList){

        ArrayList<Car> listOfCar = new ArrayList<Car>();
        for(int i=0;i<sizeOfList;i++){
            listOfCar.add(createCar());
        }
        return listOfCar;
    }

    public static Car createCar(){

        int option = (int)(Math.random()*10)%3+1;

        switch (option){
            case 1 :
                return new Bus("E","Maks" ,10220 , 1990);
            case 2 :
                return new PassengerCar("H","Serg" ,10227 , 1998);
            case 3 :
                return new Truck("T","Fedr" , 23444 , 2010);
            default:
                return null;
        }
    }

}
