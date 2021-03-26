
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.lang.*;

 class CanteenBill extends JFrame implements ActionListener
{
	JLabel l1,l18,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
 JButton b;
JTable tb;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t11;
	String no,total,type,day,year,month,start,aa,bb,cc,ee,p,q,r,bill;
	 String c1[]={" Index "," Name "," Quantity "," Rate "," Total "};
	String d1[][]=new String[100][5];
	static String aa1,bb1,cc1,dd1;
	int i=0,qun,j1=0,tt;
	String counter;
	 String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
 
		boolean flag=false;
  public  CanteenBill(String d,String e,String f,String g)
	{			
		 super("Canteen Bill ");
		
		  	 setLocation(200,10);
         setSize(590,720);
     setLayout(null);
	 	
		//calender
		 GregorianCalendar gc=new GregorianCalendar();
 day=Integer.toString(gc.get(Calendar.DATE));
 month=months[gc.get(Calendar.MONTH)];
 year=Integer.toString(gc.get(Calendar.YEAR));
	
	no=d;
     total=e;
	 type=f;
	 start=g;
	 System.out.println(no+"\t"+total+"\t"+type+"\t"+start);
	tb=new JTable(d1,c1);	
	    tb.setEnabled(false);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
         add(p);
    	p.setBounds(0,185,580,370);

		  l1=new JLabel(" GROCERY BILL ");
		  l1.setFont(new Font("Arial",0,30));
		  l1.setForeground(Color.BLUE);

		  l2=new JLabel(" 4114 -Southern Command Canteen , Pune ");
		  l2.setFont(new Font("Arial",Font.ITALIC,20));
		  l2.setForeground(Color.BLUE);

		  l3=new JLabel(" SalesPerson  :-");
          l3.setFont(new Font("Arial",Font.BOLD,13));
	  	  l3.setForeground(Color.BLUE);


		  l4=new JLabel(" CTR  No         :-");
          l4.setFont(new Font("Arial",Font.BOLD,13));
   	      l4.setForeground(Color.BLUE);
	  
	     
		  
		  l5=new JLabel(" ---------------------------------------------------------------------------------------------------------------------");
          l5.setFont(new Font("Arial",Font.ITALIC,20));
   	      l5.setForeground(Color.BLUE);

          l6=new JLabel(" Bill No  :-");
          l6.setFont(new Font("Arial",Font.BOLD,13));
	  	  l6.setForeground(Color.BLUE);
  
          l7=new JLabel(" Rank  :-");
          l7.setFont(new Font("Arial",Font.BOLD,13));
	  	  l7.setForeground(Color.BLUE);
	  	 
          l8=new JLabel(" ID   :-");
          l8.setFont(new Font("Arial",Font.BOLD,13));
	  	  l8.setForeground(Color.BLUE);
		 
		  l9=new JLabel(" Name  :-");
          l9.setFont(new Font("Arial",Font.BOLD,13));
	  	  l9.setForeground(Color.BLUE);

	      l10=new JLabel(" ---------------------------------------------------------------------------------------------------------------------");
          l10.setFont(new Font("Arial",Font.ITALIC,20));
   	      l10.setForeground(Color.BLUE);

	      l11=new JLabel(" Type  :-");
          l11.setFont(new Font("Arial",Font.BOLD,13));
	  	  l11.setForeground(Color.BLUE);
 
    	  l12=new JLabel(" Total	QUOTA :-  4000");
          l12.setFont(new Font("Arial",Font.BOLD,13));
	  	  l12.setForeground(Color.BLUE);
	   
		  l13=new JLabel(" ");
          l13.setFont(new Font("Arial",Font.BOLD,13));
	  	  l13.setForeground(Color.BLUE);

          l14=new JLabel(" Total ");
          l14.setFont(new Font("Arial",Font.ITALIC,20));
   	      l14.setForeground(Color.BLUE);

	
          l15=new JLabel(" Goods Sold  Will  Not  Be  Exchanged /  Replaced .");
          l15.setFont(new Font("Arial",Font.BOLD,13));
	  	  l15.setForeground(Color.BLUE);

          l16=new JLabel(" Thank  You -  Visit    Again .");
          l16.setFont(new Font("Arial",Font.BOLD,13));
	  	  l16.setForeground(Color.BLUE);

		  l17=new JLabel(" Total qty .");
          l17.setFont(new Font("Arial",Font.BOLD,13));
	  	  l17.setForeground(Color.BLUE);
             
		  l18=new JLabel(" Round Off :    -- ");
          l18.setFont(new Font("Arial",Font.BOLD,13));
	  	  l18.setForeground(Color.BLUE);

			 t1=new JTextField(25);
			 t1.setEditable(false);
			   t1.setFont(new Font("Arial",Font.BOLD,12));
		 t1.setForeground(Color.BLACK);

			 t2=new JTextField(25);
			 t2.setEditable(false);
			   t2.setFont(new Font("Arial",Font.BOLD,12));
		 t2.setForeground(Color.BLACK);

			 t3=new JTextField(25);
			 t3.setEditable(false);
			   t3.setFont(new Font("Georgia",Font.BOLD,12));
		 t3.setForeground(Color.BLACK);

			  t4=new JTextField(25);
			 t4.setEditable(false);
			   t4.setFont(new Font("Arial",Font.BOLD,12));
		 t4.setForeground(Color.BLACK);

			  t5=new JTextField(25);
			 t5.setEditable(false);
			   t5.setFont(new Font("Georgia",Font.BOLD,12));
		 t5.setForeground(Color.BLACK);

             t6=new JTextField(25);
			 t6.setEditable(false);
			   t6.setFont(new Font("Arial",Font.BOLD,12));
		 t6.setForeground(Color.BLACK);

			 t7=new JTextField(25);
			 t7.setEditable(false);  
			   t7.setFont(new Font("Georgia",Font.BOLD,12));
		 t7.setForeground(Color.BLACK);

			 t8=new JTextField(25);
			 t8.setEditable(false);
			   t8.setFont(new Font("Arial",Font.BOLD,12));
		 t8.setForeground(Color.BLACK);

			 t9=new JTextField(25);
			 t9.setEditable(false);
			   t9.setFont(new Font("Georgia",Font.BOLD,12));
		 t9.setForeground(Color.BLACK);

			  t11=new JTextField(25);
			 t11.setEditable(false);
			   t11.setFont(new Font("Georgia",Font.BOLD,12));
		 t11.setForeground(Color.BLACK);

			 b=new JButton("print ");
         
		 l1.setBounds(130,10,500,30);
		 l2.setBounds(70,40,500,30);
         l3.setBounds(20,70,500,30);
		  t3.setBounds(120,70,100,20);
         l4.setBounds(20,90,500,30);
         t4.setBounds(120,93,100,20);
         l5.setBounds(0,100,680,30);
		 l6.setBounds(390,90,500,30);
		 t6.setBounds(450,90,120,25);
		 l7.setBounds(390,150,500,30);
         t7.setBounds(450,150,120,25);
		 l8.setBounds(10,120,500,30);
		 t8.setBounds(60,120,250,25);
		 l9.setBounds(10,150,500,30);     
		 t9.setBounds(60,150,250,25);     
		 l10.setBounds(0,165,980,30); 
		 l11.setBounds(390,120,500,30);
		 t11.setBounds(450,120,120,25);
		 l12.setBounds(5,575,500,30);
		 l13.setBounds(5,595,500,30);
		 l14.setBounds(395,550,500,30);
		 l15.setBounds(25,620,500,30);
		 l16.setBounds(85,640,500,30);
		  b.setBounds(450,625,100,35);
		  t1.setBounds(460,560,100,35);
		  t2.setBounds(230,560,100,35);
		 l17.setBounds(150,550,500,30);
		 l18.setBounds(395,590,500,30);
		  t5.setBounds(500,600,150,20);
	
	  add(t3);
	    add(t4);
        add(t5);
         add(t6);
           add(t7);
           add(t8);
          add(t9);
		  add(t11);

	  add(l18);
	    add(l17);
		add(t1);
		add(t2);
		add(b);
		add(l14);
		 add(l1);
		 add(l2);
		  add(l3);
         add(l4);
         add(l5);
         add(l6);
         add(l7);
         add(l8);
		  add(l9);
         add(l10);
         add(l11);
		  add(l12);
		   add(l13);
     
           add(l15);
		   add(l16);
		    addData();
		  saveData();
		
	 b.addActionListener(this);
	}

public void actionPerformed(ActionEvent ae)
	{
	 if(ae.getSource()==b)
		{
		 groceryInfo m=new groceryInfo("Canteen Use");
		 m.setVisible(true);
		 setVisible(false);
	        }
      }
		public static void main(String[] args) 
	{
		CanteenBill t=new CanteenBill(aa1,bb1,cc1,dd1);
	    t.setVisible(true);
			//CanteenBill t=new CanteenBill("1","1","1","1");
		//t.setVisible(true);
	
	}
	public void addData()
	{

 try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con=DriverManager.getConnection("Jdbc:Odbc:mcm");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select * from GroceryData");
		try{
					Thread.sleep(1000);
				}catch(Exception e){}

		int j=Integer.parseInt(start);
		 while(rs.next())
		{
            if(j<Integer.parseInt(rs.getString(1)))
			{
				d1[i][0]=rs.getString(3);
				d1[i][1]=rs.getString(4);
				d1[i][2]=rs.getString(5);
				qun=qun+Integer.parseInt(d1[i][2]);
				d1[i][3]=rs.getString(6);
				d1[i][4]=rs.getString(7);
				i++;
				//j++;
				System.out.println("pravin...................................");
			}

				  }


	   }catch(Exception e)
		{ System.out.println("simple " +e);}

  
		Double   a= Double.parseDouble(no);
		  	 try{
					    
						 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from PersonInfo");
			
						 while(rs.next())
					      {
							 String  gs=rs.getString(2);
							
							  if(a==Double.parseDouble(gs))
							 {
								  aa= rs.getString(3);  
								  ee=rs.getString(7);  
					      }
						  }
 		           }catch(Exception e){System.out.println(e);}
		
