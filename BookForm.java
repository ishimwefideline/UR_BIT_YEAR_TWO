package entity.form;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookForm implements ActionListener{
	JFrame frame;
	JLabel idlb= new JLabel("Book_ID");
	JLabel isbnlb= new JLabel("Book_ISBN");
	JLabel titllb= new JLabel("Book_TITLE");
	JLabel pubyrllb= new JLabel("Book_PUBYEAR");
	
	
	JTextField idTextField= new JTextField();
	JTextField isbnTextField= new JTextField();
	JTextField titlTextField= new JTextField();
	JTextField pubyrTextField= new JTextField();
	
	
	JButton insertbtn= new JButton ("INSERT");
	JButton readbtn= new JButton ("READ");
	JButton updatebtn= new JButton ("UPDATE");
	JButton deltebtn= new JButton ("DELTE");
	

	
	public BookForm () {
		createwindows3();
	}
	
	
	private void createwindows3() {
		frame= new JFrame();
		frame.setTitle(" BookForm  ");
		frame.setBounds(10,10,500,400);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setsizeandlocation();
			
	}
	 
	
	private void setsizeandlocation() {
		idlb.setBounds(10,10,200,30);
		titllb.setBounds(10,50,200,30);
		isbnlb.setBounds(10,90,200,30);
		pubyrllb.setBounds(10,130,200,30);
		
		
		idTextField.setBounds(160,10,130,30);
		titlTextField.setBounds(160,50,130,30);
		isbnTextField.setBounds(160,90,130,30);
		pubyrTextField.setBounds(160,130,130,30);
		
		
		insertbtn.setBounds(10,200,85,30);
		readbtn.setBounds(100,200,85,30);
		updatebtn.setBounds(190,200,85,30);
		deltebtn.setBounds(280,200,85,30);
		addcomponenttoframe();
		
		// TODO Auto-generated method stub
		
	}


	private void addcomponenttoframe() {
		frame.add(idlb);
		frame.add(titllb);
		frame.add(isbnlb);
		frame.add(pubyrllb);
		frame.add(idTextField);
		
		frame.add(titlTextField);
		frame.add(isbnTextField);
		frame.add(pubyrTextField);
		frame.add(insertbtn);
		frame.add(readbtn);
		frame.add(updatebtn);
		frame.add(deltebtn);
		ActionEvent();
		
		
		
		
		// TODO Auto-generated method stub
		
	}


	private void ActionEvent() {
		insertbtn.addActionListener(this);
		insertbtn.addActionListener(new ActionListener() {
			

			public void actionPerformed(java.awt.event.ActionEvent e) {
				// TODO Auto-generated method stub
			try {
			Class.forName("com.mysql.jc.jdbc.driver");	
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/libray","root","");
			String query="INSERT INTO book VALUES (?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(idTextField.getText()));
			ps.setString(2,titlTextField.getText());
			ps.setInt(1,Integer.parseInt(isbnTextField.getText()));
			ps.setString(4,pubyrTextField.getText());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(insertbtn,"successfully");
			ps.close();
			conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}	
			}
		});
		readbtn.addActionListener(this);
		updatebtn.addActionListener(this);
		deltebtn.addActionListener(this);
		setFontforall();
		
		
		
		
	}



	
	private void setFontforall() {
		
		Font fontii= new Font("Georgia", Font.ITALIC,18); 
		idlb.setFont(fontii);
		titllb.setFont(fontii);
		isbnlb.setFont(fontii);
		pubyrllb.setFont(fontii);
		
		idTextField.setFont(fontii);
		titlTextField.setFont(fontii);
		isbnTextField.setFont(fontii);
		pubyrTextField.setFont(fontii);
		

		
		Font fii=new Font("CourierNew",Font.BOLD,12);
		insertbtn.setFont(fii);
		readbtn.setFont(fii);
		updatebtn.setFont(fii);
		deltebtn.setFont(fii);
		// TODO Auto-generated method stub
		
	}


	

































	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



public static void main(String[] args) {
	BookForm  atf= new BookForm();

}
}

