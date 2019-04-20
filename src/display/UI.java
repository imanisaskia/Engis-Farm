package display;

import display.Grid;
import display.Display;
import player.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.image.BufferedImage;

public class UI extends JFrame implements ActionListener{
	public static final int MAPSIZE = 11;
	public static final String[] command = { "MOVE UP", "MOVE RIGHT", "MOVE DOWN", "MOVE LEFT", "TALK UP", "TALK RIGHT", "TALK DOWN", "TALK LEFT", "KILL UP", "KILL RIGHT", "KILL DOWN", "KILL LEFT", "INTERACT UP", "INTERACT RIGHT", "INTERACT DOWN", "INTERACT LEFT", "GROW", "MIX"};

	JPanel main = new JPanel(); /* Panel Utama */
	JPanel gameP = new JPanel(); /* Panel Bagian Map dan Inventory Game */
	JPanel mp = new JPanel(new GridLayout(11,16)); /* Panel untuk Bagian map */
	JPanel inventP = new JPanel(); /* Panel untuk Bagian Inventory */
	JPanel commandP = new JPanel(); /* Panel untuk bagian Command */
	JLabel[][] lbl = new JLabel[MAPSIZE][MAPSIZE+6]; /* Label untuk map */
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
		for (int i =0; i < MAPSIZE; i++){
			for (int j = 0; j < MAPSIZE; j++ ){
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
				//set buat binatang
			}
		}
	}

	/* Prosedur untuk menampilkan inventory */
	public void setInvent(){
		waterL.setText(String.valueOf(p.getWater()));
		moneyL.setText(String.valueOf(p.getMoney()));

		//set buat inventory
	}

	public void actionPerformed(ActionEvent e) {
		String act = e.getActionCommand();
		if (act.equals("Start")){
			UIManager.put("OptionPane.cancelButtonText", "Exit");
			Object[] options = {"OK", "Exit"};
			filename= (String)JOptionPane.showInputDialog(title,"Input your Map txt file name (include the '.txt') : ","Map Input", JOptionPane.PLAIN_MESSAGE);
			boolean exist = false;
			while (!exist){
				if (filename == null){
					System.exit(0);
				} else{
					try {
						if (filename.length() >0){
							d = new Display(filename);
							p = new Player();
							exist = true;
							setMap();
							setInvent();
						} else {
							JOptionPane.showMessageDialog(title,"Please Input Map txt File");
						filename= (String)JOptionPane.showInputDialog(title,"Input your Map txt file name (include the '.txt') : ","Map Input", JOptionPane.PLAIN_MESSAGE);
						}				
					} catch (NullPointerException ex) {
						JOptionPane.showMessageDialog(title,"Please Input the right Map txt File (Map size has to be 11 x 11)");
						filename= (String)JOptionPane.showInputDialog(title,"Input your Map txt file name (include the '.txt') : ","Map Input", JOptionPane.PLAIN_MESSAGE);
					}
					title.dispose();
					this.setVisible(true);	
				}
			}
		} else 
		if (act.equals("Command")){
			//if masih ada animal
				String command = (String)commandList.getSelectedItem();
				if (command == "MOVE UP"){
					p.setI(p.getI()-1);
				} else 
				if (command == "MOVE RIGHT"){
					p.setJ(p.getJ()+1);
				} else 
				if (command == "MOVE DOWN"){
					p.setI(p.getI()+1);
				} else 
				if (command == "MOVE LEFT"){
					p.setJ(p.getJ()-1);
				} else {
					response.setText("Belum ready gan !");
				}

				//tik 
				setMap();
				// set invent

	        	//if command = a {} else etc
	        //if animal gada, this.dispose() over.setVisible(true);
		}
	}

	public UI(){
		super("Engi's Farm - Ciwi Bandung");

		int i,j;

		setSize(800,600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/*Set Frame untuk Judul*/
		JPanel titleP = new JPanel();
		JLabel titleL = new JLabel("",JLabel.CENTER);
		String t = ("<html><span style='font-size:20px'>.....(`-')  _<-. (`-')_             _          (`-').-> <br>.....( OO).-/   \\( OO) )    .->    (_)    ,--. ( OO)_ <br>....(,------.,--./ ,--/  ,---(`-') ,-(`-')\\  |(_)--\\_) <br>.....|  .-----'|   \\ |  | '  .-(OO ) | ( OO) `-'/    _ / <br>....(|  '--. |  . '|  |)|  | .-, \\ |  |  )    \\_..`--. <br>.....|  .--' |  |\\    | |  | '.(_/(|  |_/     .-._)   \\ <br>.....|  `---.|  | \\   | |  '-'  |  |  |'->    \\       / <br>.....------'`--'  `--'  `-----'   `--'        `-----'</span></html>");
		//String t = ("<html><span style='font-size:20px'>,------.               ,--.,--.       <br>|  .---',--,--,  ,---. `--'|  |,---.  <br></span></html>");
		titleL.setText(t);
		titleL.setPreferredSize(new Dimension (750,500));
		titleP.add(titleL);
//		filenameL.setText("Input your Map txt file name (include the '.txt') : ");
		// titleP.add(filename);
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
		String o = ("");
		overL.setText(o);
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
		for (i = 0; i < MAPSIZE; i ++){
			for (j = 0; j < MAPSIZE+6; j++){
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
		String fpText = "<html> Chicken Egg <br> Cow Milk <br> Duck Egg <br> Goat Milk <br> Rabbit Milk <br> Pig Meat <br> Cow Meat <br> </html>";
		fp.setText(fpText);
		fp.setPreferredSize(new Dimension(180,145));

		/*Pengisian Side Product*/
		sp.setVerticalAlignment(JLabel.TOP);
		sp.setBorder(BorderFactory.createTitledBorder("Side Product"));
		//isi side product di hardcode dulu
		String spText = ("<html> Beef Stew <br> Chicken and Egg Skewer <br> Pork Stew <br> Omlette <br> Chicken and Egg Skewer <br> Omlette <br> </html>");
		sp.setText(spText);	
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
