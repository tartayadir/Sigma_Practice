package taskForFiles;

public class Bottle {

    private double volume;
    private String material, bottle ;

    public Bottle(double volume, String material, String bottle) {
        this.volume = volume;
        this.material = material;
        this.bottle = bottle;
    }

    public double getVolume() {return volume;}
    public void setVolume(int volume) {this.volume = volume;}

    public String getMaterial() {return material;}
    public void setMaterial(String material) {this.material = material;}

    public String getBottle() {return bottle;}
    public void setBottle(String bottle) {this.bottle = bottle;}

    @Override
    public String toString() {
        return "Bottle{" +
                "volume=" + volume +
                ", material='" + material + '\'' +
                ", bottle='" + bottle + '\'' +
                '}';
    }
}
