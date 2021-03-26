import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class add_usr extends JFrame implements ActionListener
{
  JLabel n1,d1,s1;
  JLabel nm,p1,p2;
  JPasswordField tp1,tp2;
  JTextField tnm;
  JButton ac,re,ex;
  public add_usr()
  {
   super("Entry for User");
   setResizable(false);
   setLocation(300,200);
   setLayout(null);
   setSize(500,350);
   getContentPane().setBackground(new Color(0.89f,0.89f,0.89f));
   n1=new JLabel("New User Entry",JLabel.CENTER);
   n1.setFont(new Font("Arial",Font.BOLD,16));
   n1.setForeground(Color.BLUE);
   s1=new JLabel("Miltery  Canteen System",JLabel.CENTER);
   s1.setForeground(Color.RED);
   s1.setFont(new Font("Arial",Font.BOLD,25));
   nm=new JLabel("User-Name:",JLabel.CENTER);
   nm.setForeground(Color.BLUE);
   p1=new JLabel("PassWord",JLabel.CENTER);
   p1.setForeground(Color.BLUE);
   p2=new JLabel("Confirm PassWord",JLabel.CENTER);
   p2.setForeground(Color.BLUE);
   tnm=new JTextField(30);
   tp1=new JPasswordField(30);
   tp1.setEchoChar('*');
   tp2=new JPasswordField(30);
   tp2.setEchoChar('*');
   ac=new JButton("Accept");
   ac.setMnemonic('A');
   ac.setForeground(Color.BLUE);
   re=new JButton("Reject");
   re.setMnemonic('R');
   re.setForeground(Color.BLUE);
   ex=new JButton("Exit");
   ex.setMnemonic('E');
   ex.setForeground(Color.BLUE);
   s1.setBounds(65,35,450,35);
   n1.setBounds(180,80,150,20);
   nm.setBounds(40,130,100,20);
   tnm.setBounds(190,130,250,20);
   p1.setBounds(40,160,100,20);
   tp1.setBounds(190,160,250,20);
   p2.setBounds(20,190,130,20);
   tp2.setBounds(190,190,250,20);
   ac.setBounds(80,250,100,30);
   re.setBounds(200,250,100,30);
   ex.setBounds(320,250,100,30);
   add(n1);
   add(s1);
   add(nm);
   add(p1);
   add(p2);
   add(tnm);
   add(tp1);
   add(tp2);
   add(ac);
   add(re);
   add(ex);
   ac.addActionListener(this);
   re.addActionListener(this);
   ex.addActionListener(this);
   }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==ex)
    {
			AdminUse	au=new AdminUse("AdminUse");
	      au.setVisible(true);
        setVisible(false);
     
    }
    if(ae.getSource()==ac)
    {   
        String ms2="insert into SalePerson(pname,pass) values(?,?)";
        String tk1="",tk2="",tk3="";
        tk1=tnm.getText();
        tk2=tp1.getText();
        tk3=tp2.getText();
     
        if(tk1.equals(""))
        {
	       JOptionPane.showMessageDialog(null,"  PLZ. Enter fields appropriately ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
        
	     }else if(tk2.equals("")||tk3.equals(""))
		{
	       JOptionPane.showMessageDialog(null,"  Passwords should not empty ","ERROR",JOptionPane.INFORMATION_MESSAGE);  
		  
		}else if(tk2.equals(tk3))
        {  
	      
         int cr=0,cr2;
 	     String w1[]=new String[20];
 	     String w2[]=new String[20];
 	     PreparedStatement ps;
 	      try
              {
               Connection con;
               Statement st;
               ResultSet rs;
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               con=DriverManager.getConnection("Jdbc:Odbc:mcm");
               ps=con.prepareStatement(ms2);
               st=con.createStatement();
               rs=st.executeQuery("select * from SalePerson");
               while(rs.next())
               {
               	cr++;
                 w1[cr]=rs.getString(1);
                 w2[cr]=rs.getString(2);
                 
               }
 	           cr2=cr;
 	       
 	        ps.setString(1,tk1);
 	        ps.setString(2,tk2);
 	        ps.executeUpdate();
 	        JOptionPane.showMessageDialog(null,"The User is created Successfully","ENTRY",JOptionPane.INFORMATION_MESSAGE);
 	        ps.clearParameters();
 	       tp1.setText("");
		   tp2.setText("");
			   tnm.setText("");
			 
 	          } 
 	        catch(Exception e)
 	        {} 
 	       
        }else{
		     	JOptionPane.showMessageDialog(null,"  Passwords are not matching ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
    
		          }
	
						AdminUse	au=new AdminUse("AdminUse");
	      au.setVisible(true);
        setVisible(false);
    
        
     }
    if(ae.getSource()==re)
    {
	 String tk1="",tk2="",tk3="";
        tk1=tnm.getText();
        tk2=tp1.getText();
        tk3=tp2.getText();
     
        if(tk1.equals(""))
        {
	       JOptionPane.showMessageDialog(null,"  PLZ. Enter fields appropriately ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
        
	     }else if(tk2.equals("")||tk3.equals(""))
		{
	       JOptionPane.showMessageDialog(null,"  Passwords should not empty ","ERROR",JOptionPane.INFORMATION_MESSAGE);  
		  
		}else if(tk2.equals(tk3))
        {  
	   
             try
            {

		       Connection con;
               Statement st;
               ResultSet rs;
               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
               con=DriverManager.getConnection("Jdbc:Odbc:mcm");
              
      //prepare statement
      String qry = "Delete from SalePerson where pname=?  ";
      PreparedStatement ps = con.prepareStatement(qry);

      ps.setString(1, tk1);
     // ps.setString(2, tk2);

      ps.executeUpdate();
	  JOptionPane.showMessageDialog(null,"The User is deleted Successfully","ENTRY",JOptionPane.INFORMATION_MESSAGE);
 	        tp1.setText("");
		   tp2.setText("");
			   tnm.setText("");
	
					AdminUse	au=new AdminUse("AdminUse");
	      au.setVisible(true);
        setVisible(false);
    
			
    }
    catch(Exception e) {System.out.println(e);  }
  }
           
            
    }	
  }
 public static void main(String args[]) 
 {
  add_usr us1=new add_usr();
  us1.setVisible(true);
 }
}
  
