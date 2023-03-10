import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

import java.applet.AudioClip;
import java.net.URL;

import javax.sound.sampled.*;
public class MenuPanel extends JPanel {
    JButton play = new JButton("");
	JButton help = new JButton("");
	JButton exit = new JButton("");
	JButton ld = new JButton("");
	
	Image menubkg = new ImageIcon("images\\homePage.png").getImage();  //menu background
	
	/* Setting icons on buttons */
	ImageIcon playbtn = new ImageIcon("buttons\\playnew.png"); 
	ImageIcon helpbtn = new ImageIcon("buttons\\helpnew.png");
	ImageIcon exitbtn = new ImageIcon("buttons\\exitnew.png");
	ImageIcon ldbtn = new ImageIcon("buttons\\leaaderboard.png");

	JPanel center = new JPanel(); //adding another jpanel in a panel for boxLayout

	Audio audio = new Audio();

	
	
	MenuPanel(){

		setFocusable(true);

		setLayout(null);
		play.setIcon(playbtn); 
		this.add(play);
		play.setBounds(400, 200, 170, 50);

		help.setIcon(helpbtn);
		this.add(help);
		help.setBounds(400, 270, 170, 50);

		
		ld.setIcon(ldbtn);
		this.add(ld);
		ld.setBounds(350, 340, 270, 50);

		exit.setIcon(exitbtn);
		this.add(exit);
		exit.setBounds(400, 410, 170, 50);
		
				
		/* adding mouseListeners on buttons */
		play.addMouseListener(new Click());
		help.addMouseListener(new Click());
		exit.addMouseListener(new Click());
		ld.addMouseListener(new Click());

		playMusic(0);
	
		
	}//end constructor
	
	class Click extends MouseAdapter{ //internal friendly class
	
		public void mouseClicked(MouseEvent me){
			if(me.getSource()== play){
				Ctb.cl.show(Ctb.cards, "LevelPanel"); //show gamePanel when play is clicked
				playSE(1);
			}
			if(me.getSource()== help){
				Ctb.cl.show(Ctb.cards, "HelpPanel"); //show helpPanel when help is clicked
				playSE(1);
			}
			if(me.getSource()== ld){
				Ctb.cl.show(Ctb.cards, "Leaderboard"); //show helpPanel when help is clicked
				playSE(1);
			}		
			if(me.getSource()== exit){
				System.exit(0);  //exit application when exit is clicked
				playSE(1);
			}
		}//end mouseClick
	}//end mouseAdapter
	
	public void paintComponent(Graphics g){
		super.paintComponent(g); //calling the super class functions
		Graphics2D g2d = (Graphics2D)g; //casting to graphcis2D
		setFocusable(true);		 //setting the focus on the panel
		
		g2d.drawImage(menubkg, 0,0, null); //draw menu image
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