				   	 try{
					    
						 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from counter");
			
						 while(rs.next())
					      {
							 
								bb= rs.getString(1);  
								  cc=rs.getString(2);  
					    
						  }
 		           }catch(Exception e){System.out.println(e);}
             
				Double dd=Double.parseDouble(total);
				 tt=dd.intValue();
				double s=dd-tt;
				System.out.println(s);
			  t1.setText("  "+Integer.toString(tt)); 
                  t2.setText("   "+Integer.toString(qun));
                  t3.setText("  "+bb);
		           t4.setText("  "+cc);
              t5.setText(" "+s);
                
              t7.setText("    "+ee);
			    t8.setText("  "+no);
			    t9.setText("    "+aa);
                     t11.setText("  "+type);


		  tb=new JTable(d1,c1);	
	    tb.setEnabled(false);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
		 		
         add(p);
 	p.setBounds(0,185,580,370);

	 }

	 public void saveData()
	{


 try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con=DriverManager.getConnection("Jdbc:Odbc:mcm");
		 Statement st=con.createStatement();
		 ResultSet rs=st.executeQuery("Select * from GroceryTotal");
	double t=0.0;
	String a;
		 while(rs.next())
		{     
			    a=rs.getString(1);
				p=rs.getString(7);
				q=rs.getString(8);
				r=rs.getString(9);
				if(p.equals(day)&&q.equals(month)&&r.equals(year))
			    {
                    flag=true;
					j1++;
				 }
				
					
			}

	
	   }catch(Exception e)
		{ System.out.println("simple " +e);}


        if(flag==true)
		{
			bill=Integer.toString(++j1);
		  }else
		  {
			  bill="1";
		   }
		  
		    t6.setText("     "+bill);


		  try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection con=DriverManager.getConnection("Jdbc:Odbc:mcm");
		   PreparedStatement ps=con.prepareStatement("insert into GroceryTotal values(?,?,?,?,?,?,?,?,?); ");
		   ps.setString(1,no);
		   ps.setString(2,cc);
		   ps.setString(3,type);
		    ps.setString(4,Integer.toString(qun));
		   ps.setString(5,bill);
		  ps.setString(6,Integer.toString(tt));
		   ps.setString(7,day);
		  ps.setString(8,month);
		  ps.setString(9,year);
		  ps.executeUpdate();
		    
		  }catch(Exception e){  System.out.println("pravin "+e);}
	  }
}	

