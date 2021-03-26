
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class ViewPersonInfo extends JFrame implements ActionListener
{
	//First form
	JLabel name,middle,bdate,age,sex,vAddr,tal,dist,pin,info;
	JTextField tname,tmiddle,tage,ttal,tpin,tbdate,tsex,trank;
    JTextArea tvAddr;

     //second form
     JLabel ceye,relig,caste,hcms,qulifi,imark,uname,salary;
	JTextField tcaste,trelig,thinch,thcms,timark,tuname,tsalary,hinch,new6;
    JTextArea tqulifi;
	
	 JTable tb;
     String c1[]={"Name  "," Birth Day "," Relationship "};
	String d1[][]=new String[10][3];
	 String data[][]=new String[10][3];

  JTextArea tvAddr1,tvAddr2;
	//form 3
		JLabel new2,new3,new4,new5;
		JButton b1,b2,b3;
   
	  String aa,bb,cc,ee,ff,gg,hh,aa1,bb1,cc1,ee1,ff1,gg1,hh1,aa2,bb2,cc2;
         int dd,dd1;

	
		
	ViewPersonInfo()
	{
        super("View Information");
		setLayout(null);
		setLocation(20,20);
		setSize(950,630);
     getContentPane().setBackground(Color.lightGray);
	 	info=new JLabel("view info",JLabel.LEFT);
        info.setFont(new Font("Arial",Font.ITALIC,20));
	    info.setForeground(Color.BLUE);


	tb=new JTable(d1,c1);	
	    tb.setEnabled(false);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
		 		
         add(p);
    	p.setBounds(360,470,310,120);

     b1=new JButton("OK");
	 b3=new JButton("ok ");
	 b2=new JButton("Print");
		//First form
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

		//second form
	    //label
        ceye=new JLabel("colour of eyes :");
		relig=new JLabel("Religion :");
		caste=new JLabel("caste :");
		hcms=new JLabel("Height :");
		qulifi=new JLabel("Qualification:");
		imark=new JLabel("identification Mark:");
		uname=new JLabel("Last Unit Name  :");
		salary=new JLabel("Last Basic Salary :");
    
 //form
     new2=new JLabel("Maritual Status  : ");
         	
	   new3=new JLabel("Details of family Members ..");
     
    	
		new4=new JLabel("Medals  Others ");
      
		new5=new JLabel("  Other  Country  :-    ");
     
			 		  //TextArea
		tvAddr1=new JTextArea(100,100);
		         tvAddr1.setEditable(false);
	    tvAddr1.setFont(new Font("Georgia",Font.BOLD,12));
		 tvAddr1.setForeground(Color.BLUE);
	  //TextArea
	 	tvAddr2=new JTextArea(100,100);
	     tvAddr2.setEditable(false);
	    tvAddr2.setFont(new Font("Georgia",Font.BOLD,12));
		 tvAddr2.setForeground(Color.BLUE);

	
	   //textfield
		
         tname=new JTextField(25);
		
		 tmiddle=new JTextField(25);
		 tmiddle.setEditable(false);
		 tmiddle.setFont(new Font("Georgia",Font.BOLD,12));
		 tmiddle.setForeground(Color.BLUE);

		 tage=new JTextField(25);
		 tage.setEditable(false);
		 tage.setFont(new Font("Georgia",Font.BOLD,12));
		 tage.setForeground(Color.BLUE);

		 ttal=new JTextField(25);
		 ttal.setEditable(false);
		 ttal.setFont(new Font("Georgia",Font.BOLD,12));
		 ttal.setForeground(Color.BLUE);

		 tpin=new JTextField(25); 
		 tpin.setEditable(false);
		 tpin.setFont(new Font("Georgia",Font.BOLD,12));
		 tpin.setForeground(Color.BLUE);

		 tsex=new JTextField(25);
		 tsex.setEditable(false);
     	 tsex.setFont(new Font("Georgia",Font.BOLD,12));
		 tsex.setForeground(Color.BLUE);

		 tbdate=new JTextField(25); 
		 tbdate.setEditable(false);
		 tbdate.setFont(new Font("Georgia",Font.BOLD,12));
		 tbdate.setForeground(Color.BLUE);

		 trank=new JTextField(25); 
		 trank.setEditable(false);
       	 trank.setFont(new Font("Georgia",Font.BOLD,12));
		 trank.setForeground(Color.BLUE);

		 new6=new JTextField(20);
         new6.setEditable(false);
		 new6.setFont(new Font("convecta",Font.BOLD,15));
		 new6.setForeground(Color.BLUE);
    	
	 	 trelig=new JTextField(25);
		 trelig.setEditable(false);
	  	 trelig.setFont(new Font("Georgia",Font.BOLD,12));
		 trelig.setForeground(Color.BLUE);

		 tcaste=new JTextField(25);
		  tcaste.setEditable(false);
		  tcaste.setFont(new Font("Georgia",Font.BOLD,12));
		 tcaste.setForeground(Color.BLUE);

		 thcms=new JTextField(25);
		 thcms.setEditable(false);
		 thcms.setFont(new Font("Georgia",Font.BOLD,12));
		 thcms.setForeground(Color.BLUE);

		 timark=new JTextField(25);
		 timark.setEditable(false);
		 timark.setFont(new Font("Georgia",Font.BOLD,12));
		 timark.setForeground(Color.BLUE);
		
		 thinch=new JTextField(25);
		 thinch.setEditable(false);
		 thinch.setFont(new Font("Georgia",Font.BOLD,12));
		 thinch.setForeground(Color.BLUE);

		 tuname=new JTextField(25);
		 tuname.setEditable(false);
		 tuname.setFont(new Font("Georgia",Font.BOLD,12));
		 tuname.setForeground(Color.BLUE);

		 tsalary=new JTextField(25); 
		  tsalary.setEditable(false);
		  tsalary.setFont(new Font("Georgia",Font.BOLD,12));
		 tsalary.setForeground(Color.BLUE);
		 
		 //TextArea
		tqulifi=new JTextArea(100,100);
		 tqulifi.setEditable(false);
		 tqulifi.setFont(new Font("Georgia",Font.BOLD,12));
		 tqulifi.setForeground(Color.BLUE);
		 //TextArea
		tvAddr=new JTextArea(100,100);
         tvAddr.setEditable(false);
         tvAddr.setFont(new Font("Georgia",Font.BOLD,12));
		 tvAddr.setForeground(Color.BLUE);

	
		  
		  info.setBounds(100,25,500,20);
	     name.setBounds(30,105,100,20);
         tname.setBounds(130,100,150,35);
         middle.setBounds(30,150,100,20);
         tmiddle.setBounds(125,150,200,35);
         bdate.setBounds(30,200,100,20);
    	  tbdate.setBounds(130,195,100,25);
		  age.setBounds(250,200,40,25);
         tage.setBounds(280,195,40,30);
         sex.setBounds(30,240,100,20);
         tsex.setBounds(130,240,70,25);
         trank.setBounds(130,280,100,25);
		 vAddr.setBounds(30,280,100,20);
		  pin.setBounds(30,345,100,20);
	     tvAddr.setBounds(130,440,150,90);
         tal.setBounds(30,350,100,20);
         ttal.setBounds(130,350,100,25);
		 dist.setBounds(30,435,100,20);
         pin.setBounds(30,315,100,20);
         tpin.setBounds(130,315,100,25);
//second
           ceye.setBounds(380,105,100,20);
      //  tecolor.setBounds(570,100,150,25);
         relig.setBounds(380,155,100,20);
         trelig.setBounds(500,150,100,35);
		 tcaste.setBounds(500,200,100,35);
         caste.setBounds(380,205,100,20);
        // hinch.setBounds(250,250,75,15);
        thinch.setBounds(500,105,100,30);
		 thcms.setBounds(280,240,40,30);
         hcms.setBounds(230,240,100,20);
      //   tsex.setBounds(200,250,70,25);
         qulifi.setBounds(380,250,100,20);
         tqulifi.setBounds(500,250,150,90);
         imark.setBounds(10,395,150,20);
         timark.setBounds(130,390,150,35);
		 // hinch.setBounds(570,430,200,35);
		 uname.setBounds(380,360,150,20);
         tuname.setBounds(500,360,150,35);
		 salary.setBounds(380,410,150,20);
         tsalary.setBounds(500,405,150,35);
            new6.setBounds(800,105,100,35);

		   //from3
	      new2.setBounds(700,105,190,25);
		 new3.setBounds(360,440,200,25);
		 new4.setBounds(700,120,360,50);
		 new5.setBounds(700,300,360,50);
		  tvAddr1.setBounds(700,170,200,90);
		 tvAddr2.setBounds(700,350,200,90);
		 		 b1.setBounds(700,510,100,45);		
				 b2.setBounds(820,510,100,45);
	             b3.setBounds(290,100,50,35);
	
		  //addItem
		  	 add(info);

    
		  add(b1);
		  add(b2);
		  add(b3);

        add(name);
		add(middle);
		add(bdate);
		add(age);
		add(sex);
		add(vAddr);
		add(tal);
		add(dist);
		add(pin);
		add(tname);
		add(tmiddle);
		add(tage);
		add(ttal);
		add(tpin);
		add(tbdate);
		add(tsex);
		add( tvAddr);
		add(trank);

		//second
     add(ceye);
	//	 add(tecolor);
		 add(relig);
		 add(trelig);
		 add(tcaste);
		 add(caste);
		 //add(hinch);
		 add(thinch);
		 add(thcms);
		 add(hcms);
		// add(tsex);
		 add(qulifi);
		 add(tqulifi);
		 add(imark);
		 add(timark);
		 add(uname);
		 add(tuname);
	     add(salary);
		 add(tsalary);

//form3
	    add(new2);
		 add(new3);
		 add(new4);
		 add(new5);
	  add(new6);
    	add( tvAddr1);	add( tvAddr2);
          
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
      }
	  public void actionPerformed(ActionEvent ae)
	{
		  if(ae.getSource()==b1)
		{
			  AdminUse ad=new AdminUse("Admin Use");
			 setVisible(false);
			  ad.setVisible(true);
		   }
		   if(ae.getSource()==b3)
		{
               first();
			   second();
			   third();
			   family();
			 
	   }
		}
	public static void main(String[] args) 
	{
	   ViewPersonInfo t=new ViewPersonInfo();
			t.setVisible(true);
	}
		public void first()
	{
			
                     Double   a= Double.parseDouble(tname.getText());
              
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
								  bb=rs.getString(4); 
								  cc=rs.getString(5);
								  dd=rs.getInt(6); 
								  ee=rs.getString(7);  
								  ff=rs.getString(8); 
							    gg=rs.getString(9); 
							    hh=rs.getString(10);
							    }
						  }
 		           }catch(Exception e){}

               tmiddle.setText(aa);
		  tbdate.setText(bb);
		  tsex.setText(cc);
		 tage.setText(Integer.toString(dd));
		  ttal.setText(ff);
		  tpin.setText(gg);
		  trank.setText(ee);
		  tvAddr.setText(hh);

		   }
		   public void second()
	        {

		            Double   a= Double.parseDouble(tname.getText());
         
				 try{
					    
						 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from PersonInfo2");
						 while(rs.next())
					      {
							 String  gs=rs.getString(2);
						
							  if( a==Double.parseDouble(gs))
							  {
								  aa1= rs.getString(3);  
								  bb1=rs.getString(4); 
								  cc1=rs.getString(5);
								  dd1=rs.getInt(6); 
								  ee1=rs.getString(7);  
								  ff1=rs.getString(8); 
							    gg1=rs.getString(9); 
							    hh1=rs.getString(10);
							    }
						  }
 		           }catch(Exception e){}


            thinch.setText(aa1);
		 trelig.setText(bb1);
		    tcaste.setText(cc1);
		   thcms. setText(Integer.toString(dd1));
		   timark.setText(ff1);
		 tuname.setText(gg1);
		 tsalary.setText(hh1);
		    tqulifi.setText(ee1);

		     }
		   public void third()
			{
			               Double   a= Double.parseDouble(tname.getText());
             
				 try{
					    
						 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from PersonInfo3");
						 while(rs.next())
					      {
							 String  gs=rs.getString(2);
							 if( a==Double.parseDouble(gs))
							  {
								  aa2= rs.getString(3);  
								  bb2=rs.getString(4); 
								  cc2=rs.getString(5);
							
							    }
						  }
 		           }catch(Exception e){}
            new6.setText(aa2);	
			tvAddr1.setText(bb2);
		    tvAddr2.setText(cc2);
		   }


 public void family()
	{
	        Double   a= Double.parseDouble(tname.getText());
try
		{
			
		                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						 Connection con=DriverManager.getConnection("jdbc:odbc:mcm");
						 Statement st=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from Family");
			
			int i=0;
		
			while(rs.next())
			{
				String  gs=rs.getString(1);
			 if( a==Double.parseDouble(gs))
				{
		  		data[i][0]=rs.getString(2);
		  		data[i][1]=rs.getString(3);
		  		data[i][2]=rs.getString(4);
		  		 i++;
			  	}
			}
		
		}	
		catch(Exception e)
		{
		
        }

    	tb=new JTable(data,c1);	
	    tb.setEnabled(false);
	
	   int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		
	     JScrollPane p=new JScrollPane(tb,v,h);
		 		
         add(p);
    	p.setBounds(360,470,310,120);
		
	}
}
