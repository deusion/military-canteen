import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




class AboutMe implements ActionListener 
{
 JFrame m_frame;
 JLabel label1;
 JLabel label2;
 JLabel by;
 JLabel tush;
 JLabel nin,nin1;
 JButton close;
 public AboutMe()
 {
   	
   m_frame=new JFrame("About Author");
   m_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   m_frame.getContentPane().setLayout(null);
   m_frame.getContentPane().setBackground(new Color(0.89f,0.89f,0.89f)); 
   
m_frame.getContentPane().setBackground(new Color(0.98f,0.9f,0.9f));



   label1=new JLabel("MILITARY MANAGEMENT "); 
   label2=new JLabel("SYSTEM....");
   

   by=new JLabel("Designed By:-");
   tush=new JLabel("Divesh Jagger");
   nin=new JLabel("Atharva Subhekar");
    nin1=new JLabel(".");
   close=new JButton("EXIT");

   m_frame.getContentPane().add(label1);
   m_frame.getContentPane().add(label2);
   m_frame.getContentPane().add(by);
   m_frame.getContentPane().add(tush);
   m_frame.getContentPane().add(nin);
   //   m_frame.getContentPane().add(nin1);
   m_frame.getContentPane().add(close);
 
   label1.setFont(new Font("Courier New",Font.BOLD,33));
   label2.setFont(new Font("Courier New",Font.BOLD,35));
  
   by.setFont(new Font("Courier New",Font.BOLD,18));
   tush.setFont(new Font("Courier New",Font.BOLD|Font.TRUETYPE_FONT,23));
   nin.setFont(new Font("Courier New",Font.BOLD|Font.TRUETYPE_FONT,23));
    nin1.setFont(new Font("Courier New",Font.BOLD|Font.TRUETYPE_FONT,23));
   close.setFont(new Font("Courier New",Font.BOLD,16));
   
   label1.setForeground(Color.blue);
   label2.setForeground(Color.blue);
  

   by.setForeground(new Color(0.3f,0.9f,0.3f));
   tush.setForeground(new Color(0.8f,0.2f,0.1f));
   nin.setForeground(new Color(0.8f,0.2f,0.1f));
   nin1.setForeground(new Color(0.8f,0.2f,0.1f));
   
   close.setForeground(new Color(0.8f,0.2f,0.1f));
    
   label1.setBounds(50,30,400,30);
   label2.setBounds(280,75,350,30);
   

   by.setBounds(35,130,190,30);
   tush.setBounds(160,190,355,25);
   nin.setBounds(160,230,370,25);
   nin1.setBounds(160,270,370,25);
   
   close.setBounds(180,320,100,35);

   m_frame.getRootPane().setDefaultButton(close);
   close.setMnemonic('c');
   close.addActionListener(this);

   m_frame.setSize(500,450);
   m_frame.setLocation(150,80);
   m_frame.setVisible(true);
   m_frame.setResizable(false);

 }

 public void actionPerformed(ActionEvent ae) 
 {
    if(ae.getSource()==close)
     {
     	m_frame.setVisible(false);
     	System.exit(0);
     }

 }
 public static void main(String args[])
 {
     new AboutMe();
	
 
 }
 
}
