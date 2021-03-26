
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class PersonInfo2 extends JFrame implements ActionListener
	{
	JLabel new1,new2,ceye,relig,caste,hinch,hcms,qulifi,imark,uname,salary;
	JTextField tcaste,trelig,thinch,thcms,timark,tuname,tsalary;
	JButton ok;
    JTextArea tqulifi;
	JComboBox tecolor;
  static String s1;

	    //sql
  private PreparedStatement ps;
  private Statement st;
  private Connection con;

   int gs;
	String ss;
	 PersonInfo2(String s)
	{			
		 super("seond Information");
		 ss=s;
		setLayout(null);
         setLocation(200,20);
        
        new1=new JLabel("SECOND  FORM ....",JLabel.LEFT);
        new1.setFont(new Font("Arial",Font.ITALIC,20));
		new1.setForeground(Color.BLUE);

	    new2=new JLabel("Insert   Information");
        new2.setFont(new Font("convecta",Font.BOLD,16));
		new2.setForeground(Color.BLUE);
       
		
	
		
		
		//label
        ceye=new JLabel("colour of eyes :");
		relig=new JLabel("Religion :");
		caste=new JLabel("caste :");
		hinch=new JLabel("Height inch :");
		hcms=new JLabel("Height :");
		qulifi=new JLabel("Qualification:");
		imark=new JLabel("identification Mark:");
		uname=new JLabel("Last Unit Name  :");
		salary=new JLabel("Last Basic Salary :");
        
		//textfield
		
       tecolor=new JComboBox();
		tecolor.addItem(" ");
       tecolor.addItem(" BLACK ");
       tecolor.addItem(" WHITE");

		 trelig=new JTextField(25);
		  trelig.setForeground(Color.BLACK);
		  trelig.setFont(new Font("Arial",Font.PLAIN,18));
		 tcaste=new JTextField(25);
		   tcaste.setForeground(Color.BLACK);
		   tcaste.setFont(new Font("Arial",Font.PLAIN,18));
		thinch=new JTextField(25);
		 thinch.setForeground(Color.BLACK);
		  thinch.setFont(new Font("Arial",Font.PLAIN,18));
        thcms=new JTextField(25);
		 thcms.setForeground(Color.BLACK);
		  thcms.setFont(new Font("Arial",Font.PLAIN,18));
		 timark=new JTextField(25);
		  		 timark.setForeground(Color.BLACK);
		   		 timark.setFont(new Font("Arial",Font.PLAIN,18));
		 tuname=new JTextField(25);
		  tuname.setForeground(Color.BLACK);
		   tuname.setFont(new Font("Arial",Font.PLAIN,18));
         tsalary=new JTextField(25); 
		  tsalary.setForeground(Color.BLACK);
		   tsalary.setFont(new Font("Arial",Font.PLAIN,18));
			 
		 //TextArea
		tqulifi=new JTextArea(100,100);
				  tqulifi.setForeground(Color.BLACK);
		   tqulifi.setFont(new Font("Arial",Font.PLAIN,18));

		 //button

		 ok=new JButton("NEXT");
		 
       
		 //bounds
		  new1.setBounds(100,25,500,20);
		 new2.setBounds(120,60,500,20);
         ceye.setBounds(70,105,100,20);
        tecolor.setBounds(170,100,150,25);
         relig.setBounds(70,155,100,20);
         trelig.setBounds(170,150,200,35);
		 tcaste.setBounds(170,200,200,35);
         caste.setBounds(70,205,100,20);
         hinch.setBounds(250,250,75,15);
        thinch.setBounds(330,250,60,30);
		 thcms.setBounds(170,250,60,30);
         hcms.setBounds(70,255,100,20);
      //   tsex.setBounds(200,250,70,25);
         qulifi.setBounds(70,305,100,20);
         tqulifi.setBounds(170,300,200,90);
         imark.setBounds(50,405,150,20);
         timark.setBounds(170,400,200,35);
		 uname.setBounds(60,455,150,20);
         tuname.setBounds(170,450,200,35);
		 salary.setBounds(60,505,150,20);
         tsalary.setBounds(170,500,200,35);
         ok.setBounds(150,550,90,35);
		           
		 //addItem
		 add(new1);
		 add(new2);
         add(ceye);
		 add(tecolor);
		 add(relig);
		 add(trelig);
		 add(tcaste);
		 add(caste);
		 add(hinch);
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
		 add(ok);
		 
	   
          setSize(500,630);
        ok.addActionListener(this);
    
	}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==ok)
			{
            String no=ss; 
			String aa=(String)tecolor.getSelectedItem();	
 	       	String bb=trelig.getText();
			String cc=tcaste.getText();
           String dd=thinch.getText();
            String ee=thcms.getText();
            String ff=tqulifi.getText();
			 String gg=	timark.getText();
			 String hh=tsalary.getText();
			 String ii=tuname.getText();
             if(aa.equals(" "))
				{
       	   JOptionPane.showMessageDialog(null,"Please Enter Color of eyes ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(bb.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Religon ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(cc.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Caste ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(dd.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Height ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(ee.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Height ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(ff.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter  qualification ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(gg.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter identication mark ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(hh.equals(""))
				{
       	 JOptionPane.showMessageDialog(null,"Please Enter Last unit  ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	if(ii.equals(""))
				{
       	            JOptionPane.showMessageDialog(null,"Please Enter Last Salary  ","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}else	
				{
      			 add(aa,no,bb,cc,dd,ee,ff,gg,hh,ii);
	

			PersonInfo3 p=new PersonInfo3(no);
			setVisible(false);
			p.setVisible(true);
				}
		      }
	      }
		public static void main(String[] args) 
	{
		PersonInfo2 t=new PersonInfo2( s1);
			t.setVisible(true);
	}
	
public void  add(String a,String jj,String b,String c,String d,String e,String f,String g,String h,String i )
		{
	
	    
	        try{

				String dsn="mcm";
                 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			      con=DriverManager.getConnection("jdbc:odbc:" + dsn);
	             
				  st=con.createStatement();
			
			     ResultSet rs=st.executeQuery("select * from PersonInfo2");
				 while(rs.next())
				{
				  gs=rs.getInt(1);
				}
				gs=gs+1;
 	           int  d1=Integer.parseInt(e);
               ps=con.prepareStatement("Insert into PersonInfo2 values (?,?,?,?,?,?,?,?,?,?)");
			   ps.setInt(1,gs);
			   ps.setString(2,jj);
			   ps.setString(3,a);
		       ps.setString(4,b);
			   ps.setString(5,c);
			   ps.setInt(6,d1);
			   ps.setString(7,f);
			   ps.setString(8,g);
			   ps.setString(9,h);
			   ps.setString(10,i);
			   ps.executeUpdate();
			   
		} catch(Exception ee)
			        {
                       System.out.println(ee);
				     }
           }

	}