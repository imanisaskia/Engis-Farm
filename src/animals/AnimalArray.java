package animals;

import java.util.ArrayList;
import java.util.Random;
import animals.FarmAnimal;;
// import Display class, use -cp to state root and enable import from subfolder packages

public class AnimalArray {
    /* Constants */
    private static final int MAX_ANIMALS = 18;
    private static final int[] DEFAULT_CHICKEN_POS = {1,1};
    private static final int[] DEFAULT_DUCK_POS = {2,2};
    private static final int[] DEFAULT_COW_POS = {5,0};
    private static final int[] DEFAULT_GOAT_POS = {7,2};
    private static final int[] DEFAULT_PIG_POS = {4,9};
    private static final int[] DEFAULT_RABBIT_POS = {2,9};
    private static final Random rand = new Random();

    /* Array of animals */
    private ArrayList<FarmAnimal> member;

    /* Constructor: Instantiates an animal array with one animal of each kind */
    public AnimalArray() {
        member = new ArrayList<>(MAX_ANIMALS);
        newChicken();
        newDuck();
        newCow();
        newGoat();
        newPig();
        newRabbit();
    }

    /* Getters */
    public FarmAnimal getMember(int x)  { return member.get(x); }
    public int getLength()              { return member.size(); }

    /* Searches for animal at the specified position i,j */
    public int getNearbyAnimal(int i, int j) {
        int index = -999;
        for (int x = 0; x < getLength(); x++) {
            if (member.get(x).getI() == i && member.get(x).getJ() == j) {
                index = x;
            }
        }
        return index;
    }

    /* Adding an animal to the array */
    public void newChicken()    { member.add(new Chicken(DEFAULT_CHICKEN_POS[0], DEFAULT_CHICKEN_POS[1])); }
    public void newDuck()       { member.add(new Duck(DEFAULT_DUCK_POS[0], DEFAULT_DUCK_POS[1])); }
    public void newCow()        { member.add(new Cow(DEFAULT_COW_POS[0], DEFAULT_COW_POS[1])); }
    public void newGoat()       { member.add(new Goat(DEFAULT_GOAT_POS[0], DEFAULT_GOAT_POS[1])); }
    public void newPig()        { member.add(new Pig(DEFAULT_PIG_POS[0], DEFAULT_PIG_POS[1])); }
    public void newRabbit()     { member.add(new Rabbit(DEFAULT_RABBIT_POS[0], DEFAULT_RABBIT_POS[1])); }

    /* Removes member at index x in the array */
    public void removeMember(int x) {
        if (x > 0 && x < member.size()) {
            member.remove(x);
        }
    }

    /* Moves animals in array */
    public void moveMembers(Display d, int playerI, int playerJ) {
        for (FarmAnimal x : member) {
            int move = rand.nextInt(10); // Change this to speedFactor if each animal's speed is different!
            if (move == 0) {
                int i, j;

                // Determining i, j destination
                int iType = rand.nextInt(3);
                int jType = rand.nextInt(3);
                
                if (iType == 1) {
                    i = x.getI() - 1;
                } else if (iType == 2) {
                    i = x.getI() + 1;
                } else {
                    i = x.getI();
                }
                
                if (jType == 1) {
                    j = x.getJ() - 1;
                } else if (jType == 2) {
                    j = x.getJ() + 1;
                } else {
                    j = x.getJ();
                }

                // Checking if destination is allowed and unoccupied
                boolean occupied = false;
                if (i == playerI && j == playerJ) {
                    occupied = true;
                } else if (!d.checkLand(i, j, x.getAllowedLandType())) {
                    occupied = true;
                } else {
                    int k = 0;
                    while (!occupied) {
                        if (member.get(k).getI() == i && member.get(k).getJ() == j) {
                            occupied = true;
                        } else {
                            k++;
                        }
                    }
                }

                // Moving animal if position is checked
                if (!occupied) {
                    x.setI(i);
                    x.setJ(j);
                }

            }
        }
    }

    /* Increases animal hunger by hunger rate (if < 5) or by 1 (if >= 5) */
    public void increaseHunger() {
        for (int i = 0; i < getLength(); i++) {
            if (member.get(i).getHunger() < 5) {
                member.get(i).setHunger(member.get(i).getHunger() + member.get(i).getHungerRate());
            } else {
                member.get(i).setHunger(member.get(i).getHunger() + 1);
            }

            if (member.get(i).getHunger() >= 10) {
                removeMember(i);
            }
        }
    }

    /* Makes animals eat if they are hungry (hunger >= 5) */
    public void makeMembersEat(Display d) {
        for (FarmAnimal x : member) {
            if (x.getHunger() >= 5) {
                if (d.checkGrassy(x.getI(), x.getJ())) {
                    d.modifyGrassy(x.getI(), x.getJ());
                    x.setHunger(0);
                    x.setProductive(true);
                }
            }
        }
    }

    /* Aggregate method to move animals one tick ahead */
    public void tick(Display d, int playerI, int playerJ) {
        increaseHunger();
        makeMembersEat(d);
        moveMembers(d, playerI, playerJ);
    }
}