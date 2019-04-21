package animals;

/** Class of duck, inherits EggProducingAnimal. Methods include getters for animal noise and hunger rate.
 * @author Saskia Imani (13517142)
 */
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