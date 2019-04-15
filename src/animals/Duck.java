package animals;

public class Duck extends EggProducingAnimal {
    private static final String noise = "Quack!";
    private static final double hungerRate = 0.75;

    public Duck(int i, int j) {
        super(i,j);
    }

    public String getNoise() {
        return noise;
    }

    public double getHungerRate() {
        return hungerRate;
    }
}