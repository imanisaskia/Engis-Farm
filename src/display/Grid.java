package display;

import java.util.*;

public class Grid{
	private boolean land;
	private boolean facility;
	private int type;
	private boolean grassy;
	private int usedTruck;

	/**
	 * Kelas Grid terdiri dari atribut land, facility, type, grassy, dan used Truck
	 * Kelas Grid digunakan untuk mendefinisikan setiap petak pada map
	 * @author Karina iswara (13517031)
	 */
	public boolean getLand(){
		return land;
	}

	public boolean getFacility(){
		return facility;
	}

	public int getType(){
		return type;
	}

	public boolean getGrassy(){
		return grassy;
	}

	public int getUsedTruck(){
		return usedTruck;
	}

	public void setLand(boolean l){
		land = l;
	}

	public void setFacility(boolean f){
		facility = f;
	}

	public void setType(int t){
		type = t;
	}

	public void setGrassy(boolean g){
		grassy = g;
	}

	public void setUsedTruck(int ut){
		usedTruck = ut;
	}

	/* untuk mengecek apakah Truck dapat digunakan */
	public boolean useTruck(){
		if (usedTruck == 0){
			return true;
		} else {
			return false;
		}
	}
}