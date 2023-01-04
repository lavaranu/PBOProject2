import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class GamePanel extends JPanel {
    
    Image gamebkg = new ImageIcon("images\\gamePlay.png").getImage();
	Image basket  = new ImageIcon("images\\basket1.png").getImage();
	Image coin     = new ImageIcon("images\\coin.png").getImage();
	Image gameOverbkg= new ImageIcon("images\\gameOverBG.png").getImage();
	Image tempbkg; //temporary background
	
	int x_basket,y_basket; //basket x and y  coordinates
	int x_coin, y_coin; // x and y coord of coin
	Random rand = new Random(); // for randomizing xcoord of coins
	
	JLabel time;
	JLabel points;
	JLabel health;

    
	
	
	int pointsCount = 0;
	int timeleft = 40;
	int healthPlayer = 3;
	int counter  = 0;
	
	boolean gameOver = false;

	float basketSpeed = 2f;

	
	GamePanel(){
		
		setLayout(null);
		setFocusable(true);
		tempbkg = gamebkg;
		
		x_basket = 350; y_basket = 515;
		x_coin = (int)rand.nextInt(1000);
		y_coin = 0;

		health = new JLabel("Health: " +healthPlayer);
		health.setBounds(200, 10, 100, 20);
		
	    time = new JLabel("Time: " +timeleft);
		time.setBounds(20, 10, 50, 20); //setting the time label on screen
	    
	    
	    points = new JLabel("Points: 0");
		points.setBounds(100,10,100,20);
		
		/*adding both components in jpanel*/
		add(time);
		add(points);
		add(health);
		
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				
				if(ke.getKeyCode() == ke.VK_LEFT & x_basket>10){
					x_basket-=10*basketSpeed;
					repaint(); // redraw at new position
				}
				if(ke.getKeyCode() == ke.VK_RIGHT & x_basket<1000){
					x_basket+=10*basketSpeed; // redraw at new position
					repaint();
				}
			}//end keypressed
		});	

       

		
	}//end constructor

	
	void fallCoin(){
		if(y_coin >=650){
			y_coin = 0;
			x_coin = rand.nextInt(1000);
			healthPlayer --;
		}
		else{
			y_coin ++;
		}
		health.setText("Health :" +healthPlayer);
	}
	
	void updateTime(){
		counter++;
		if(counter == 100) //we count to 60 and then dec timeleft by 1 for slowing speed
		{
		   timeleft--;  //dec time left after 60 counts
		   counter = 0; //reset counter
		}
		time.setText("Time:"+timeleft);
	}
	
	void detectCollision(){
		Rectangle basketRect = new Rectangle(x_basket,y_basket,100,65); //making a rectangle on the basket
		Rectangle coinRect    = new Rectangle(x_coin,y_coin,45,67); //making a rectangle on egg
		
		if(coinRect.intersects(basketRect)){
			pointsCount+=5; // give 5 points on each catch
			points.setText("Points:"+pointsCount); // set the count
			y_coin = 0; // for next egg
			x_coin = rand.nextInt(1000); // again randomizing x axis of egg
		}
	}//end collision detection
	
	void checkGameOver(){
		if(timeleft <= 0 || healthPlayer <=0)
		{
			
			//Ctb.cl.show(Ctb.cards, "GameOverPanel");
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(400, 400, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.RED);
			add(yourScore);
			

    

            
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(tempbkg,0,0,null); //game background
		
		checkGameOver();
		
		if(gameOver == false){
			setFocusable(true);
			grabFocus();
			updateTime();
			
			fallCoin();
			detectCollision();
		
			g2d.drawImage(coin, x_coin, y_coin,null); //drawing egg at new position
			g2d.drawImage(basket, x_basket, y_basket, null); //drawing basket
		}
		
		repaint();	
	}//end paintComponent

}



