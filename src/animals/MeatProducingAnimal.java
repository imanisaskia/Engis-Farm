package animals;

abstract public class MeatProducingAnimal extends FarmAnimal {
    private static final int allowedLandType = 1;

    public MeatProducingAnimal(int i, int j) {
        super(i, j);
    }

    public int getAllowedLandType() {
        return allowedLandType;
    }
}