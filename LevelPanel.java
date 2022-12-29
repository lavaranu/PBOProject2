import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class LevelPanel extends JPanel  {
    
    JButton easy = new JButton("");
	JButton medium = new JButton("");
	JButton hard = new JButton("");

	Image levelBackground = new ImageIcon("images\\menuBackground2.png").getImage();

	ImageIcon easybutton = new ImageIcon("buttons\\easy.png"); 
	ImageIcon mediumbutton = new ImageIcon("buttons\\medium.png");
	ImageIcon hardbutton = new ImageIcon("buttons\\hard.png");

	JPanel center = new JPanel();


	LevelPanel(){
		
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); //setting box layout 
		add(center); //adding the panel to anothe JPanel
		
		
		/* setting icons on buttons */
		easy.setIcon(easybutton); 
		medium.setIcon(mediumbutton);
		hard.setIcon(hardbutton);
		
		/* adding the buttons in the panel */
		center.add(easy);
		center.add(medium);
		center.add(hard);
				
		/* adding mouseListeners on buttons */
		easy.addMouseListener(new LevelClick());
		medium.addMouseListener(new LevelClick());
		hard.addMouseListener(new LevelClick());
		
	}//end constructor

	class LevelClick extends MouseAdapter{

		public void mouseClicked(MouseEvent me){
			if(me.getSource()== easy){
				Ctb.cl.show(Ctb.cards, "GamePanel"); //show gamePanel when play is clicked
			}
			if(me.getSource()== medium){
				Ctb.cl.show(Ctb.cards, "GamePanel2"); 
			}	
			if(me.getSource()== hard){
				Ctb.cl.show(Ctb.cards, "GamePanel3");
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

}



