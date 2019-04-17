import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;

public class UI extends JFrame implements ActionListener{
	public static final int MAPSIZE = 11;
	public static final String[] command = {"TALK" , "KILL", "MOVE", "INTERACT", "GROW", "MIX"};

	JPanel main = new JPanel(); /* Panel Utama */
	JPanel gameP = new JPanel(); /* Panel Bagian Map dan Inventory Game */
	JPanel mp = new JPanel(new GridLayout(11,11)); /* Panel untuk Bagian map */
	JPanel inventP = new JPanel(); /* Panel untuk Bagian Inventory */
	JPanel commandP = new JPanel(); /* Panel untuk bagian Command */
	JLabel[][] lbl = new JLabel[MAPSIZE][MAPSIZE]; /* Label untuk map */
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

	public static void main (String[] args){
		UI main = new UI();
	}

	public void setMap(Display d){
		for (int i =0; i < MAPSIZE; i++){
			for (int j = 0; j < MAPSIZE; j++ ){
				if (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 3 && !d.getMap(i,j).getGrassy()){
	                lbl[i][j].setText("o");
	            } else 
				if (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 2 && !d.getMap(i,j).getGrassy()){
	                lbl[i][j].setText("x");
	            } else 
	            if (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 1 && !d.getMap(i,j).getGrassy()){
	                lbl[i][j].setText("-");
	            } else 
	            if  (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 3 && d.getMap(i,j).getGrassy()){
	                lbl[i][j].setText("[=]");
	            } else 
	            if  (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 2 && d.getMap(i,j).getGrassy()){
	                lbl[i][j].setText("[$]");
	            } else 
	            if  (d.getMap(i,j).getLand() && d.getMap(i,j).getType() == 1 && d.getMap(i,j).getGrassy()){
	                lbl[i][j].setText("[#]");
	            }else
	            if (d.getMap(i,j).getFacility() && d.getMap(i,j).getType() == 1){
	                lbl[i][j].setText("[W]");
	            }else
	            if (d.getMap(i,j).getFacility() && d.getMap(i,j).getType() == 2){
	                lbl[i][j].setText("[M]");
	            }else
	            if (d.getMap(i,j).getFacility() && d.getMap(i,j).getType() == 3){
	                lbl[i][j].setText("[T]");
	            }
			}
		}
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
					System.out.print("Keluar dong");
					System.exit(0);
				} else{
					try {
						if (filename.length() >0){
							d = new Display(filename);
							exist = true;
							setMap(d);
						} else {
							JOptionPane.showMessageDialog(title,"Please Input Map txt File");
						filename= (String)JOptionPane.showInputDialog(title,"Input your Map txt file name (include the '.txt') : ","Map Input", JOptionPane.PLAIN_MESSAGE);
						}				
					} catch (NullPointerException ex) {
						JOptionPane.showMessageDialog(title,"Please Input the right Map txt File (Map size has to be 11 x 11)");
						filename= (String)JOptionPane.showInputDialog(title,"Input your Map txt file name (include the '.txt') : ","Map Input", JOptionPane.PLAIN_MESSAGE);
					}	
				}
				

			}
			title.dispose();
			this.setVisible(true);
		} else 
		if (act.equals("Command")){
			//if masih ada animal
	        	String command = (String)commandList.getSelectedItem();
	        	//if command = a {} else etc
	        //if animal gada, this.dispose() over.setVisible(true);
		}
	}

	public UI(){
		super("Engi's Farm");

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
			for (j = 0; j < MAPSIZE; j++){
				//Hardcode dulu, harusnya text bergantung pada Grid
				lbl[j][i] = new JLabel("",JLabel.CENTER);
				lbl[j][i].setText("[o]");
				lbl[j][i].setOpaque(true);
				lbl[j][i].setBackground(Color.GREEN);
				mp.add(lbl[j][i]);
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
