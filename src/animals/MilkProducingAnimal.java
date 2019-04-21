package animals;

/** General class for meat-producing animals, inherits FarmAnimal. Method includes getter for allowed land type.
 * @author Saskia Imani (13517142)
 */
abstract public class MilkProducingAnimal extends FarmAnimal {
    private static final int allowedLandType = 2;

    public MilkProducingAnimal(int i, int j) {
        super(i, j);
    }

    public int getAllowedLandType() {
        return allowedLandType;
    }
}