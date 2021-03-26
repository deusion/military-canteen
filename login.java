import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login extends JFrame implements ActionListener
{
	JLabel name,pass,img,title,pname;
	JButton ok,cancel;
	JTextField tname,tpass;
	int count=0;
 login()
	{
	 super("login");
	 setLayout(null);
	 setLocation(355,40);
	 setSize(460,620);
	 	getContentPane().setBackground(new Color(0.98f,0.9f,0.9f));
    
	 title=new JLabel("WEL-COME",JLabel.CENTER);
	 title.setFont(new Font("Arial",1,22));
	 title.setForeground(Color.BLUE);
	 title.setBounds(115,30,250,20);


	 pname=new JLabel("MILTARY CANTEN MANAGEMENT SYSTEM",JLabel.CENTER);
     pname.setFont(new Font("Arial",Font.BOLD,16));
     pname.setForeground(Color.RED);
     pname.setBounds(45,70,400,30);
  

	 name=new JLabel("User Name :");
	 name.setFont(new Font("Arial",Font.BOLD,22));
	 name.setForeground(new Color(0.8f,0.0f,0.9f));
	 name.setBounds(70,140,130,30);
  
     pass=new JLabel("PassWord :");
     pass.setFont(new Font("Arial",Font.BOLD,22));
	 pass.setForeground(new Color(0.8f,0.0f,0.9f));
     pass.setBounds(70,190,130,30);
	 
	 tname=new JTextField(25);
	 tname.setFont(new Font("Arial",0,25));
	 tname.setBounds(220,140,150,30);
  
     tpass=new JPasswordField(25);
	 tpass.setBounds(220,190,150,30);
  
    
	 ok=new JButton("Login");
	 ok.setFont(new Font("Arial",Font.BOLD,15));
     ok.setBounds(140,240,100,30);
     
	 cancel=new JButton("Cancel");
	 cancel.setFont(new Font("Arial",Font.BOLD,15));
	 cancel.setBounds(270,240,100,30);


	 img=new JLabel();
	 img.setIcon(new ImageIcon("b3c.jpg"));
	 img.setBounds(2,149,600,600);

	
  
     add(name);
	 add(pname);
	 add(tname);
	 add(pass);
	 add(tpass);
	 add(ok);
	 add(cancel);
     add(img);
	 add(title);

	 ok.addActionListener(this);
	 cancel.addActionListener(this);
	  }
	  public void actionPerformed(ActionEvent ae)
	 {
		  int cr=0,cr2;
 	  String w1[]=new String[20];
 	  String w2[]=new String[20];
 	  try
      {
              Connection con;
              Statement st;
              ResultSet rs;
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
              con=DriverManager.getConnection("Jdbc:Odbc:mcm");
              st=con.createStatement();
              rs=st.executeQuery("select * from SalePerson");
              while(rs.next())
              {
              	cr++;
                w1[cr]=rs.getString(1);
                w2[cr]=rs.getString(2);
                
              }
 	        cr2=cr;
 	 
   	
     
    		String s1="",s2="";
  			int flag=0,flag2=0;
  			if(ae.getSource()==ok)
  			{
		    s1=tname.getText();
		    s2=tpass.getText();
		    if(count<3)
     		{
         		count++;
         		for(int i=1;i<=cr;i++,flag=0)
          		if(w1[i].equals(s1))
           		{
           			flag=1;
           			break;
           		}	
		           
        		 for(int j=1;j<=cr;j++,flag2=0)
           		 if(w2[j].equals(s2))
           	     {
           			flag2=1;
           			break;
           		 }	
         
        		 if(flag==1)
         		 {
           			if(flag2==1)
           			{
                                
            			MainFrame d1=new MainFrame();
            			setVisible(false);
            			d1.setVisible(true);
			            
           			}
          			else
           			{
           				if(s2.equals(""))
           	 			{
           	 				JOptionPane.showMessageDialog(null," PLZ. Enter the Password ","ERROR",JOptionPane.INFORMATION_MESSAGE);
			           	 	
           	 			}	
           				else 
           	 			{
           	 			JOptionPane.showMessageDialog(null,"    Password  is  Wrong  ","ERROR",JOptionPane.INFORMATION_MESSAGE);
			           	 
           				 }	
           			}	
         		 }
        		 else
                 {	
         	      if(s1.equals(""))
                  {
                   JOptionPane.showMessageDialog(null,"   Please enter User Name ","ENTRY",JOptionPane.INFORMATION_MESSAGE);
          
                  }
                  else
                  {
           	        JOptionPane.showMessageDialog(null,"    UserName is Wrong","ERROR",JOptionPane.INFORMATION_MESSAGE);
              	
                  }	
           
                 }
             }
             else
             {
              JOptionPane.showMessageDialog(null,"Sorry your chance has over","ERROR",JOptionPane.INFORMATION_MESSAGE);
              System.exit(0);
             }
           }
           if(ae.getSource()==cancel)
           { 
             System.exit(0);
           }
    }
    catch(Exception e)
    {} 
}
 public static void main(String []args)
	{
	  
	  login l=new login();
	  l.setVisible(true);
	 }
}