package animals;

public class Goat extends EggProducingAnimal {
    private static final String noise = "Meh-eh-eh!";
    private static final double hungerRate = 0.3;

    public Goat(int i, int j) {
        super(i,j);
    }

    public String getNoise() {
        return noise;
    }

    public double getHungerRate() {
        return hungerRate;
    }
}