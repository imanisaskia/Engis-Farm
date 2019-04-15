package animals;

abstract public class MilkProducingAnimal extends FarmAnimal {
    private static final int allowedLandType = 2;

    public MilkProducingAnimal(int i, int j) {
        super(i, j);
    }

    public int getAllowedLandType() {
        return allowedLandType;
    }
}