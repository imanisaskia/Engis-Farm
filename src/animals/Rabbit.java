package animals;

/** Class of cow, inherits MeatProducingAnimal. Methods include getters for animal noise and hunger rate.
 * @author: Saskia Imani (13517142)
 */
public class Rabbit extends MeatProducingAnimal {
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