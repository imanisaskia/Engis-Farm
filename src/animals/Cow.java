package animals;

public class Cow extends MilkProducingAnimal {
    private static final String noise = "Moo-o-o!";
    private static final double hungerRate = 0.2;

    public Cow(int i, int j) {
        super(i,j);
    }

    public String getNoise() {
        return noise;
    }

    public double getHungerRate() {
        return hungerRate;
    }
}