import display.*;
import player.*;
import animals.*;
import farm_products.*;
import side_products.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;

/**
 * Kelas UI tediri dari atribut untuk menampilkan permainan
 * Kelas Grid digunakan untuk menampilkan permainan
 * @author Karina iswara (13517031)
 */
public class UI extends JFrame implements ActionListener{
	public static final String[] command = { "MOVE", "TALK", "KILL", "INTERACT", "GROW", "MIX"};
	public static final String[] dirs = {"Up", "Right", "Down", "Left"};

	JPanel main = new JPanel(); /* Panel Utama */
	JPanel gameP = new JPanel(); /* Panel Bagian Map dan Inventory Game */
	JPanel mp = new JPanel(new GridLayout(Display.MAPROW,Display.MAPCOL)); /* Panel untuk Bagian map */
	JPanel inventP = new JPanel(); /* Panel untuk Bagian Inventory */
	JPanel commandP = new JPanel(); /* Panel untuk bagian Command */
	JLabel[][] lbl = new JLabel[Display.MAPROW][Display.MAPCOL]; /* Label untuk map */
	JLabel inventL= new JLabel("Inventory : ",JLabel.LEFT); /* Label untuk Inventory */
	JLabel fp = new JLabel("",JLabel.LEFT); /* Label untuk farm product */
	JLabel sp = new JLabel("",JLabel.LEFT); /* Label untuk side product  */
	JLabel moneyL = new JLabel("", JLabel.LEFT); /* Label untuk money */
	JLabel waterL = new JLabel("", JLabel.LEFT); /* Label untuk water */
	JComboBox commandList = new JComboBox (command); /* List untuk pilihan command yang ada */
	JButton doIt = new JButton(" Do It !"); /* Button untuk menjalankan command */
	JLabel response = new JLabel(); /* Label untuk menampilkan respon tulisan dari game jika diperlukan */
	JFrame title = new JFrame(); /* Frame untuk Judul */
	JFrame over = new JFrame(); /* Frame untuk Game Over */
	String filename;
	Display d;
	Player p;
	AnimalArray animals = new AnimalArray();

	/*Semua Icon yang dibutuhkan*/
	Icon iconGrassland = new ImageIcon("display/img/grassland.png");
	Icon iconGrass = new ImageIcon("display/img/grass.png");
	Icon iconCoop = new ImageIcon("display/img/coop.png");
	Icon iconBarn = new ImageIcon("display/img/barn.jpg");
	Icon iconPlayer = new ImageIcon("display/img/player.png");
	Icon iconWell = new ImageIcon("display/img/well.png");
	Icon iconTruck = new ImageIcon("display/img/truck.png");
	Icon iconMixer = new ImageIcon("display/img/mixer.png");
	Icon iconChicken = new ImageIcon("display/img/chicken.png");
	Icon iconHungryChicken = new ImageIcon("display/img/hungryChicken.png");
	Icon iconCow = new ImageIcon("display/img/cow.png");
	Icon iconHungryCow = new ImageIcon("display/img/hungryCow.png");
	Icon iconDuck = new ImageIcon("display/img/duck.png");
	Icon iconHungryDuck = new ImageIcon("display/img/hungryDuck.png");
	Icon iconGoat = new ImageIcon("display/img/goat.png");
	Icon iconHungryGoat = new ImageIcon("display/img/hungryGoat.png");
	Icon iconPig = new ImageIcon("display/img/pig.png");
	Icon iconHungryPig = new ImageIcon("display/img/hungryPig.png");
	Icon iconRabbit = new ImageIcon("display/img/rabbit.png");
	Icon iconHungryRabbit = new ImageIcon("display/img/hungryRabbit.png");

	/*Icon dari 2 Icon lainnya */
	ImageIcon coopGrass = mergedIcon(iconCoop, iconGrass);
	ImageIcon barnGrass = mergedIcon(iconBarn, iconGrass);
	ImageIcon truck = mergedIcon(iconGrassland, iconTruck);
	ImageIcon well = mergedIcon(iconGrassland, iconWell);
	ImageIcon mixer = mergedIcon(iconGrassland, iconMixer);
	ImageIcon grass = mergedIcon(iconGrassland, iconGrass);	

