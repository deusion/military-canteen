import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


class wineInfo  extends JFrame implements ActionListener,ItemListener,TextListener
	{
 JLabel img1,img2,dname,dn,dn1,rollno,no,name,rank,type,bname,cat,total,rate,qty;
 JTextField trollno,tcat,ttotal,tno,tname,trank;
 JComboBox tbname,ttype;
 JButton ok, finish,cancel,press;

 TextField tqty,trate;
	JTable tb;
	
	final String c1[]={" Index "," Name "," Quantity "," Rate "," Total "};
  String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
 

	String d1[][]=new String[50][5];
		String gs[]=new String[50];
String aa,bb,kk,gg,start,day,month,year,roll,cno,scounter;
 int i=0,j=0,g=0,tt=0;
  private Statement st;
  private Connection con;
// final String counter;
  Double a;
   public wineInfo (String s)
 {
 
super(s); 
  setLocation(100,20);
  setLayout(null);
  setSize(830,670);

 scounter=s;

			//calender
		 GregorianCalendar gc=new GregorianCalendar();
 day=Integer.toString(gc.get(Calendar.DATE));
 month=months[gc.get(Calendar.MONTH)];
 year=Integer.toString(gc.get(Calendar.YEAR));
	
		
		tb=new JTable(d1,c1);	
	    tb.setEnabled(true);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
         add(p);
    	p.setBounds(20,460,650,170);

   
  dname=new JLabel("LIQUOR BILLING",JLabel.CENTER);
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
  tno=new JTextField(40);
  tno.setEditable(false);
  tname=new JTextField(40);
  tname.setEditable(false);
  trank=new JTextField(40);
  trank.setEditable(false);
  
//img
   img1=new JLabel();
  img1.setIcon(new ImageIcon("sup1.jpg"));
  img2=new JLabel();
  img2.setIcon(new ImageIcon("sup2.jpg"));

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
 
  press=new JButton("Press");
  press.setFont(new Font("Arial",Font.BOLD,15));
  press.setForeground(Color.BLUE);
 

   tqty=new TextField(30);
  tqty.setEditable(false);
  trate=new TextField(30);
    trate.setEditable(false);
  tqty.setText("1");
  ttotal=new JTextField(30);
 
  tcat=new JTextField();
  tcat.setEditable(false);
 tbname=new JComboBox();
 tbname.addItem(" ");
   addData();
    for(int j=0;j<50;j++)
   tbname.addItem(gs[j]);
	tbname.disable();
  
  ttype=new JComboBox();
  ttype.setEditable(false);
  ttype.addItem(" ");
  ttype.addItem(" SELF");
  ttype.addItem(" WIFE ");
  ttype.addItem("  SON");
  ttype.disable();

  


 img1.setBounds(0,5,220,380);
 img2.setBounds(600,5,220,380);

 dname.setBounds(270,30,280,30);
 dn.setBounds(310,70,220,30);
 dn1.setBounds(310,100,200,30);
 
  rollno.setBounds(250,310,100,30);
  trollno.setBounds(355,310,140,30);
  press.setBounds(500,310,80,30);
 
 no.setBounds(250,150,100,30);
 tno.setBounds(335,148,220,28);
 name.setBounds(250,180,100,30);
 tname.setBounds(335,180,220,28);
 rank.setBounds(250,210,100,30);
 trank.setBounds(335,215,220,28);
type.setBounds(250,240,100,30);
 ttype.setBounds(360,250,100,20);
  
  cat.setBounds(250,390,70,30);
  bname.setBounds(50,390,70,30);
  qty.setBounds(400,390,70,30);
  rate.setBounds(500,390,70,30);
  total.setBounds(600,390,70,30);
 
  tbname.setBounds(50,420,180,25);
  tcat.setBounds(250,420,100,25);
  //c2.setBounds(380,420,70,25);

  tqty.setBounds(400,420,70,25);
  trate.setBounds(500,420,70,25);
  ttotal.setBounds(600,420,100,25);
  ok.setBounds(710,400,70,50);
   finish.setBounds(710,480,90,50);
	 cancel.setBounds(710,550,90,50);


 
 
add(press);
add(img1);
add(img2);
add(dname);
add(dn);
add(dn1);
add(rollno);
add(trollno);
add(no);
add(tno);
add(name);
add(tname);
add(rank);
add(trank);
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

 
  finish.addActionListener(this);
  cancel.addActionListener(this);
  press.addActionListener(this);
  ok.addActionListener(this);

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
						 ResultSet rs=st.executeQuery("select * from WineRate");
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
     if(ae.getSource()==finish)
		{  
		   
		   
		   Double add=0.0;
		 for(int j=0;j<50;j++)
		    { 
			 			
		   if(d1[j][4]==null)
			  break;

         Double  totals= Double.valueOf(d1[j][4]);
		  add=add+totals;
		
			}    
			
				//String nos=tno.getText();
			   //String type=(String)ttype.getSelectedItem();
			 //  String a=Double.toString(add);
			   
			   //				   if( s<=4000.0)
			//  {*/
		                  String   c=Bill();
						  String type=(String)ttype.getSelectedItem();
		System.out.println(c);
		                 WineBill  we=new WineBill(cno,type);
		                setVisible(false);
		                we.setVisible(true);
        // }
	      }else if(ae.getSource()==ok)
		{
                
			 //String  s1=trank.getText();
			     
				String s1="Naik";
		//		if(bb.startsWith("Naik"))
		//	  {
				
			 	int  st=Integer.parseInt(tqty.getText());
		
						 System.out.println(g+"        "+st);
					 if(st<=8&&g+st<=8)
			          {
			             addTable();
                       	       g=g+st;   
					    }else{
							           	 JOptionPane.showMessageDialog(null,"Cross The Limit (Limit =8) ","ERROR",JOptionPane.INFORMATION_MESSAGE);

						           }
		//	  }
			
		
		   }else if(ae.getSource()==cancel)
		   {
			   MainFrame  mf=new MainFrame();
			   setVisible(false);
			   mf.setVisible(true);

		    }else if(ae.getSource()==press)
		      {
					tbname.setSelectedItem(" ");
					ttype.setSelectedItem(" ");
				 tno.setText(" ");
                   tname.setText(" ");
                    trank.setText(" ");
                    tcat.setText(" ");
					trate.setText("1");
					ttotal.setText(" ");
				
				 String g=trollno.getText();
				
                      first();

  	 	    	}
 }
 public static void main(String args[])
 {
 wineInfo s1=new wineInfo("counter");
  s1.setVisible(true);
 }


 public String Bill()
		{

	         try{

	         	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
			
	                    Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from WineData");
						 while(rs.next())
					      {
							   start=rs.getString(1);
			    		  }
 	 
								
       cno=start;
           int j1=Integer.parseInt(start);
         String qry = "insert into WineData values (?,?,?,?,?,?,?,?,?,?)";
     j1++;
      PreparedStatement   ps = con.prepareStatement(qry);
    
				
			   	String d2[][]=new String[1][5];	
      
		 for(int j=0;j<50;j++)
		{ 
			  int i=0;
			
		   if(d1[j][i]==null)
			  break;
		
		   int k=0,l=0;

		 for ( i=0; i<5; i++,l++)
        {    
               d2[k][l]= d1[j][i];

		}
			/*try{
					Thread.sleep(1000);
				}catch(Exception e){}
		      */ 
			   ps.setString(1,Integer.toString(j1));
			System.out.println("s");
			   ps.setString(2,tno.getText());
			    		System.out.println("s");
			   ps.setString(3,d2[0][0]);
			    		System.out.println("s");
			   ps.setString(4,d2[0][1]);
			   		System.out.println("s");
		       ps.setString(5,d2[0][2]);
			   		System.out.println("s");
	           ps.setString(6,d2[0][3]);
					System.out.println("s");
		       ps.setString(7,d2[0][4]);
			   		System.out.println("s");
			   ps.setString(8,day);
			   		System.out.println("s");
               ps.setString(9,month);
			   		System.out.println("s");
               ps.setString(10,year);
			   		System.out.println("sbhb");
			   	     	    ps.executeUpdate();
					System.out.println("sbb");
				j1++;
                  
			 
		}

	  
        }catch(Exception e){  System.out.println("j  "+ e);}

	
	 return cno;
  }
 		public void first()
	{
			int flag=0,flags=0;
		
                        a= Double.parseDouble(trollno.getText());
              
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
					       int kks=countCheck();
					     System.out.println("g"+kks);
						  if(kks<9)
						 {
							  ttype.enable();
                            roll=trollno.getText();
						   	 tno.setText(roll);
 			                     tname.setText(aa);
                    		      trank.setText(bb);
								    trollno.setText(""); 
						 String g=(String)ttype.getSelectedItem();
					
				             	tbname.enable();			   
						    	 tqty.setEditable(true);
							   trate.setEditable(true);
						 }else {
 	            	 				JOptionPane.showMessageDialog(null,"Your Month Stock  finished ","ERROR",JOptionPane.INFORMATION_MESSAGE);
						 }

					 }else {
	            	 				JOptionPane.showMessageDialog(null,"Your number not found","ERROR",JOptionPane.INFORMATION_MESSAGE);
                                    trollno.setText("");
					              }
	}
