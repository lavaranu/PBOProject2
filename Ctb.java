import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.*;


public class Ctb extends JFrame implements ActionListener{

    JMenuBar menuBar;
    JMenu menu;
    JMenuItem newGameMenuItem;
    JMenuItem exitGamMenuItem;
    
    static MenuPanel mp = new MenuPanel();
    static GamePanel gp = new GamePanel();
    static GamePanel2 gp2 = new GamePanel2();
    static GamePanel3 gp3 = new GamePanel3();
    static HelpPanel hp = new HelpPanel();
    static LevelPanel lp = new LevelPanel();
    

    static CardLayout cl = new CardLayout();
    static JPanel cards = new JPanel();

    Ctb(){
        cards.setLayout(cl);// setting the layout to cardlayout
		cards.add(mp, "MenuPanel");
        cards.add(gp, "GamePanel");
        cards.add(gp2, "GamePanel2");
        cards.add(gp3, "GamePanel3");
        cards.add(hp,"HelpPanel");
        cards.add(lp,"LevelPanel");
		cl.show(cards, "MenuPanel");
		add(cards); //adding the panel with cardlayout in JFrame

        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        newGameMenuItem = new JMenuItem("New Game");
        exitGamMenuItem = new JMenuItem("Exit game");

        newGameMenuItem.addActionListener(this);
        exitGamMenuItem.addActionListener(this);

		
		setTitle("Catch The Bitcoin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1039, 700); //frame size
		setResizable(false);

        menu.add(newGameMenuItem);
        menu.add(exitGamMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
		setVisible(true);   //frame visibility
    }

    public static void main(String[] args) {
        new Ctb();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource()==newGameMenuItem){
            Ctb.cl.show(cards, "MenuPanel");
        } else if(e.getSource()==exitGamMenuItem){
            System.exit(0);
        }
        
    }


}
