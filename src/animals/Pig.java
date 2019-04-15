package animals;

public class Pig extends EggProducingAnimal {
    private static final String noise = "Oink oink!";
    private static final double hungerRate = 0.6;

    public Pig(int i, int j) {
        super(i,j);
    }

    public String getNoise() {
        return noise;
    }

    public double getHungerRate() {
        return hungerRate;
    }
}