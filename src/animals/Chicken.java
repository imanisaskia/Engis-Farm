package animals;

/** Class of chicken, inherits EggProducingAnimal. Methods include getters for animal noise and hunger rate.
 * @author Saskia Imani (13517142)
 */
public class Chicken extends EggProducingAnimal {
    private static final String noise = "Bok bok bok!";
    private static final double hungerRate = 1;

    public Chicken(int i, int j) {
        super(i,j);
    }

    public String getNoise() {
        return noise;
    }

    public double getHungerRate() {
        return hungerRate;
    }
}