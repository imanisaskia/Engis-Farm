package animals;

abstract public class EggProducingAnimal extends FarmAnimal {
    private static final int allowedLandType = 3;

    public EggProducingAnimal(int i, int j) {
        super(i, j);
    }

    public int getAllowedLandType() {
        return allowedLandType;
    }
}