package animals;

/** General class for farm animal. Methods include getters and setters for animal properties such as location, hunger, and productivity.
 * @author: Saskia Imani (13517142)
 */
abstract public class FarmAnimal {
    private int i, j;
    private double hunger;
    private boolean productive;

    /** Constructor */
    public FarmAnimal(int i, int j) {
        this.i = i;
        this.j = j;
        hunger = 0;
        productive = false;
    }

    /** Getters */
    public int getI()                           { return i; }
    public int getJ()                           { return j; }
    public double getHunger()                   { return hunger; }
    public boolean isProductive()               { return productive; }
    abstract public String getNoise();
    abstract public int getAllowedLandType();
    abstract public double getHungerRate();

    /** Setters */
    public void setI(int i)                 { this.i = i; }
    public void setJ(int j)                 { this.j = j; }
    public void setHunger(double h)         { hunger = h; }
    public void setProductive(boolean v)    { productive = v; }

}