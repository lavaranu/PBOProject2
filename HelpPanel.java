import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class HelpPanel extends JPanel {
    
    Image helpbkg = new ImageIcon("images\\helpNew.png").getImage(); //help image background

	JButton back = new JButton(""); //back button

	ImageIcon backButton = new ImageIcon("buttons\\back.png");

	Audio audio = new Audio();


	
	
	HelpPanel(){
		setFocusable(true); //setting the focus
		setLayout(null);
		
		back.setIcon(backButton);
		this.add(back);
		back.setBounds(100, 500, 170, 50);
	
		back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				Ctb.cl.show(Ctb.cards, "MenuPanel"); // show menuPanel when back button is clicked
				playSE(1);
			}	
		  });
	}//end constructor
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(helpbkg, 0,0, null); // draw help background
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



