import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Date;


import javax.swing.*;


@SuppressWarnings("serial")
public class CustomerBookTicket extends JFrame implements ActionListener{
	Container con;
	JTextField source,destination;
	@SuppressWarnings("rawtypes")
	JComboBox year,month,date,bustype;
	JTextField seatsbook;
	JButton book,exit,reset,back,display;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,label,label1;
	String arrayyear[]={"2016","2017","2018"};
	String type[]={"AC","Non-AC"};
	String cname,cadd,cnum;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CustomerBookTicket(String name,String add,String num){
		int c;
		cname=name;
		cadd=add;
		cnum=num;
		Container con=getContentPane();
		con.setLayout(new GridLayout(9,2));
		Font f= new Font("ARIAL",Font.BOLD,15);
		Font f1= new Font("Times New Roman",Font.BOLD,15);
		Font f2= new Font("Times New Roman",Font.BOLD,10);
		label=new JLabel("BOOK YOUR TICKET :-");
		label.setFont(f);
		label.setForeground(Color.BLACK);
		con.add(label);con.add(new JLabel(""));
		label1=new JLabel("BUS SERVICE DETAILS   :-");
		label1.setFont(f1);
		label1.setForeground(Color.BLUE);
		display=new JButton("VIEW");
		display.setFont(f1);
		display.setForeground(Color.BLACK);
		con.add(label1); con.add(display);
		display.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
					new BusDetailsDatabase();
					
				}
			});
		
		String arraymonth[] = new String[12];
		for(int i=0;i<12;i++)
		{	c=i;
			c++;
			arraymonth[i]=String.valueOf(c);
		}
		String arraydate[] = new String[31];
		for(int i=0;i<31;i++)
		{	c=i;
		    c++;
			arraydate[i]=String.valueOf(c);	
		}
		
		l1=new JLabel("            BOARDING FROM :-");
		source=new JTextField(20);
		l1.setForeground(Color.BLUE);
		con.add(l1); con.add(source);
		l2=new JLabel("            DESTINATION :-");
		destination=new JTextField(20);
		l2.setForeground(Color.BLUE);
		con.add(l2); con.add(destination);
		l4=new JLabel("            DATE OF JOURNEY :-");
		l4.setForeground(Color.BLUE);
		l7=new JLabel("DAY");
		l7.setFont(f2);
		date=new JComboBox(arraydate);
		JPanel cpanel=new JPanel();
		cpanel.add(l7);
		cpanel.add(date);
		l6=new JLabel(" MONTH");
		l6.setFont(f2);
		month=new JComboBox(arraymonth);
		cpanel.add(l6);
		cpanel.add(month);
		l5=new JLabel("YEAR");
		l5.setFont(f2);
		year=new JComboBox(arrayyear);
		cpanel.add(l5);
		cpanel.add(year);
		con.add(l4); con.add(cpanel);
		JPanel cpanel1=new JPanel();
		l3=new JLabel("CHOOSE BUS TYPE");
		l3.setForeground(Color.BLUE);
		bustype=new JComboBox(type);
		cpanel1.add(l3);
		cpanel1.add(bustype);
		JPanel cpanel2=new JPanel();
		l8=new JLabel("NUMBER OF SEATS: ");
		l8.setForeground(Color.BLUE);
		seatsbook=new JTextField(3);
		cpanel2.add(l8);
		cpanel2.add(seatsbook);
		con.add(cpanel1);con.add(cpanel2);
		book=new JButton("BOOK TICKET");
		book.setFont(f1);
		book.setForeground(Color.BLACK);
		con.add(new JLabel("")); con.add(book);
		book.addActionListener(this);
		reset=new JButton("RESET");
		reset.setFont(f1);
		reset.setForeground(Color.BLACK);
		con.add(new JLabel(" ")); con.add(reset);
	
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				source.setText("");
				destination.setText("");
				seatsbook.setText("");
			}
		});	

		back=new JButton("BACK");
		back.setFont(f1);
		back.setForeground(Color.BLACK);
		con.add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerHomepage(cname,cadd,cnum);
				setVisible(false);
			}
		});
		exit=new JButton("EXIT");
		exit.setFont(f1);
		exit.setForeground(Color.BLACK);
		con.add(exit);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});	
		setSize(550,650);
		setLocation(400,50);
		setResizable(true); 
		setTitle("TICKET BOOKING");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
	}
  	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String sou=source.getText();
		String dest=destination.getText();
		String route=sou+"-"+dest;
		String type=(String)(bustype.getSelectedItem());
		int mon=Integer.parseInt((String)(month.getSelectedItem()));
		int date1=Integer.parseInt((String)(date.getSelectedItem()));
		int year1=Integer.parseInt((String)(year.getSelectedItem()));
		Date dt=new Date();
		Date dt1=new Date(year1,mon,date1);
		if(seatsbook.getText().equals("")||source.getText().equals("")||destination.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Fields should not be empty");
		else
		{try
		{
		int seat=Integer.parseInt(seatsbook.getText());
		if(dt.getMonth()==mon-1&&dt.getDate()+1==date1)
			{
			new BookTicket(cname,cadd,cnum,route,type,seat,dt1);
			}
		else
			JOptionPane.showMessageDialog(this, "Customer can book ticket only one day before");
		}
		catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(this,"Seats should be in integer form");
			seatsbook.setText("");	
		}
		}
		   
	}
}