	/* Gambar yang diperlukan */
	ImageIcon grassland = new ImageIcon("display/img/grassland.png");
	ImageIcon coop = new ImageIcon("display/img/coop.png");
	ImageIcon barn = new ImageIcon("display/img/barn.jpg");

	/* Main */
	public static void main(String[] args){
		UI main = new UI();
	}

	/* Fungsi untuk menggabungkan 2 icon */
	public ImageIcon mergedIcon(Icon bg, Icon fg){
		Image imgBG = ((ImageIcon)bg).getImage();
		Image imgFG = ((ImageIcon)fg).getImage();

		BufferedImage temp =  new BufferedImage(imgBG.getWidth(null), imgBG.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) temp.getGraphics();
		g.drawImage(imgBG, 0, 0, null);
		g.drawImage(imgFG, 0, 0, null);
		return (new ImageIcon(temp));	
	}

	/* Prosedur untuk menampilkan Map*/
	public void setMap(){
		for (int i =0; i < Display.MAPROW; i++){
			for (int j = 0; j < Display.MAPCOL; j++ ){
				if (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 3 && !d.getMap(i,j).getGrassy()){
	                lbl[i][j].setIcon(coop);
	            } else 
				if (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 2 && !d.getMap(i,j).getGrassy()){
					lbl[i][j].setIcon(barn);
	            } else 
	            if (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 1 && !d.getMap(i,j).getGrassy()){
	                lbl[i][j].setIcon(grassland);
	            } else 
	            if  (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 3 && d.getMap(i,j).getGrassy()){
	                lbl[i][j].setIcon(coopGrass);
	            } else 
	            if  (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 2 && d.getMap(i,j).getGrassy()){
	                lbl[i][j].setIcon(barnGrass);
	            } else 
	            if  (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 1 && d.getMap(i,j).getGrassy()){
	                lbl[i][j].setIcon(grass);
	            }else
	            if (d.getMap(i,j).getFacility() && d.getMap(i,j).getType() == 1){
	                lbl[i][j].setIcon(well);
	            }else
	            if (d.getMap(i,j).getFacility() && d.getMap(i,j).getType() == 2){
	                lbl[i][j].setIcon(mixer);
	            }else
	            if (d.getMap(i,j).getFacility() && d.getMap(i,j).getType() == 3){
					lbl[i][j].setIcon(truck);
				}
				if (i == p.getI() && j == p.getJ()){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconPlayer));
				}
			}
		}
		/* Menampilkan semua binatang yang ada */
		for (int k = 0; k < animals.getLength(); k++ ) {
			if (animals.getMember(k) instanceof Chicken){
				int i = animals.getMember(k).getI();
				int j = animals.getMember(k).getJ();
				if (animals.getMember(k).getHunger() > 5){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconHungryChicken));	
				} else {
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconChicken));
				}
			} else
			if (animals.getMember(k) instanceof Cow){
				int i = animals.getMember(k).getI();
				int j = animals.getMember(k).getJ();
				if (animals.getMember(k).getHunger() > 5){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconHungryCow));	
				} else {
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconCow));
				}
			} else
			if (animals.getMember(k) instanceof Duck){
				int i = animals.getMember(k).getI();
				int j = animals.getMember(k).getJ();
				if (animals.getMember(k).getHunger() > 5){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconHungryDuck));	
				} else {
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconDuck));
				}
			} else
			if (animals.getMember(k) instanceof Goat){
				int i = animals.getMember(k).getI();
				int j = animals.getMember(k).getJ();
				if (animals.getMember(k).getHunger() > 5){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconHungryGoat));
				} else {
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconGoat));
				}
			} else
			if (animals.getMember(k) instanceof Pig){
				int i = animals.getMember(k).getI();
				int j = animals.getMember(k).getJ();
				if (animals.getMember(k).getHunger() > 5){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconHungryPig));
				} else {
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconPig));
				}
			} else
			if (animals.getMember(k) instanceof Rabbit){
				int i = animals.getMember(k).getI();
				int j = animals.getMember(k).getJ();
				if (animals.getMember(k).getHunger() > 5){
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconHungryRabbit));
				} else {
					lbl[i][j].setIcon(mergedIcon(lbl[i][j].getIcon(), iconRabbit));
				}
			}
        }
	}

	/* Prosedur untuk menampilkan inventory */
	public void setInvent(){
		waterL.setText(String.valueOf(p.getWater()));
		moneyL.setText(String.valueOf(p.getMoney()));

		String FP = "<html>";
		for (int i = 0; i < p.getBagFP().getSize(); i++){
			if(p.getBagFP().getBelonging(i).getType()==1){
				FP = FP + "Chicken Egg";
			} else
			if(p.getBagFP().getBelonging(i).getType()==2){
				FP = FP + "Duck Egg";
			} else
			if(p.getBagFP().getBelonging(i).getType()==3){
				FP = FP + "Cow Milk";
			}  else
			if(p.getBagFP().getBelonging(i).getType()==4){
				FP = FP + "Goat Milk";
			}  else
			if(p.getBagFP().getBelonging(i).getType()==5){
				FP = FP + "Pig Meat";
			} else
			if(p.getBagFP().getBelonging(i).getType()==6){
				FP = FP + "Rabbit Meat";
			}
			if (i != p.getBagFP().getSize()){
				FP = FP + "<br>";
			}
		}
		FP = FP + " </html>";
		fp.setText(FP);
		String SP = "<html>";
		for (int i = 0; i < p.getBagSP().getSize(); i++){
			if(p.getBagSP().getBelonging(i) instanceof RabbitStew){
				SP = SP + "Rabit Stew";
			} else
			if(p.getBagSP().getBelonging(i) instanceof PorkStew){
				SP = SP + "Pork Stew";
			} else
			if(p.getBagSP().getBelonging(i) instanceof Omlette){
				SP = SP + "Omlette";
			} else
			if(p.getBagSP().getBelonging(i) instanceof Skewer){
				SP = SP + "Skewer";
			}
			if (i != p.getBagSP().getSize()){
				SP = SP + "<br>";
			}
		}
		SP = SP + "</html>";
		sp.setText(SP);
	}

	/* Untuk aksi yang dilakukan ketika button ditekan */
	public void actionPerformed(ActionEvent e) {
		String act = e.getActionCommand();
		if (act.equals("Start")){
			UIManager.put("OptionPane.cancelButtonText", "Exit");
			Object[] options = {"OK", "Exit"};
			d = new Display("display/Map.txt");
			p = new Player();
			setMap();
			setInvent();
			title.dispose();
			this.setVisible(true);	
		} else 
		if (act.equals("Command")){
			animals.tick(d,p.getI(),p.getJ());
			d.lessenTruck();
			response.setText("");
			if (animals.getLength()>0){
				String command = (String)commandList.getSelectedItem();
				if (command == "MOVE"){
					String dir = (String)JOptionPane.showInputDialog(this,"Which direction do you wanna move ?", "Move Directions",JOptionPane.PLAIN_MESSAGE,	null, dirs,"Up");
					if (dir != null){
						char direct = 'x';
						if (dir == "Up"){
							direct = 'u';
						} else
						if (dir == "Right"){
							direct = 'r';
						} else
						if (dir == "Down"){
							direct = 'd';
						} else
						if (dir == "Left"){
							direct = 'l';
						}
						p.walk(direct,d, animals);
					}	
				} else 
				if (command == "TALK"){
					String dir = (String)JOptionPane.showInputDialog(this,"Which direction do you wanna talk ?", "Move Directions",JOptionPane.PLAIN_MESSAGE,	null, dirs,"Up");
					if (dir != null){
						int i = p.getI();
						int j = p.getJ();
						if (dir == "Up"){
							i -= 1;
						} else
						if (dir == "Right"){
							j +=1;
						} else
						if (dir == "Down"){
							i +=1;
						} else
						if (dir == "Left"){
							j -=1;
						}
						response.setText(p.talk(i,j,animals));
					}
				}else
				if (command == "KILL"){
					String dir = (String)JOptionPane.showInputDialog(this,"Which direction do you wanna kill ?", "Move Directions",JOptionPane.PLAIN_MESSAGE,	null, dirs,"Up");
					if (dir != null){
						int i = p.getI();
						int j = p.getJ();
						if (dir == "Up"){
							i -= 1;
						} else
						if (dir == "Right"){
							j +=1;
						} else
						if (dir == "Down"){
							i +=1;
						} else
						if (dir == "Left"){
							j -=1;
						}
						p.kill(i,j,animals);
					}
				} else 
				if (command == "INTERACT"){
					String dir = (String)JOptionPane.showInputDialog(this,"Which direction do you wanna interact ?", "Move Directions",JOptionPane.PLAIN_MESSAGE,	null, dirs,"Up");
					if (dir != null){
						int i = p.getI();
						int j = p.getJ();
						if (dir == "Up"){
							i -= 1;
						} else
						if (dir == "Right"){
							j +=1;
						} else
						if (dir == "Down"){
							i +=1;
						} else
						if (dir == "Left"){
							j -=1;
						}
						int type = p.interactAnimal(animals, d, i, j);
						if (type == -999){
							boolean success = p.interactWell(d,i,j);
							if (!success){
								success = p.interactTruck(d,i,j);
								if (success){
									d.getMap(d.getITruck(),d.getJTruck()).setUsedTruck(5);
									response.setText("You sold all of your product(s) ! Here your money !");
								} else {
									response.setText("OH NO ! Interact failed !");
								}
							} else {
								response.setText("You got some water my friend ! Keep being hydrated (@grass)!");
							}
						} else {
							if (type ==1 ){
								response.setText("You got 1 chicken egg ! Well done !");
							} else 
							if (type == 2){
								response.setText("You got 1 duck egg ! Well done !");
							} else 
							if (type == 3){
								response.setText("You got 1 unit of cow milk ! Well done !");
							} else 
							if (type == 4){
								response.setText("You got 1 unit of goat milk ! Well done !");
							}
						}
					}
				} else
				if (command == "GROW"){
					if (p.grow(d)){
						d.getMap(p.getI(), p.getJ()).setGrassy(true);
					}
				} else
				if (command == "MIX"){
					Object[] options = {"Rabbit Stew", "Pork Stew", "Omlette","Skewer"};
					Object[] dirs = {"Up", "Right", "Down", "Left"};
					String obj = (String)JOptionPane.showInputDialog(this,"What do you wanna mix ?", "Mix Options",JOptionPane.PLAIN_MESSAGE,	null, options,"Rabbit Stew");
					String dir = (String)JOptionPane.showInputDialog(this,"Which direction do you wanna mix ?", "Mix Directions",JOptionPane.PLAIN_MESSAGE,	null, dirs,"Up");
					if (obj != null){
						boolean success = false;
						int i = p.getI();
						int j = p.getJ();
						if (dir == "Up"){
							i -= 1;
						} else
						if (dir == "Right"){
							j += 1;
						} else
						if (dir == "Down"){
							i += 1;
						} else
						if (dir == "Left"){
							j -= 1;
						}
						if (obj == "Rabbit Stew"){
							success = p.mix(d, new RabbitStew(),i,j);
						} else
						if (obj == "Pork Stew"){
							success = p.mix(d, new PorkStew(),i,j);
						} else
						if (obj == "Omlette"){
							success = p.mix(d, new Omlette(),i,j);
						} else
						if (obj == "Skewer"){
							success = p.mix(d, new Skewer(),i,j);
						}
						if (success){
							response.setText("You made "+ obj);
						} else {
							response.setText("OH NO ! Something went wrong.");
						}
					}
				} else {
					response.setText("Belum ready gan !");
				}

				setMap();
				setInvent();
			} else {
				this.dispose();
				over.setVisible(true);
			}
		}
	}

	/* Konstruktor */
	public UI(){
		super("Engi's Farm - Ciwi Bandung");

		int i,j;

		setSize(800,600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/*Set Frame untuk Judul*/
		JPanel titleP = new JPanel();
		JLabel titleL = new JLabel("",JLabel.CENTER);
		titleL.setIcon(new ImageIcon("display/img/engi.png"));
		titleL.setPreferredSize(new Dimension (750,500));
		titleP.add(titleL);
		JButton start = new JButton("Start");
		start.setActionCommand("Start");
		start.addActionListener(this);
		start.setPreferredSize(new Dimension (150,30));
		titleP.add(start);
		title.setSize(800,600);
		title.setResizable(true);
		title.setDefaultCloseOperation(EXIT_ON_CLOSE);
		title.add(titleP);
		title.setVisible(true);

		/*Set Frame untuk tampilan Game Over*/
		JLabel overL = new JLabel("",JLabel.CENTER);
		overL.setIcon(new ImageIcon("display/img/over.png"));
		overL.setPreferredSize(new Dimension (750,500));
		over.setSize(800,600);
		over.setResizable(true);
		over.setDefaultCloseOperation(EXIT_ON_CLOSE);
		over.add(overL);

		/*Main Frame*/
		/* Set Mabaner Layout */
		main.setLayout(new BorderLayout());
		gameP.setLayout(new BorderLayout());

		/* Label untuk setiap Map */
		for (i = 0; i < Display.MAPROW; i ++){
			for (j = 0; j < Display.MAPCOL; j++){
				//Hardcode dulu, harusnya text bergantung pada Grid
				lbl[i][j] = new JLabel("",JLabel.CENTER);
				lbl[i][j].setOpaque(true);
//				lbl[i][j].setBackground(Color.GREEN);
				mp.add(lbl[i][j]);
			}
		}

		mp.setPreferredSize(new Dimension (600,450));
		gameP.add(mp,BorderLayout.WEST);
		gameP.setPreferredSize(new Dimension (600,450));

		inventL.setPreferredSize(new Dimension(170,15));

		/*Pengisian Farm Product*/
		fp.setVerticalAlignment(JLabel.TOP);
		fp.setBorder(BorderFactory.createTitledBorder("Farm Product"));
		//isi farm product di hardcode dulu
		//String fpText = "<html> Chicken Egg <br> Cow Milk <br> Duck Egg <br> Goat Milk <br> Rabbit Milk <br> Pig Meat <br> Cow Meat <br> </html>";
		//fp.setText(fpText);
		fp.setPreferredSize(new Dimension(180,145));

		/*Pengisian Side Product*/
		sp.setVerticalAlignment(JLabel.TOP);
		sp.setBorder(BorderFactory.createTitledBorder("Side Product"));
		//isi side product di hardcode dulu
		//String spText = ("<html> Beef Stew <br> Chicken and Egg Skewer <br> Pork Stew <br> Omlette <br> Chicken and Egg Skewer <br> Omlette <br> </html>");
		//sp.setText(spText);	
		sp.setPreferredSize(new Dimension(180,145));
		
		/*Pengisian Money*/
		moneyL.setPreferredSize(new Dimension(180,40));
		moneyL.setBorder(BorderFactory.createTitledBorder("Money"));
		// Money di hardcode dulu
		int mon = 1000;
		String money = (" " + mon);
		moneyL.setText(money);

		/*Pengisian Water*/
		waterL.setPreferredSize(new Dimension (180,40));
		waterL.setBorder(BorderFactory.createTitledBorder("Water"));
		// Water di hardcode dulu
		int wotah = 50;
		String water = (" " + wotah);
		waterL.setText(water);

		/*Pengisian Panel Inventory*/
		inventP.setPreferredSize(new Dimension(190,450));
		inventP.add(inventL);
		inventP.add(fp);
		inventP.add(sp);
		inventP.add(moneyL);
		inventP.add(waterL);
		gameP.add(inventP, BorderLayout.EAST);

		main.add(gameP,BorderLayout.NORTH);

		/*Pengisian Panel Command*/
		JLabel commandL = new JLabel("Command : ", JLabel.LEFT);
		commandL.setPreferredSize(new Dimension (120,15));

		commandList.setPreferredSize(new Dimension (450,20));

		doIt.setPreferredSize(new Dimension(100,20));
		doIt.setActionCommand("Command");
		doIt.addActionListener(this);

		JLabel temp2 = new JLabel("");
		temp2.setPreferredSize(new Dimension(50,30));

		commandP.setPreferredSize(new Dimension(750,20));
		commandP.add(commandL);
		commandP.add(commandList);
		commandP.add(temp2);
		commandP.add(doIt);

		response.setBorder(BorderFactory.createTitledBorder("Response : "));
		response.setPreferredSize(new Dimension(750,70));
		commandP.add(response, BorderLayout.SOUTH);

		main.add(commandP);
		add(main);
	}
}
