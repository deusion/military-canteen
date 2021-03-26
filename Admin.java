import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Admin extends JFrame implements ActionListener
{
 JLabel ml,l1,l2,img,name,sup;
 JTextField t1;
 JButton b1,b2;
 JPasswordField p1;
 Font df=new Font("Arial",Font.BOLD,25);
 Font df1=new Font("Georgia",Font.BOLD,15);
 String z1="Administrator Use",z2="Admin. Name",z3="PassWord";
 int count=0;
 public Admin()
 {
 

  super("Admin Login");
  setResizable(false);
  setLocation(300,270);
  setLayout(null);
  getContentPane().setBackground(new Color(0.90f,0.9f,0.9f));
  name=new JLabel(" ",JLabel.CENTER);
  name.setFont(new Font("Arial",Font.BOLD,20));
  name.setForeground(Color.RED);
  sup=new JLabel(" ",JLabel.CENTER);
  sup.setFont(new Font("vardona",Font.PLAIN,17));
  sup.setForeground(Color.BLACK);
  ml=new JLabel(z1,JLabel.CENTER);
  ml.setForeground(Color.BLUE);
  ml.setFont(df);
  l1=new JLabel(z2,JLabel.CENTER);
  l1.setFont(df1);
  l1.setForeground(new Color(0.8f,0.0f,0.9f));
  l2=new JLabel(z3,JLabel.CENTER);
  l2.setFont(df1);
  l2.setForeground(new Color(0.8f,0.0f,0.9f));
  t1=new JTextField(30);
  t1.setFont(df1);
  p1=new JPasswordField(15);
  p1.setFont(df1);
  p1.setEchoChar('#');
  b1=new JButton("LOGIN");
  b1.setForeground(Color.BLUE);
  b1.setMnemonic('L');
  b2=new JButton("CANCEL");
  b2.setForeground(Color.BLUE);
  b2.setMnemonic('C');
  setSize(340,260);
  name.setBounds(50,100,400,30);
  sup.setBounds(190,140,350,30);
  ml.setBounds(25,30,250,20);
  l1.setBounds(0,80,130,30);
  t1.setBounds(130,84,150,25);
  l2.setBounds(0,120,130,30);
  p1.setBounds(130,124,150,25);
  b1.setBounds(65,180,100,30);
  b2.setBounds(190,180,100,30);

  add(name);
  add(sup);
  add(ml);
  add(l1);
  add(t1);
  add(l2);
  add(p1);
  add(b1);
  add(b2);
  b1.addActionListener(this);
  b2.addActionListener(this);
 
 }
 public void actionPerformed(ActionEvent ae)
 {
	 if(ae.getSource()==b2)
	 {
		 MainFrame m=new MainFrame();
		setVisible(false);
		 m.setVisible(true);
	  }
	 if(ae.getSource()==b1)
	 {
		 if(t1.getText().equals("admin")&&p1.getText().equals("magar"))
		 {
		 AdminUse au=new AdminUse("Admin Use");
		  setVisible(false);
		 au.setVisible(true);
		 }else
		 {
			        JOptionPane.showMessageDialog(null,"  Please Enter correct password ","ERROR",JOptionPane.INFORMATION_MESSAGE);  
	                   t1.setText(" ");
					   p1.setText("");
		  }
	 }
 }
 public static void main(String args[])
 {   
  
  Admin lk=new Admin();
  lk.setVisible(true);
 }
}


