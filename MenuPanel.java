import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MenuPanel extends JPanel {
    JButton play = new JButton("");
	JButton help = new JButton("");
	JButton exit = new JButton("");
	
	Image menubkg = new ImageIcon("images\\menuBackground2.png").getImage();  //menu background
	
	/* Setting icons on buttons */
	ImageIcon playbtn = new ImageIcon("buttons\\play1.png"); 
	ImageIcon helpbtn = new ImageIcon("buttons\\help1.png");
	ImageIcon exitbtn = new ImageIcon("buttons\\exit1.png");

	JPanel center = new JPanel(); //adding another jpanel in a panel for boxLayout

	
	
	MenuPanel(){
		
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); //setting box layout 
		add(center); //adding the panel to anothe JPanel

		
		
		/* setting icons on buttons */
		play.setIcon(playbtn); 
		help.setIcon(helpbtn);
		exit.setIcon(exitbtn);
		
		/* adding the buttons in the panel */
		center.add(play);
		center.add(help);
		center.add(exit);
				
		/* adding mouseListeners on buttons */
		play.addMouseListener(new Click());
		help.addMouseListener(new Click());
		exit.addMouseListener(new Click());
		
	}//end constructor
	
	class Click extends MouseAdapter{ //internal friendly class
	
		public void mouseClicked(MouseEvent me){
			if(me.getSource()== play){
				Ctb.cl.show(Ctb.cards, "LevelPanel"); //show gamePanel when play is clicked
			}
			if(me.getSource()== help){
				Ctb.cl.show(Ctb.cards, "HelpPanel"); //show helpPanel when help is clicked
			}	
			if(me.getSource()== exit){
				System.exit(0);  //exit application when exit is clicked
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
}