//check month

public int countCheck()
		{
 try{
					
				String st1;
						 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from WineData");
						 while(rs.next())
					      {
							 String  gs=rs.getString(2);
							
							  if( gs.equals(trollno.getText()))
							  { 
						
								  if(month.equals(rs.getString(9)))
								  {
									  
								      st1= rs.getString(5);  
							          tt=tt+Integer.parseInt(st1);   
								  	  
									}
						    }
								
						  }
 		           }catch(Exception e){}
  	     		
  return tt;
 }

      



 public void addData()
		{
	
	 try{

	         	 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from WineRate");
						 while(rs.next())
					      {
							  gs[i]=rs.getString(2);
									i++;	
			    		  }
 	 

	        }catch(Exception e){  System.out.println(e);}

       }

  public void addTable()
		{
        	d1[j][0]=tcat.getText();
		  		d1[j][1]=(String)tbname.getSelectedItem();
		  		d1[j][2]=tqty.getText();
                d1[j][3]=trate.getText();
            	d1[j][4]=ttotal.getText();

			//	tcat.setText(" ");
		  		//tbname.setSelectedItem(" ");
		  		//tqty.setText(" ");
             //   trate.setText(" ");
            	//ttotal.setText(" ");
         
			tb=new JTable(d1,c1);	
	        tb.setEnabled(true);
	
	       int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
	    	int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
         add(p);
	p.setBounds(20,460,650,170);	
			j++;
            
				
         }
}


