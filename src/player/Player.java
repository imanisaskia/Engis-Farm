package player;

import animals.*;
import farm_products.*;
import side_products.*;
import display.Display;

public class Player{
    private static final int MAX_WATER=50;

	private Bag<FarmProduct> FPInventory; /*FarmProduct inventory*/
    private Bag<SideProduct> SPInventory; /*SideProduct inventory*/
    private int Money;  /*Player's amount of money*/
    private int Water;  /*Player's amount of water*/
    private int I,J;   /* Player's position*/

	public Player(){
        FPInventory = new Bag<FarmProduct>();
        SPInventory = new Bag<SideProduct>();
        Money = 0;
        Water = 50;
        I = 5;
        J = 5;
	}

    /*getter*/
    public int getMoney(){
        return Money;
    }
    public int getWater(){
        return Water;
    }
    public int getI(){
        return I;
    }
    public int getJ(){
        return J;
    }
    public Bag<FarmProduct> getBagFP(){
        return FPInventory;
    }
    public Bag<SideProduct> getBagSP(){
        return SPInventory;
    }

    /*setter*/
    public void setMoney(int money){
        Money = money;
    }
    public void setWater(int water){
        Water = water;
    }
    public void setI(int i){
        I = i;
    }
    public void setJ(int j){
        J=j;
    }

    /* remove FarmProduct element with type tipe from Bag*/
	public boolean typeBasedRemove(int tipe){
        boolean success=false;
		if(FPInventory.getSize()!=0){
			int j =0;
			boolean found=false;
			while(j<FPInventory.getSize() && !(found)){
				 if(FPInventory.getBelonging(j).getType() == tipe ){
					found=true;
				}else{
					j++;
				}
			}
			if(found){
				FPInventory.remove(FPInventory.getBelonging(j));
				success=true;
            }
        }
        return success;
    }

    /* add FarmProduct element which type = tipe*/
    /*digunakan untuk saat memakai mixer*/
    public void typeBasedAdd(int tipe){
        if(tipe==1){
            FPInventory.add(new ChickenEgg());
        }else if(tipe==2){
            FPInventory.add(new DuckEgg());
        }else if(tipe==3){
            FPInventory.add(new CowMilk());
        }else if(tipe==4){
            FPInventory.add(new GoatMilk());
        }else if(tipe==5){
            FPInventory.add(new ChickenMeat());
        }else if(tipe==6){
            FPInventory.add(new CowMeat());
        }else if(tipe==7){
            FPInventory.add(new PigMeat());
        }else if(tipe==8){
            FPInventory.add(new RabbitMeat());
        }
    }
    
    /*Check FarmAnimal position and Land type, then take FarmProduct
    if exist and valid for Interact, return animal type(Chicken=1, Duck=2, Cow=3, Goat=4)
    else return type -999*/
    public int interactAnimal(AnimalArray arranimal,Display display, int idir, int jdir){
        int type=-999;
        if(idir>=0 && idir<=10 && jdir>=0 && jdir<=10){
            int i = arranimal.getNearbyAnimal(idir,jdir);
            if(i!=-999){
                if(arranimal.getMember(i) instanceof Chicken && display.checkLand(idir,jdir,3)){
                    if(arranimal.getMember(i).isProductive()){
                        arranimal.getMember(i).setProductive(false);
                        FPInventory.add(new ChickenEgg());
                        type=1;
                    }
                }else if(arranimal.getMember(i) instanceof Duck && display.checkLand(idir,jdir,3)){
                    if(arranimal.getMember(i).isProductive()){
                        arranimal.getMember(i).setProductive(false);
                        FPInventory.add(new DuckEgg());
                        type=2;
                    }
                }else if(arranimal.getMember(i) instanceof Cow && display.checkLand(idir,jdir,2)){
                    if(arranimal.getMember(i).isProductive()){
                        arranimal.getMember(i).setProductive(false);
                        FPInventory.add(new CowMilk());
                        type=3;
                    }
                }else if(arranimal.getMember(i) instanceof Goat && display.checkLand(idir,jdir,2)){
                    if(arranimal.getMember(i).isProductive()){
                        arranimal.getMember(i).setProductive(false);
                        FPInventory.add(new GoatMilk());
                        type=4;
                    }
                }
            }
        }
        return type;
    }
        
    /*Take Water procedure*/
    public boolean interactWell(Display display, int idir, int jdir){
        boolean success=false;
        if(idir>=0 && jdir<=10 && idir>=0 && jdir<=10){
            boolean Facility=false;
            Facility=display.checkFacility(idir,jdir,1);
            if(Facility && Water!= MAX_WATER){
                if(Water <= MAX_WATER-30){
                    Water +=30;
                    success=true;
                }else{
                    Water = MAX_WATER;
                    success=true;
                }
            }
        }
        return success;
    }

    /*Sell all products procedure*/
    public boolean InteractTruck(Display display, int idir, int jdir){
        boolean success = false;
        if(idir>=0 && idir<=10 && jdir>=0 && jdir<=10){
            boolean Facility=display.checkFacility(idir,jdir,3);
            boolean check=display.checkUsedTruck(idir,jdir);
            if(Facility && check){
                display.modifyUsedTruck(idir,jdir);
                //jual semua barang
                for(int i=FPInventory.getSize()-1; i>=0;i--){
                    Money += (FPInventory.getBelonging(i)).getPrice();
                    FPInventory.remove(FPInventory.getBelonging(i));
                }
                for(int i=SPInventory.getSize()-1; i>=0;i--){
                    Money +=(SPInventory.getBelonging(i)).getPrice();
                    SPInventory.remove(SPInventory.getBelonging(i));
                }
                success=true;
            }
        }
        return success;
    }

    /*Mix to get SideProduct*/
    public boolean mix(Display display, SideProduct sideproduct, int idir, int jdir){
        boolean succ = false;
        if(idir>=0 && idir<=10 && jdir>=0 && jdir<=10){
            boolean Facility=display.checkFacility(idir,jdir,2);
            if(Facility){
                int ing1 = sideproduct.getIngredient1();
                int ing2 = sideproduct.getIngredient2();
                /*remove ingredient in FPInventory*/
                succ = typeBasedRemove(ing1);
                if(succ){
                    succ = typeBasedRemove(ing2);
                    if(succ){
                        SPInventory.add(sideproduct);
                        succ=true;
                    }else{
                        succ=false;
                        typeBasedAdd(ing1);
                    }
                }
            }
        }
        return succ;
    }
}
