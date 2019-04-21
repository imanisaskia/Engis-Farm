package animals;

/** Class of pig, inherits MeatProducingAnimal. Methods include getters for animal noise and hunger rate.
 * @author Saskia Imani (13517142)
 */
public class Pig extends MeatProducingAnimal {
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