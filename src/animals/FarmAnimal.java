package animals;

/** General class for farm animal. Methods include getters and setters for animal properties such as location, hunger, and productivity.
 * @author Saskia Imani (13517142)
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

    /** Returns animal's row position. */
    public int getI()                           { return i; }
    /** Returns animal's column position. */
    public int getJ()                           { return j; }
    /** Returns animal's hunger. */
    public double getHunger()                   { return hunger; }
    /** Returns state of animal's productivity (true = productive). */
    public boolean isProductive()               { return productive; }
    
    /** Returns animal's noise. */
    abstract public String getNoise();
    
    /** Returns animal's allowed land type.
     *  <ol>
     *    <li> Grassland </li>
     *    <li> Barn </li>
     *    <li> Coop </li>
     *  </ol>
     */
    abstract public int getAllowedLandType();
    
    /** Returns animal's hunger rate. */
    abstract public double getHungerRate();

    /** Sets animal's row position. */
    public void setI(int i)                 { this.i = i; }
    /** Sets animal's column position. */
    public void setJ(int j)                 { this.j = j; }
    /** Sets animal's hunger. */
    public void setHunger(double h)         { hunger = h; }
    /** Sets animal's productivity. */
    public void setProductive(boolean v)    { productive = v; }

}