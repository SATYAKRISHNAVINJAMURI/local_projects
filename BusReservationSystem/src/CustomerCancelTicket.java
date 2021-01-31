import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import beans.BusDetails;
import beans.TicketDetails;


@SuppressWarnings("serial")
public class CustomerCancelTicket extends JFrame implements ActionListener{
	JTextField ticketno;
	JLabel l1;
	JButton cancel,exit,reset,back;
	Container con;
	String sou,des,broute,btype,bname,deptime,arrtime;
	int seat;
	String cname,cadd,cnum;
	public CustomerCancelTicket(String name,String add,String num){
		cname=name;
		cadd=add;
		cnum=num;
		Container con=getContentPane();
		con.setLayout(new GridLayout(4,2));
		Font f1= new Font("Times New Roman",Font.BOLD,15);
		l1=new JLabel("Enter the ticket number:-");
		l1.setFont(f1);
		l1.setForeground(Color.BLUE);
		ticketno=new JTextField(6);
		con.add(l1);  	con.add(ticketno);
		cancel=new JButton("CANCEL TICKET");
		cancel.setFont(f1);
		con.add(new JLabel(" "));  con.add(cancel);
		cancel.addActionListener(this);
		reset=new JButton("RESET");
		reset.setFont(f1);
		con.add(new JLabel(" ")); con.add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ticketno.setText("");	
			}
		});
		back=new JButton("BACK");
		back.setFont(f1);
		con.add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new CustomerHomepage(cname,cadd,cnum);
				setVisible(false);
			}
		});
		exit=new JButton("EXIT");
		con.add(exit);
		exit.setFont(f1);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});		
		setSize(400,280);
		setLocation(450,200);
		setResizable(false); 
		setTitle("CANCELLATION ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
    }
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int flag1=0,flag=1;
		List<TicketDetails> ticketlist=new ArrayList<TicketDetails>();
		if(ticketno.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Fields should not be empty");
		else
		{
		try{	
			int number=Integer.parseInt(ticketno.getText());
		try{
			Object obj;
			FileInputStream fis=new FileInputStream("TicketDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<TicketDetails> ticketlist1=new ArrayList<TicketDetails>();
			while((obj=ois.readObject())!=null){
				ticketlist1=(List<TicketDetails>)obj;
		        for(TicketDetails ticket:ticketlist1)
		        {
		        	if(number==ticket.getTicketnumber()&&cname.equals(ticket.getName()))
		        	 {	
		        		seat=ticket.getSeat();
		        	  	sou=ticket.getSource();
	        			des=ticket.getDestination();
	        			bname=ticket.getBusname();
	        			btype=ticket.getBustype();
	        			deptime=ticket.getDeperaturetime();
	        			arrtime=ticket.getArrivaltime();
		        	  JOptionPane.showMessageDialog(this,"Ticket is cancelled");
		        	  flag1=1;
		        	 }
		        	else
		        	 ticketlist.add(ticket);
	
		        }
			}
		        ois.close();
			    fis.close();
			}
			 catch(EOFException e1){
					
				   }
				  catch (FileNotFoundException e1) {
					  
					  JOptionPane.showMessageDialog(this, "Ticket not found");
					  flag=0;
					}
				  catch (IOException e1) {
					}
				  catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				  }
				  if(flag1==1)
				  { 
				    broute=sou+"-"+des;
			        List<BusDetails> buslist=new ArrayList<BusDetails>();
			        File f1=new File("BusDetails.dat");
					if(f1.exists())
					{
					try {
						FileInputStream fis=new FileInputStream("BusDetails.dat");
						ObjectInputStream ois=new ObjectInputStream(fis);
						Object obj;
				        List<BusDetails> blist=new ArrayList<BusDetails>();
				        while((obj=ois.readObject())!=null){
					        blist=(List<BusDetails>)obj;
					        for(BusDetails b:blist)
					        { if(broute.equalsIgnoreCase(b.getBusroute())&&btype.equalsIgnoreCase(b.getBustype())&&bname.equalsIgnoreCase(b.getBusname()))
					        	{   int c=b.getSeatbook()-seat;
					        		seat=seat+b.getSeats();
					        		BusDetails bus=new BusDetails(sou,des,bname,broute,btype,seat,deptime,arrtime,c);
				        			buslist.add(bus);
					        	}
					        	else
					        		buslist.add(b);
					        	
					        }
					        }
				        	ois.close();
				        	fis.close();
							}
							catch(EOFException e){
					   
							}
							catch (FileNotFoundException e) {
								JOptionPane.showMessageDialog(this, "Bus service not available");
					   
							} 
							catch (IOException e) {
								e.printStackTrace();
							} 
							catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
							try
							 { 
							    FileOutputStream fos=new FileOutputStream("BusDetails.dat");
						        ObjectOutputStream oos=new ObjectOutputStream(fos);
						        oos.writeObject(buslist);
						        oos.close();
						        fos.close();
						       } 
							catch (FileNotFoundException e1) {
								e1.printStackTrace();
							} 
							catch (IOException e1) {
								e1.printStackTrace();
							}
					}	
				  }	
		       if(flag1==0&&flag==1)
		        	JOptionPane.showMessageDialog(this, "   Ticket not found \n Please check ticket number\n Or ticket not booked in your name");
		        else
				{
				try
				 { 
				    FileOutputStream fos=new FileOutputStream("TicketDetails.dat");
			        ObjectOutputStream oos=new ObjectOutputStream(fos);
			        oos.writeObject(ticketlist);
			        oos.close();
			        fos.close();
			       } 
				catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				}
				}
				}catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(this,"Ticket number should be in integer form");
					ticketno.setText("");	
				}
				}
				
			}
}
