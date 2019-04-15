package animals;

public class Rabbit extends EggProducingAnimal {
    private static final String noise = "Purrrr";
    private static final double hungerRate = 0.5;

    public Rabbit(int i, int j) {
        super(i,j);
    }

    public String getNoise() {
        return noise;
    }

    public double getHungerRate() {
        return hungerRate;
    }
}