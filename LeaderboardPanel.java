import java.awt.event.*;
import java.lang.Thread.State;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

import java.util.*;
import java.awt.*;
import java.sql.*;
import java.sql.Statement;

public class LeaderboardPanel extends JPanel {
    
    Image bg = new ImageIcon("images\\gameBackground2.png").getImage();
    JButton back = new JButton("Back");
    JTable table;
    
    public LeaderboardPanel() {
        setFocusable(true); //setting the focus
		add(back);	

        back.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent me){
				Ctb.cl.show(Ctb.cards, "MenuPanel"); // show menuPanel when back button is clicked
			}	
		  });
    }

    void Tableld(){
        setSize(600,400);
        setVisible(true);
        Object[][] data = {{ null,null,null }, {null,null,null}};
        String[] coloumnname = {"Tanggal", "Score"};

        DefaultTableModel model = new DefaultTableModel(data, coloumnname);

        table = new JTable(model);
        add(new JScrollPane(table));
        validate();

        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("Tanggal");
        tbl.addColumn("Score");

       try {
        Statement st = (Statement) Koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM leaderboard ORDER BY Score DESC");

        while(rs.next()){
            tbl.addRow(new Object[]{
                rs.getString("Tanggal"),
                rs.getString("Score"),
            });
            table.setModel(tbl);
        }
        
       } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Koneksi Database gagal" +e.getMessage());
       }
        


    }

    public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(bg, 0,0, null); // draw help background
		repaint();
	}//end paintComponent
    

}
