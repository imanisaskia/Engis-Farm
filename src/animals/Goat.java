package animals;

/** Class of goat, inherits MilkProducingAnimal. Methods include getters for animal noise and hunger rate.
 * @author: Saskia Imani (13517142)
 */
public class Goat extends MilkProducingAnimal {
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