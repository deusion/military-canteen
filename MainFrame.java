//import files
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  MainFrame extends JFrame  implements ActionListener
{
	 JButton pD,canD,votD,votStart,cancel;
	public MainFrame()
	{
       super("MainFrame");
	   setLocation(200,200);
       
		
			 //BUTTON
			 canD=new JButton("ADMIN USE");
		     votD=new JButton("CANTEEN");
			 pD=new JButton("WINE");
             votStart=new JButton("INSERT PERSON INFORMATION");
		     cancel=new JButton("Cancel");
		     
			 //setbounds
			 pD.setBounds(400,40,225,50);
			 votD.setBounds(90,40,225,50);
				canD.setBounds(220,150,225,50);
			 votStart.setBounds(90,250,225,50);
			 cancel.setBounds(400,250,225,50);





			 //add
		     add(canD);
			         add(votD);
			     add(pD);
			 add(votStart);
		     add(cancel);
		

		canD.addActionListener(this);
            votD.addActionListener(this);
            pD.addActionListener(this);
        votStart.addActionListener(this);
         cancel.addActionListener(this);
	
		  setLayout(null);
	   setSize(700,420);
	 }
	 public void actionPerformed(ActionEvent ae)
	{
		 if(ae.getSource()==canD)
		{
			 Admin au=new Admin();
			 setVisible(false);
			 au.setVisible(true);

		   }else if(ae.getSource()==votD)
	  	   {
			   SalemanInfo  si=new  SalemanInfo();
			   setVisible(false);
			   si.setVisible(true);
		    }else if(ae.getSource()==pD)
	  	   {
			
			   SalemanInfo1 si1=new  SalemanInfo1();
			   setVisible(false);
			   si1.setVisible(true);
		    }else if(ae.getSource()==votStart)
	  	   {
			   PersonInfo1 w1=new PersonInfo1();
			   setVisible(false);
			   w1.setVisible(true);
		    }else if(ae.getSource()==cancel)
		    {
			new AboutMe();
				   setVisible(false);			
			}
	   }
	public static void main(String [] args) 
	{
		MainFrame mf=new MainFrame();
		mf.setVisible(true);
	}
}
