import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;


class groceryInfo  extends JFrame  implements ActionListener,ItemListener,TextListener  
	{
 JLabel dname,dn,dn1,rollno,no,name,rank,type,bname,cat,total,rate,qty;
 JTextField trollno,tcat,ttotal,t1,t2,t3;
 TextField tqty,trate;
 JComboBox tbname,ttype;
 JButton ok,finish,cancel,press;


	JTable tb;
	
	final String c1[]={" Index "," Name "," Quantity "," Rate "," Total "};
	 String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
 
    String data[][]=new String[150][5];
	   String datas[][]=new String[150][5];
  	String gs[]=new String[150];
   String aa,bb,kk,gg,start,day,month,year,roll;
 int i=0,j=0;

Double s;

 public groceryInfo (String s)
 {
 
   super(s);
 
  setLocation(100,20);
  setLayout(null);
  setSize(850,680);
   
		 	
			//calender
		 GregorianCalendar gc=new GregorianCalendar();
 day=Integer.toString(gc.get(Calendar.DATE));
 month=months[gc.get(Calendar.MONTH)];
 year=Integer.toString(gc.get(Calendar.YEAR));
	
	
		tb=new JTable(data,c1);	
	    tb.setEnabled(true);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	    JScrollPane p=new JScrollPane(tb,v,h);
         add(p);
    	p.setBounds(20,350,700,250);

   
  dname=new JLabel("GROCERY BILLING",JLabel.CENTER);
  dname.setForeground(Color.RED);
  dname.setFont(new Font("Arial",Font.BOLD,25));
  dn=new JLabel(" 4114-Southern Command ",JLabel.CENTER);
  dn.setForeground(Color.BLUE);
  dn.setFont(new Font("Arial",Font.PLAIN,18));
  
  dn1=new JLabel(" Canteen  - Pune",JLabel.CENTER);
  dn1.setForeground(Color.BLUE);
  dn1.setFont(new Font("Arial",Font.PLAIN,18));

  no=new JLabel("No    : -",JLabel.CENTER);
  no.setForeground(Color.BLUE);
  no.setFont(new Font("Arial",Font.PLAIN,18));
 
  name=new JLabel("Name : - ",JLabel.CENTER);
  name.setForeground(Color.BLUE);
  name.setFont(new Font("Arial",Font.PLAIN,18));

  rank=new JLabel(" Rank :- ",JLabel.CENTER);
  rank.setForeground(Color.BLUE);
  rank.setFont(new Font("Arial",Font.PLAIN,18));

  type=new JLabel("Type :-",JLabel.CENTER);
  type.setForeground(Color.BLUE);
  type.setFont(new Font("Arial",Font.PLAIN,18));
 
  rollno=new JLabel("Icard  N0  :-");
  rollno.setFont(new Font("Arial",Font.BOLD,18));
  rollno.setForeground(Color.BLUE);

  trollno=new JTextField(40);
  

  cat=new JLabel("Index No");
  cat.setFont(new Font("Arial",Font.BOLD,15));
  cat.setForeground(Color.BLUE);
  bname=new JLabel("Name");
  bname.setFont(new Font("Arial",Font.BOLD,15));
  bname.setForeground(Color.BLUE);
  qty=new JLabel("Quantity");
  qty.setFont(new Font("Arial",Font.BOLD,15));
  qty.setForeground(Color.BLUE);
  rate=new JLabel("Rate");
  rate.setFont(new Font("Arial",Font.BOLD,15));
  rate.setForeground(Color.BLUE);
  total=new JLabel("Total");
  total.setFont(new Font("Arial",Font.BOLD,15));
  total.setForeground(Color.BLUE);
 
  ok=new JButton("Total");
  ok.setFont(new Font("Arial",Font.BOLD,15));
  ok.setForeground(Color.BLUE);
 
   finish=new JButton("Finish");
  finish.setFont(new Font("Arial",Font.BOLD,15));
  finish.setForeground(Color.BLUE);

  cancel=new JButton("Cancel");
  cancel.setFont(new Font("Arial",Font.BOLD,15));
  cancel.setForeground(Color.BLUE);
 
  press=new JButton("press");
  press.setFont(new Font("Arial",Font.BOLD,15));
  press.setForeground(Color.BLUE);
 

 tqty=new TextField(30);
 tqty.setText("1");
  tqty.setEditable(false);
  trate=new TextField(30);
   trate.setEditable(false);
  ttotal=new JTextField(30);
  t1=new JTextField(30);
  t1.setEditable(false);
  t2=new JTextField(30);
  t2.setEditable(false);
  t3=new JTextField(30);
  t3.setEditable(false);
 
  tcat=new JTextField();
  tcat.setEditable(false);
   addData();
  
  tbname=new JComboBox();
  tbname.disable();
  tbname.addItem(" ");
 
  for(int j=0;j<150;j++)
   tbname.addItem(gs[j]);
  
  ttype=new JComboBox();
  ttype.disable();
  ttype.addItem(" ");
  ttype.addItem(" SELF");
  ttype.addItem(" WIFE ");
  ttype.addItem("  SON");
  
 
 dname.setBounds(270,30,280,30);
 dn.setBounds(310,70,220,30);
 dn1.setBounds(310,100,200,30);
 
  rollno.setBounds(50,150,100,30);
  trollno.setBounds(170,150,140,30);
 
 no.setBounds(430,150,100,30);
 t1.setBounds(520,150,170,25);
 
 name.setBounds(430,190,100,30);
 t2.setBounds(520,190,170,25);
 
 rank.setBounds(430,230,100,30);
  t3.setBounds(520,230,170,25);
 
type.setBounds(60,200,100,30);
 ttype.setBounds(170,205,120,25);
  
  cat.setBounds(250,270,70,30);
  bname.setBounds(50,270,70,30);
  qty.setBounds(400,270,70,30);
  rate.setBounds(500,270,70,30);
  total.setBounds(600,270,70,30);
 
  tbname.setBounds(50,300,180,25);
  tcat.setBounds(250,300,100,25);
 

  tqty.setBounds(400,300,70,25);
  trate.setBounds(500,300,70,25);
  ttotal.setBounds(600,300,100,25);
  ok.setBounds(710,270,70,50);
   press.setBounds(320,150,40,30);

 finish.setBounds(730,480,90,50);
 cancel.setBounds(730,550,90,50);


 
 

add(dname);
add(dn);
add(dn1);
add(rollno);
add(trollno);
add(no);
add(press);
add(name);
add(t1);
add(t2);
add(t3);
add(rank);

add(type);
add(ttype);
  add(cat);
  add(bname);
  add(qty);
  add(rate);
  add(total);

 add(tqty);
  add(trate);
  add(ttotal);

  add(tbname);
  add(tcat);
  add(ok);
    add(finish);
  add(cancel);

 cancel.addActionListener(this);
 finish.addActionListener(this);
 ok.addActionListener(this);
  press.addActionListener(this);

    tbname.addItemListener(this);
      tqty.addTextListener(this);  
	     trate.addTextListener(this);  

		
 }

   	public void itemStateChanged(ItemEvent te) 
	     {
          if(te.getSource()==tbname)
			 {
	        
		        try{	
		       
			            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from RetailData");
						  String ff=(String)tbname.getSelectedItem();
					
						 while(rs.next())
					      {
							 if(ff.equals(rs.getString(2)))
						      {
								
								 kk=rs.getString(1);
						       gg=rs.getString(3);
									break;
								  }						
							  }
					tcat.setText(kk);
							  trate.setText(gg);
							
	            }     
	        catch(Exception se)
	       	 {
		     System.out.println(se);
	         }
			
			 }
		 }

 public void textChanged(TextEvent te){}
 
 public void textValueChanged(TextEvent te)
 {
	 if(te.getSource()==tqty)
	 {
			 	Double d2,d3;
		int d1;
		   String aa=tqty.getText();
		   String bb=trate.getText();
        if(bb.equals("")||aa.equals(""))
			 { System.out.println("h");}
		else{
			 d1=Integer.parseInt(aa);
		      d2=Double.valueOf(bb);
		   d3=d1*d2;
           ttotal.setText(Double.toString(d3));
		     }
		
	 }
	 if(te.getSource()==trate)
	 {
		 
				 Double d2,d3;
		int d1;
	   String aa=tqty.getText();
		   String bb=trate.getText();
        if(bb.equals("")||aa.equals(""))
			 {System.out.println("ch");}
		else{
			d1=Integer.parseInt(aa);
		      d2=Double.valueOf(bb);
           
		   d3=d1*d2;
           ttotal.setText(Double.toString(d3));
		}
		
	   }
 }
 public void actionPerformed(ActionEvent ae)
	{
  	     if(ae.getActionCommand()=="Cancel")
		{
		 MainFrame mf=new MainFrame();
			setVisible(false); 
		    			mf.setVisible(true);
	      }else
		if(ae.getActionCommand()=="Finish")
		 { 
			  Double add=0.0;
		     for(int j=0;j<150;j++)
		    { 
			 			
		   if(data[j][4]==null)
			  break;

         Double  total= Double.valueOf(data[j][4]);
		  add=add+total;
		  System.out.println(add);
		 }
			  
               
			    String no=t1.getText();
			   String type=(String)ttype.getSelectedItem();
			   String a=Double.toString(add);
			    s= checkTotal();
			    s=s+add;
			 System.out.println("s"+s);
			   if( s<=4000.0)
			  {
				    Bill();

			   CanteenBill cb=new CanteenBill(no,a,type,start);
			   setVisible(false);
			   try{
					Thread.sleep(500);
				}catch(Exception e){}
		  
			   cb.setVisible(true);
			  }else
			  {
			      JOptionPane.showMessageDialog(null,"  Card Limit Over ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
         for(int i=0;i<150;i++)
				  {
			   for(int j=0;j<5;j++)
				  {
			          data[i][j]=null;
				  }
				  }
                   tbname.setSelectedItem(" ");
				   tbname.disable();
				   trate.setText(" ");
				  // tqty.setText(" ");
				   ttotal.setText(" ");
			   trate.setEditable(false);
			      t1.setText(" ");
				     t2.setText(" ");
					    t3.setText(" ");
						 tcat.setText(" ");
						    ttype.setSelectedItem(" ");
						   ttype.disable();
			 tqty.setEditable(false);
			 tb=new JTable(data,c1);		                    
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	   JScrollPane p=new JScrollPane(tb,v,h);
 	 add(p);
 	p.setBounds(20,350,700,250);

				
			   }
			      s=00000.0;
			 
		   }if(ae.getActionCommand()=="Total")
		 { 
			   int t=Integer.parseInt(tqty.getText());
			   if(t<=10)
			 { 	   add();
			 }else {
			               JOptionPane.showMessageDialog(null," Quantity  not allow more than 10 ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
			             }
		   }if(ae.getSource()==press)
		  {
			  
			   t1.setText("");  t2.setText("");  t3.setText("");
			 
			   s= checkTotal();
	System.out.println("KK"+s);
			  if( s<=4000.0)
			  {
			   first();
			
			  }else
			  {
			      JOptionPane.showMessageDialog(null,"  Card Limit Over ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
                   tbname.disable();      
				     ttype.disable();
					  trate.setEditable(false);  tqty.setEditable(false);
			   }
			      s=00000.0;

		   }
  
   }
 public static void main(String args[])
 {
 groceryInfo s1=new groceryInfo("Canteen Use");
  s1.setVisible(true);
 }
public Double checkTotal()
		{

	  Double t=0.0;
	     roll= trollno.getText();
        try{

	         	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
			
	                    Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from GroceryTotal");
	
						 while(rs.next())
					      {
							 if(roll.equals(rs.getString(1)))
							  {
							  if(month.equals(rs.getString(8)))
							  {
								 
                                  t=t+Double.parseDouble(rs.getString(6));
							  }
							  }
							  
						  }	
						  
						
					  }
 	                   catch(Exception e){ System.out.println(e);}
     return t;
           }


public void Bill()
		{

	 try{

	         	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
			
	                    Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select max(ano) from GroceryData");
						 while(rs.next())
					      {
							   start=rs.getString(1);
			    		  }
 	 
					System.out.println("statrt  "+start);			
           
           int j1=Integer.parseInt(start);
         String qry = "insert into GroceryData values (?,?,?,?,?,?,?)";
     j1++;
      PreparedStatement   ps = con.prepareStatement(qry);
    
				
			   	String d1[][]=new String[1][5];	
         for(int j=0;j<150;j++)
		{ 
			  int i=0;
			
		   if(data[j][i]==null)
			  break;
		
		   int k=0,l=0;

		 for ( i=0; i<5; i++,l++)
        {    
               d1[k][l]= data[j][i];

		}
			//try{
			////		Thread.sleep(1000);
			//	}catch(Exception e){}
		       ps.setString(1,Integer.toString(j1));
			
			   ps.setString(2,t1.getText());
			    
			   ps.setString(3,d1[0][0]);
			    
			   ps.setString(4,d1[0][1]);
			   
		       ps.setString(5,d1[0][2]);
			   
	           ps.setString(6,d1[0][3]);
			
		       ps.setString(7,d1[0][4]);
			   
	     	    ps.executeUpdate();
			
				j1++;
                  
			 
		}

	  
   
	        }catch(Exception e){  System.out.println("j  "+e);}

		  }
public void add()
		{
	      
	        	data[j][0]=tcat.getText();
		  		data[j][1]=(String)tbname.getSelectedItem();
		  		data[j][2]=tqty.getText();
                data[j][3]=trate.getText();
            	data[j][4]=ttotal.getText();
			
			//	tcat.setText(" ");
		  		//tbname.setSelectedItem(" ");
		  		//tqty.setText(" ");
             //   trate.setText(" ");
            	//ttotal.setText(" ");
         
			tb=new JTable(data,c1);	
	        tb.setEnabled(true);
	
	       int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	    	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
         add(p);
    	p.setBounds(20,350,700,250);	
			j++;
            
				
          }
 public void addData()
		{
	
	 try{

	         	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from RetailData");
						 while(rs.next())
					      {
							  gs[i]=rs.getString(2);
									i++;	
			    		  }
 	 

	        }catch(Exception e){  System.out.println(e);}

       }
 		public void first()
	{
			int flag=0;
		
                     Double   a= Double.parseDouble(trollno.getText());
              
				 try{
					    
						 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from PersonInfo");
						 while(rs.next())
					      {
							 String  gs=rs.getString(2);
							
							  if( a==Double.parseDouble(gs))
							  { 
								  
								  aa= rs.getString(3);  
							     bb=rs.getString(7);  
								  	  flag=1;
									}
						  }
								
	
 		           }catch(Exception e){}
				
  	     		if(flag==1)
			         {
					       ttype.enable();
                            roll=trollno.getText();
						   	 t1.setText(roll);
 			                     t2.setText(aa);
                    		      t3.setText(bb);
								    trollno.setText(""); 
						 String g=(String)ttype.getSelectedItem();
					
				             	tbname.enable();			   
						    	 tqty.setEditable(true);
							   trate.setEditable(true);
					 }
					 else {					      JOptionPane.showMessageDialog(null," Inserted Wrong Number ","ERROR",JOptionPane.INFORMATION_MESSAGE); 
		 }
       }


	}