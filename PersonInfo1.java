
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.sql.*;

public class PersonInfo1 extends JFrame implements ActionListener,ItemListener  
{
	JLabel new1,new2,name,middle,bdate,age,sex,vAddr,tal,dist,pin;
	JTextField tname,tmiddle,tage;
	JButton ok,cancel;
    JTextArea tvAddr;
	JComboBox tsex,trank,tday,eday,rday,tmonth,emonth,rmonth,tyear,eyear,ryear;
  int r;
    //sql
  private PreparedStatement pss;
  private Statement st;
  private Connection con;
int d,gs,d1,d2;
	    //sql
  PreparedStatement ps;

     PersonInfo1()
	{			
		 super(" Information");
		setLayout(null);
         setLocation(200,20);
        

		//calender
		 GregorianCalendar gc=new GregorianCalendar();
    d=gc.get(Calendar.YEAR);
		//int   d=gc.get(Calendar.YEAR);
		
		new1=new JLabel("  FIRST FORM .................. ",JLabel.LEFT);
        new1.setFont(new Font("Arial",Font.ITALIC,20));
		new1.setForeground(Color.BLUE);

	    new2=new JLabel("Insert   Information");
        new2.setFont(new Font("convecta",Font.BOLD,16));
		new2.setForeground(Color.BLUE);
       
		//choice
		tsex=new  JComboBox();
		tsex.addItem("");
		tsex.addItem("Male");
		tsex.addItem("Female");
		
		trank=new  JComboBox();
        trank.addItem("  ");
		trank.addItem("  General ");
		trank.addItem("  Lieutenant General ");
		trank.addItem("  Major General ");
		trank.addItem("  Brigadier ");
		trank.addItem("  Colonel ");
		trank.addItem("  Lieutenant Colonel ");
		trank.addItem("  Major ");
		trank.addItem("  Captain ");
			trank.addItem("  Lieutenant");
				trank.addItem("  Subedar Major ");
					trank.addItem("  Subedar* ");
						trank.addItem("  Naib Subedar ");
							trank.addItem("  Havildar ");
							trank.addItem("  Naik ");
							trank.addItem("  Lance Naik ");
					
		//day
		tday=new  JComboBox();
	    eday=new  JComboBox();
	    rday=new  JComboBox();
	
		tday.addItem("");
        eday.addItem("");
        rday.addItem("");

		for(int i=1;i<=31;i++)
		{
		 tday.addItem(" "+i);	
		 eday.addItem(" "+i);	
		 rday.addItem(" "+i);	
		
		}
	
		//date
		  tmonth=new  JComboBox();
		  tmonth.addItem("");
		  emonth=new  JComboBox();
		  emonth.addItem("");
		  rmonth=new  JComboBox();
		  rmonth.addItem("");
		  
		  String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
           for(int i=0;i<12;i++)
		{
		   tmonth.addItem(month[i]);
 		   emonth.addItem(month[i]);
 		   rmonth.addItem(month[i]);
 		}
		//year
		tyear=new JComboBox();
		tyear.addItem("");
		eyear=new JComboBox();
		eyear.addItem("");
		ryear=new JComboBox();
		ryear.addItem("");
		
		for(int i=1900;i<=d;i++)
		{
		 tyear.addItem(""+i);
	    eyear.addItem(""+i);
	      ryear.addItem(""+i);
	
		}
		
		
		//label
        name=new JLabel("Identity No:");
		middle=new JLabel("Full Name :");
		bdate=new JLabel("birth Date :");
		age=new JLabel("Age :");
		sex=new JLabel("Sex :");
		vAddr=new JLabel("Rank :");
		tal=new JLabel(" Date Retirment:");
		dist=new JLabel("Address:");
		pin=new JLabel("Date Enrolment:");
        
		//textfield
		
         tname=new JTextField(25);
		 tmiddle=new JTextField(25);
		 tage=new JTextField(25);
			 
		 //TextArea
		tvAddr=new JTextArea(100,100);

		 //button

		 ok=new JButton("Next ");
		 cancel=new JButton("Cancel");
		 
       
		 //bounds
		  new1.setBounds(100,25,500,20);
		 new2.setBounds(120,60,500,20);
         name.setBounds(70,105,100,20);
         tname.setBounds(170,100,200,35);
         middle.setBounds(70,155,100,20);
         tmiddle.setBounds(170,150,200,35);
         bdate.setBounds(70,205,100,20);
         tday.setBounds(170,200,50,25);
		 eday.setBounds(170,350,50,25);
		 rday.setBounds(170,400,50,25);
		  tmonth.setBounds(230,200,70,25);
          emonth.setBounds(230,350,70,25);
          rmonth.setBounds(230,400,70,25);
          tyear.setBounds(320,200,80,25);
		  eyear.setBounds(320,350,80,25);
		  ryear.setBounds(320,400,80,25);
		  age.setBounds(320,250,40,15);
         tage.setBounds(370,240,40,30);
         sex.setBounds(70,255,100,20);
         tsex.setBounds(170,250,70,25);
         vAddr.setBounds(70,305,100,20);
		  pin.setBounds(70,350,100,20);
		 trank.setBounds(170,300,150,25);
         tvAddr.setBounds(170,450,200,90);
         tal.setBounds(70,405,100,20);
  		 dist.setBounds(70,455,100,20);
          ok.setBounds(150,550,90,35);
		 cancel.setBounds(270,550,90,35);
		           
		 //addItem
		 add(new1);
		 add(new2);
         add(name);
		 add(tname);
		 add(middle);
		 add(tmiddle);
		 add(bdate);
		 add(tday);
         add(eday);
		 add(rday);
		 add(tmonth);
		 add(emonth);
		 add(rmonth);
		 add(tyear);
		 add(eyear);
		 add(ryear);
		 add(trank);
		 add(age);
		 add(tage);
		 add(sex);
		 add(tsex);
		 add(vAddr);
		 add(tvAddr);
		 add(tal);
		 add(dist);
	     add(pin);
		 add(ok);
		 add(cancel);
	
		  setSize(480,630);
    
	   ok.addActionListener(this);
	   cancel.addActionListener(this);
	             tyear.addItemListener(this);
	}
 public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==ok)
		{ 
		  	String aa=tname.getText();
			String bb=tmiddle.getText();
			String c=(String)tday.getSelectedItem();
            String d=(String)tmonth.getSelectedItem();
			String e=(String)tyear.getSelectedItem();
			String ff=(String)tsex.getSelectedItem();
		    String gg=tage.getText();
			String hh=(String)trank.getSelectedItem();
		    String i=(String)eday.getSelectedItem();
            String j=(String)emonth.getSelectedItem();
			String k=(String)eyear.getSelectedItem();
			String l=(String)rday.getSelectedItem();
            String m=(String)rmonth.getSelectedItem();
			String n=(String)ryear.getSelectedItem();
		    String oo=tvAddr.getText();
			String tt=(String)tday.getSelectedItem()+"."+(String)tmonth.getSelectedItem()+"."+(String)tyear.getSelectedItem();
		    String ee=(String)eday.getSelectedItem()+"."+(String)emonth.getSelectedItem()+"."+(String)eyear.getSelectedItem();
		    String rr=(String)rday.getSelectedItem()+"."+(String)rmonth.getSelectedItem()+"."+(String)ryear.getSelectedItem();
		
			if(aa.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter No ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(bb.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Name ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(c.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Day ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(d.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Month ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(e.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter year ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(ff.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Sex ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(gg.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Age ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(hh.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Rank ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(i.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter  Enrolment  Day","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(j.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Enrolment  Month ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(k.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Enrolment  year ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(l.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Retirment day ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(m.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Retirment month ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(n.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Retirment  year  ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(oo.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Address ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else {

			 				 add(aa,bb,tt,ff,gg,hh,ee,rr,oo);
	         int s=20;
		  PersonInfo2 p=new PersonInfo2(aa);
		  setVisible(false);
		  p.setVisible(true);
			}
	     }else if(ae.getSource()==cancel)
		{
                MainFrame mf=new MainFrame();
			 	setVisible(false);
				mf.setVisible(true);
		  }
    }
	
     	public void itemStateChanged(ItemEvent e) 
	     {
		      String ff=(String)tyear.getSelectedItem();
		    if(ff.equals(""))
		   {
			          JOptionPane.showMessageDialog(null," PLZ. Select your year ","ERROR",JOptionPane.INFORMATION_MESSAGE);
	    	}else
		      {
			    try{	
		        if(e.getSource()==tyear)
                 {
              	int d1,d3,d6;
                 String uu=(String)tyear.getSelectedItem();
	            d6=Integer.parseInt(uu);
                d3=d-d6;
     		  tage.setText(Integer.toString(d3));
              }
	     }     
	      catch(Exception se)
	       	 {
		     System.out.println(se);
	         }
   	    }
	
 }
	public static void main(String[] args) 
	{
	   PersonInfo1 t=new PersonInfo1();
			t.setVisible(true);
	}
public void  add(String a,String b,String c,String d,String e,String f,String g,String h,String i )
	{

	  try
      {
   

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 con = DriverManager.getConnection("jdbc:odbc:mcm","scott","pravin");
	
/*   
	String dsn = "mcm";
      //load driver
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

      //make connection
      con = DriverManager.getConnection("jdbc:odbc:" + dsn);

      //create statement
      

	  */
       }
          catch (Exception se) {System.out.println(se+"pun");}
      

 try{
        Statement st=con.createStatement(); // used for select queries

			 ResultSet rs=st.executeQuery("select * from PersonInfo" );
              
			  while(rs.next())
			 {

				 gs=rs.getInt(1);
			 }
			 gs=gs+1;

     
	           int  d1=Integer.parseInt(e);
			System.out.println(gs);
      //prepare statement
      String qry = "Insert into PersonInfo values (?,?,?,?,?,?,?,?,?,?)";
     
      ps = con.prepareStatement(qry);
   
	  ps.setInt(1, gs);
	    
      ps.setString(2,a);
	
      ps.setString(3,b.toUpperCase());
	 
      ps.setString(4,c);
      ps.setString(5,d);
	
	  ps.setInt(6,d1);

	  ps.setString(7,f);

	  ps.setString(8,g);
	
	  ps.setString(9,h);

	  ps.setString(10,i.toUpperCase());
	  
      ps.executeUpdate();
	  
    }
    catch(Exception se) { System.out.println("pravin :=   "+se + "\t" + se.getMessage());  }

   
 }

     
}