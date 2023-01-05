import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class LevelPanel extends JPanel  {
    
    JButton easy = new JButton("");
	JButton medium = new JButton("");
	JButton hard = new JButton("");
	JButton back = new JButton("");

	Image levelBackground = new ImageIcon("images\\selectLevel.png").getImage();

	ImageIcon easybutton = new ImageIcon("buttons\\easynew.png"); 
	ImageIcon mediumbutton = new ImageIcon("buttons\\mediumnew.png");
	ImageIcon hardbutton = new ImageIcon("buttons\\hardnew.png");
	ImageIcon backbtn = new ImageIcon("buttons\\back.png");

	Audio audio = new Audio();

	JPanel center = new JPanel();


	LevelPanel(){
		
		// center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); //setting box layout 
		// add(center); //adding the panel to anothe JPanel

		setLayout(null);
		easy.setIcon(easybutton); 
		this.add(easy);
		easy.setBounds(400, 100, 200, 50);

		medium.setIcon(mediumbutton);
		this.add(medium);
		medium.setBounds(400, 170, 200, 50);
		
		hard.setIcon(hardbutton);
		this.add(hard);
		hard.setBounds(400, 240, 200, 50);

		back.setIcon(backbtn);
		this.add(back);
		back.setBounds(100, 500, 170, 50);
		
				
		/* adding mouseListeners on buttons */
		easy.addMouseListener(new LevelClick());
		medium.addMouseListener(new LevelClick());
		hard.addMouseListener(new LevelClick());
		back.addMouseListener(new LevelClick());
		
	}//end constructor

	class LevelClick extends MouseAdapter{

		public void mouseClicked(MouseEvent me){
			if(me.getSource()== easy){
				GamePanel gp = new GamePanel();
				Ctb.cards.add(gp, "GamePanel");
				Ctb.cl.show(Ctb.cards, "GamePanel"); //show gamePanel when play is clicked
				playSE(1);
			}
			if(me.getSource()== medium){
				GamePanel2 gp2 = new GamePanel2();
				Ctb.cards.add(gp2, "GamePanel2");
				Ctb.cl.show(Ctb.cards, "GamePanel2"); 
				playSE(1);
			}	
			if(me.getSource()== hard){
				GamePanel3 gp3 = new GamePanel3();
				Ctb.cards.add(gp3, "GamePanel3");
				Ctb.cl.show(Ctb.cards, "GamePanel3");
				playSE(1);
			}
			if(me.getSource() == back){
				Ctb.cl.show(Ctb.cards, "MenuPanel");
				playSE(1);
			}
		}//end mouseClick
		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g); //calling the super class functions
		Graphics2D g2d = (Graphics2D)g; //casting to graphcis2D
		setFocusable(true);		 //setting the focus on the panel
		
		g2d.drawImage(levelBackground, 0,0, null); //draw level image
		repaint();
	}//end paintComponent

	public void playMusic(int i){
		audio.setFile(i);
		audio.play();
		audio.loop();
	}

	public void stopMusic(){
		audio.stop();
	}

	public void playSE(int i){
		audio.setFile(i);
		audio.play();
	}

}



