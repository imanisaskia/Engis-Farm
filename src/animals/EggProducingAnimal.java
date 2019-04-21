package animals;

/** General class for egg-producing animals, inherits FarmAnimal. Method includes getter for allowed land type.
 * @author: Saskia Imani (13517142)
 */
abstract public class EggProducingAnimal extends FarmAnimal {
    private static final int allowedLandType = 3;

    public EggProducingAnimal(int i, int j) {
        super(i, j);
    }

    public int getAllowedLandType() {
        return allowedLandType;
    }
}