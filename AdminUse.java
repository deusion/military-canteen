//import files
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  AdminUse extends JFrame implements ActionListener
{
	private JButton canD,votD,cancel,cardPrint,cPass;

	public 	AdminUse(String s)
	{
       super(s);
	   setLocation(200,200);
       
	    getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(0.99f,0.9f,0.9f));
		
		     
			 //BUTTON
			 canD=new JButton("CATEEN USE");
            canD.setForeground(Color.BLUE);
		   canD.setFont(new Font("Arial",Font.PLAIN,18));

			 votD=new JButton("WINE USE");
           votD.setForeground(Color.BLUE);
		   votD.setFont(new Font("Arial",Font.PLAIN,18));

			 cPass=new JButton("PASSWORD CHANGE");
			  cPass.setForeground(Color.BLUE);
		   cPass.setFont(new Font("Arial",Font.PLAIN,18));

		
			 cardPrint=new JButton("VIEW OF PERSON INFO");
		     cardPrint.setForeground(Color.BLUE);
		     cardPrint.setFont(new Font("Arial",Font.PLAIN,18));

			 cancel=new JButton("Cancel");
		      cancel.setForeground(Color.BLUE);
		    cancel.setFont(new Font("Arial",Font.PLAIN,18));
 
			 //setbounds
			 canD.setBounds(90,40,225,50);
			 cardPrint.setBounds(400,40,225,50);
			 votD.setBounds(400,160,225,50);
			 //votD.setBounds(90,130,225,50);
			// cPass.setBounds(400,130,225,50);
			 
			 cPass.setBounds(90,160,225,50);
			 cancel.setBounds(240,290,225,50);



			 //add
		     add(canD);
			 add(cardPrint);
		     add(votD);
			 add(cPass);
		     add(cancel);
		

		
		
			 votD.addActionListener(this);
			 cPass.addActionListener(this);
			 canD.addActionListener(this);
			 cardPrint.addActionListener(this);
             cancel.addActionListener(this);
		  

		  setLayout(null);
	   setSize(700,420);
	 }
	 public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cPass)
		{
			 add_usr us1=new add_usr();
             setVisible(false);
			 us1.setVisible(true);
		  }else if(ae.getSource()==canD)
		{
			    CanteenEdit c=new   CanteenEdit(1);
				// setVisible(false);
				 c.setVisible(true);
		   }else if(ae.getSource()==votD)
		{
			    WineEdit c1=new   WineEdit(1);
				// setVisible(false);
				 c1.setVisible(true);
		   }else if(ae.getSource()==cancel)
		{
			   MainFrame mf=new MainFrame();
			  setVisible(false);
			   mf.setVisible(true);
		   }else if(ae.getSource()==cardPrint)
		{
			   ViewPersonInfo ap=new ViewPersonInfo();
			 setVisible(false);
			   ap.setVisible(true);
	   	 }

	  }
	public static void main(String[] args) 
	{
		AdminUse mf=new AdminUse("AdminUse");
		mf.setVisible(true);
	}
}
