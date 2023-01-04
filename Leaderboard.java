import java.sql.*;
import java.util.ArrayList;

import javax.sound.midi.SysexMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class Leaderboard extends JPanel {

    private Connection con;
    private String url;
    private String uname;
    private String pass;
    private Statement stmt;
    private String query;

    String name;
    int score;

    String[] coloumnNames = {"Nama", "Score"};
    DefaultTableModel model;

    Image ldBg = new ImageIcon("images\\leaderboard.png").getImage();

    JButton back = new JButton(""); //back button

	ImageIcon backButton = new ImageIcon("buttons\\back.png");
    

    public Leaderboard(){

        setFocusable(true); //setting the focus
		setLayout(null);
		
		back.setIcon(backButton);
		this.add(back);
		back.setBounds(100, 500, 170, 50);

        url = "jdbc:mysql://localhost/game_leaderboard2";
        uname = "root";
        pass = "";
        this.setConnectionAndStatement();

        model = new DefaultTableModel(coloumnNames, 0);

        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        this.add(scrollPane);
        scrollPane.setBounds(330, 190, 400, 400);
        scrollPane.setVisible(true);

        back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				Ctb.cl.show(Ctb.cards, "MenuPanel"); // show menuPanel when back button is clicked
			}	
		  });
    }

    private void setConnectionAndStatement() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    

    public void save(String nama, int score){
        try {
            query = "INSERT INTO leaderboard VALUES ('%s', '%d')";
            query = String.format(
                query,
                nama,
                score);
            System.out.println(query);
            stmt.executeUpdate(query);
            System.out.println("Berhasil Menambahkan Data");
        } catch (Exception e) {
            System.err.println("Error Inserting data: " +e.getMessage());
            System.exit(1);
        }
    }

    public ArrayList<Player> getAll(){
        ArrayList<Player> allPlayer = new ArrayList<>();

        try {
            query = "SELECT * FROM leaderboard ORDER BY score DESC";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                allPlayer.add(new Player(
                    name =  rs.getString("Nama"),
                    score = rs.getInt("Score")));
                    model.addRow(new Object[] {name, score});
            }
        } catch (Exception e) {
           System.err.println("Error Getting Data: " +e.getMessage());
           System.exit(1);
        }
        return allPlayer;

        
    }

    public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(ldBg, 0,0, null); // draw help background
		repaint();
	}//end paintComponent
    

}
