package taskForEnums;

public enum YearMonth {
    JANUARY(1,31),
    FEBRUARY(2,28),
    MARCH(3,31),
    APRIL(4,30),
    MAY(5,31),
    JUNE(6,30),
    JULY(7,31),
    AUGUST(8,31),
    SEPTEMBER(9,30),
    OCTOBER(10,31),
    NOVEMBER(11,31),
    DECEMBER(12,31);

    private int numberOfMonth,numberOfDays;

    YearMonth(int numberOfMonth , int numberOfDays){
        this.numberOfMonth = numberOfMonth;
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfMount(){return this.numberOfMonth;}
    public int getNumberOfDays(){return this.numberOfDays;}
}
