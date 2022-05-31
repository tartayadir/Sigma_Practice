package taskForEnums;

public class Fest {

    private String name , city;
    private YearMonth monthOfeYear;

    public Fest(String name, String city, YearMonth monthOfeYear) {
        this.name = name;
        this.city = city;
        this.monthOfeYear = monthOfeYear;
    }

    public String getName() {return name;}
    public String getCity() {return city;}
    public YearMonth getMonthOfeYear() {return monthOfeYear;}

    @Override
    public String toString() {
        return "Fest{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", monthOfeYear=" + monthOfeYear +
                '}';
    }
}
