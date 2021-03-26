import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class ViewCanteen extends JFrame implements ActionListener
{
	private JLabel month,day,year,tom,tod,toy;
	private JButton ok,finish;
	private JComboBox tday,tmonth,tyear;
	private JTextField stom,stod,stoy;

  private int i=1,j,k;
  String months[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEPT","OCT","NOV","DEC" };


     JTable tb;
     String c1[]={" ID No ","Name  "," Total  "};
	String d1[][]=new String[150][3];

	ViewCanteen()
	{
     
	 super("View Of Canteen ");
	 setLayout(null);
	 setLocation(20,100);
     setSize(630,630);
      

	  GregorianCalendar gc=new GregorianCalendar();
	     int d=gc.get(Calendar.DATE);
		 int m=gc.get(Calendar.MONTH);
		 int y=gc.get(Calendar.YEAR);

		 tb=new JTable(d1,c1);	
	    tb.setEnabled(false);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
		 		
         add(p);
    	p.setBounds(10,150,600,300);

	  //use label
	   month=new JLabel("Month :-");
	   day=new JLabel("Day :-");
	   year=new JLabel("year :-");
       tom=new JLabel(" Total Month :-");
	   tod=new JLabel("Total Day :-");
	   toy=new JLabel("Total year :-");

  //textfiedl
 
   stod=new JTextField(25);
   stod.setEnabled(false);
    stom=new JTextField(25);
	stom.setEnabled(false);
	 stoy=new JTextField(25);
	 stoy.setEnabled(false);
   
	  //use JComboBox
	  tday=new JComboBox();
	  for( i=1;i<=31;i++)
	   tday.addItem(i);
	   tmonth=new JComboBox();
	  for( j=0;j<=11;j++)
	    tmonth.addItem(" "+months[j]);

	  tyear=new JComboBox();
       for(k=1991;k<=y;k++)
		   tyear.addItem(" "+k);
	  //button
	  ok=new JButton("OK");
      finish=new JButton("Finish");

	  //setBounds
	  month.setBounds(240,50,50,100);
	  day.setBounds(80,50,30,100);
	  year.setBounds(400,50,50,100);
	  tmonth.setBounds(290,90,100,25);
	  tday.setBounds(120,90,100,25);
	  tyear.setBounds(450,90,100,25);
	  tom.setBounds(100,470,100,25);
	  tod.setBounds(100,500,100,25);
	  toy.setBounds(100,550,100,25);
	 stom.setBounds(180,470,100,25);
	  stod.setBounds(180,500,100,25);
	  stoy.setBounds(180,550,100,25);
	
		ok.setBounds(490,500,100,35);
       finish.setBounds(490,550,100,35);

      //add
	  add(finish);
	  add(ok);
	  add(month);
	  add(day);
	  add(year);
	  add(tday);
	  add(tmonth);
	  add(tyear);
 	  add(tod);
	  add(tom);
	  add(toy);
     add(stod);
	  add(stom);
	  add(stoy);
 
   finish.addActionListener(this);
    ok.addActionListener(this);

	  }

  public void actionPerformed(ActionEvent ae)
	{
		  if(ae.getSource()==finish)
		{ 
			   AdminUse au=new AdminUse("Admin Use");
			   au.setVisible(true);
			   setVisible(false);
		   }
		   if(ae.getSource()==ok)
		   {
			   String a=(String)tday.getSelectedItem();
			  addData(a);
		   }
	   }
	
	  public static void main(String [] args)
	{
		  ViewCanteen vc=new ViewCanteen();
	      vc.setVisible(true);
	 }
public	void  addData(String a)
	{
	
	//		  String b=(String)tmonth.getSelectedItem();
	//		  String c=(String)tyear.getSelectedItem();
//	System.out.println(a+b+c);
		 	  String g="20";  //Integer.parseInt("13");
			  //  int s= 13;// Integer.parseInt("13");
		  try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con=DriverManager.getConnection("Jdbc:Odbc:mcm");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select * from GroceryTotal");
		int i=0;
		String s2=a;
		
		 while(rs.next())
		{     
		//System.out.println("ok1");
		String s=rs.getString(7);
		 if(s2==s)//&&b.startsWith(rs.getString(7))&&c.startsWith(rs.getString(8)))
			{//	System.out.println("ok2");
			   d1[i][0]=rs.getString(1);
				 d1[i][1]=rs.getString(3);
				 i++;
 		     }
		}
System.out.println(d1[0][0]);
	
	   }catch(Exception e)
		{ System.out.println("simple " +e);}

	 
	 }
};