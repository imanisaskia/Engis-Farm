package display;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Display {
	public static final int MAPROW = 11;
	public static final int MAPCOL = 16;

	private Grid[][] map;
	private int iTruck;
	private int jTruck;
	private String command;
	
	public Display(String filename){
		File file = new File(filename); 
		try	{
			Scanner sc = new Scanner(file);
			String line[] = new String[MAPCOL];
			int i = 0;
			int j = 0;
			command = "";
			while (sc.hasNextLine()) {
				line[i] = sc.nextLine();
				i ++;
			}
			map = new Grid[MAPROW][MAPCOL];
			for (i = 0; i < MAPROW; i++){
				for (j =0; j < MAPCOL; j++){
					map[i][j] = new Grid();
				}
			}
			for (i = 0; i < MAPROW; i++){
				for (j = 0; j < MAPCOL; j ++){
					if (line[i].charAt(j) == 'o'){
						map[i][j].setLand(true);
						map[i][j].setFacility(false);
						map[i][j].setType(3);
						map[i][j].setGrassy(false);
						map[i][j].setUsedTruck(-999);
					} else 
					if (line[i].charAt(j) == '='){
						map[i][j].setLand(true);
						map[i][j].setFacility(false);
						map[i][j].setType(3);
						map[i][j].setGrassy(true);
						map[i][j].setUsedTruck(-999);
					} else 
					if (line[i].charAt(j) == 'x'){
						map[i][j].setLand(true);
						map[i][j].setFacility(false);
						map[i][j].setType(2);
						map[i][j].setGrassy(false);
						map[i][j].setUsedTruck(-999);
					} else 
					if (line[i].charAt(j) == '$'){
						map[i][j].setLand(true);
						map[i][j].setFacility(false);
						map[i][j].setType(2);
						map[i][j].setGrassy(true);
						map[i][j].setUsedTruck(-999);
					} else 
					if (line[i].charAt(j) == '-'){
						map[i][j].setLand(true);
						map[i][j].setFacility(false);
						map[i][j].setType(1);
						map[i][j].setGrassy(false);
						map[i][j].setUsedTruck(-999);
					} else 
					if (line[i].charAt(j) == '#'){
						map[i][j].setLand(true);
						map[i][j].setFacility(false);
						map[i][j].setType(1);
						map[i][j].setGrassy(true);
						map[i][j].setUsedTruck(-999);
					}else
					if (line[i].charAt(j) == 'W'){
						map[i][j].setLand(false);
						map[i][j].setFacility(true);
						map[i][j].setType(1);
						map[i][j].setGrassy(false);
						map[i][j].setUsedTruck(-999);
					}else
					if (line[i].charAt(j) == 'M'){
						map[i][j].setLand(false);
						map[i][j].setFacility(true);
						map[i][j].setType(2);
						map[i][j].setGrassy(false);
						map[i][j].setUsedTruck(-999);
					} else
					if (line[i].charAt(j) == 'T'){
						map[i][j].setLand(false);
						map[i][j].setFacility(true);
						map[i][j].setType(3);
						map[i][j].setGrassy(false);
						map[i][j].setUsedTruck(0);
						iTruck = i;
						jTruck = j;
					} else {
						System.out.println("map format is wrong.");
						break;
					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}		
	}

	public Grid getMap(int i, int j){
		return map[i][j];
	}

	public boolean checkLand(int i, int j, int type){
		if (map[i][j].getLand() && map[i][j].getType() == type){
			return true;
		} else {
			return false;
		}
	}

	public boolean checkFacility(int i, int j, int type){
		if (map[i][j].getFacility() && map[i][j].getType() == type){
			return true;
		} else {
			return false;
		}
	}

	public boolean checkGrassy(int i, int j){
		return map[i][j].getGrassy();
	}

	public boolean checkUsedTruck(int i, int j){
		return (map[i][j].getUsedTruck() == 0);
	}

	public void modifyGrassy(int i, int j){
		map[i][j].setGrassy(!map[i][j].getGrassy());
	}

	public void modifyUsedTruck(int i, int j){
		map[i][j].useTruck();
	}

	public void lessenTruck(){
		if (map[iTruck][jTruck].getUsedTruck() > 0){
			map[iTruck][jTruck].setUsedTruck(map[iTruck][jTruck].getUsedTruck() - 1);
		}
	}

	public void setCommand(String c){
		command = c;
	}

	public String getCommand(){
		Scanner c = new Scanner(System.in); 
		String command = c.nextLine();
		return command;
	}

	// public static void main (String[] args){
	// 	Display d = new Display("Map.txt");
	// 	for (int i = 0; i < MAPROW; i++){
	// 		for (int j = 0; j < MAPCOL; j++){
	// 			System.out.print(d.map[i][j].getType());
	// 		}
	// 		System.out.println();
	// 	}
	// 	String x = d.getCommand();
	// 	System.out.println(x);
	// }
}