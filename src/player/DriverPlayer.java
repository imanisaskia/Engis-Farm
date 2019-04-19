import player.*;
import animals.*;
import farm_products.*;
import side_products.*;
import display.Display;

public class DriverPlayer{
    public static void main(String[] args){
        Player P = new Player();
        AnimalArray animals = new AnimalArray();
        Display d = new Display("src/display/Map.txt");
        for (int i = 0; i < animals.getLength(); i++ ) {
            System.out.print("(" + animals.getMember(i).getI() + "," + animals.getMember(i).getJ() + ") - ");
            System.out.print(animals.getMember(i).getHunger() + " - ");
            if (animals.getMember(i).isProductive()) {
                System.out.println("Productive");
            } else {
                System.out.println("Unproductive");
            }
        }

        System.out.println();
        System.out.println("coba interact dengan chicken");
        System.out.println("chicken di set productive");
        P.setI(1);
        P.setJ(2);
        animals.getMember(0).setProductive(true);
        for (int i = 0; i < animals.getLength(); i++ ) {
            System.out.print("(" + animals.getMember(i).getI() + "," + animals.getMember(i).getJ() + ") - ");
            System.out.print(animals.getMember(i).getHunger() + " - ");
            if (animals.getMember(i).isProductive()) {
                System.out.println("Productive");
            } else {
                System.out.println("Unproductive");
            }
        }
        System.out.println(animals.getMember(0).isProductive());
        int type=12;
        type = P.interactAnimal(animals, d, P.getI(),P.getJ()-1);
        System.out.println("type : "+type);
        for (int i = 0; i < animals.getLength(); i++ ) {
            System.out.print("(" + animals.getMember(i).getI() + "," + animals.getMember(i).getJ() + ") - ");
            System.out.print(animals.getMember(i).getHunger() + " - ");
            if (animals.getMember(i).isProductive()) {
                System.out.println("Productive");
            } else {
                System.out.println("Unproductive");
            }
        }
        System.out.println(P.getBagFP().getBelonging(0).getType());

        System.out.println();
        System.out.println("coba interact dengan well");
        P.setWater(35);
        P.setI(9);
        P.setJ(9);
        boolean success;
        success = P.interactWell(d, P.getI()+1, P.getJ());
        System.out.println(success);
        System.out.println(P.getWater());

        System.out.println();
        System.out.println("coba interact dengan truck");
        System.out.println("sebelum jual, money : "+P.getMoney());
        P.getBagFP().add(new ChickenEgg());
        P.getBagSP().add(new BeefStew());
        P.setI(9);
        P.setJ(10);
        success=false;
        success=P.InteractTruck(d,P.getI()+1, P.getJ());
        System.out.println(success);
        System.out.println("sesudah jual, money : "+P.getMoney());
        System.out.println("Isi FP: "+P.getBagFP().getSize());
        System.out.println("Isi SP: "+P.getBagSP().getSize());

        System.out.println();
        System.out.println("coba mix beef stew");
        P.setI(9);
        P.setJ(8);
        P.getBagFP().add(new ChickenEgg());
        P.getBagFP().add(new CowMeat());
        P.getBagFP().add(new GoatMilk());
        P.getBagFP().add(new CowMilk());
        success=false;
        BeefStew BS = new BeefStew();
        success=P.mix(d, BS, P.getI()+1, P.getJ());
        System.out.println(success);
        System.out.println("Size SP : "+P.getBagSP().getSize());
        System.out.println("Size FP : "+P.getBagFP().getSize());
        System.out.println("Type FP : "+P.getBagFP().getBelonging(0).getType());
        System.out.println("Type FP : "+P.getBagFP().getBelonging(1).getType());
        System.out.println("Type FP : "+P.getBagFP().getBelonging(2).getType());

    }
}