package beans1;


import java.awt.*;
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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import beans1.BusDetails;

@SuppressWarnings("serial")
public class AddNewBusRoute extends JFrame implements ActionListener{
	protected static final String String = null;
	JTextField source,destination,busname,seats,arrivaltime,deperaturetime;
	JComboBox bustype;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton add,display,reset,remove;
	Container con;
	String type[]={"AC","Non-AC"};
	public AddNewBusRoute(){
		con=getContentPane();
		setLayout(new FlowLayout());
		l1=new JLabel("Enter source place of new route");
		source=new JTextField(27);
		con.add(l1);
		con.add(source);
		l2=new JLabel("Enter destination place of new route");
		destination=new JTextField(27);
		con.add(l2);
		con.add(destination);
		l3=new JLabel("Enter bus name of new route");
		busname=new JTextField(27);
		con.add(l3);
		con.add(busname);
		l4=new JLabel("Enter number of seat of in the bus");
		seats=new JTextField(27);
		con.add(l4);
		con.add(seats);
		l5=new JLabel("Choose bus type of the bus");
		bustype=new JComboBox(type);
		con.add(l5);
		con.add(bustype);
		l6=new JLabel("Enter deperature time of the bus in 24 hours (hrs:min) format");
		deperaturetime=new JTextField(27);
		con.add(l6);
		con.add(deperaturetime);
		l7=new JLabel("Enter arrival time of the bus in 24 hours (hrs:min) format");
		arrivaltime=new JTextField(27);
		con.add(l7);
		con.add(arrivaltime);
		add=new JButton("Add");
		con.add(add);
		add.addActionListener(this);
		display=new JButton("Display");
		con.add(display);
		
		
		display.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new BusDetailsDatabase();
			}
		});	
		reset=new JButton("Reset");
		con.add(reset);
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				source.setText("");
				destination.setText("");
				busname.setText("");
				seats.setText("");
				arrivaltime.setText("");
				deperaturetime.setText("");
			}
		});	
		setVisible(true);
    	setSize(370,400);
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new AddNewBusRoute();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		File f=new File("BusDetails.dat");
		Object obj;
		String so=source.getText();
		String des=destination.getText();
		String bname=busname.getText();
		String btype=(String)(bustype.getSelectedItem());
		String deptime=deperaturetime.getText();
		String arrtime=arrivaltime.getText();
		String broute=so+"-"+des;
		List<BusDetails> buslist=new ArrayList<BusDetails>();
		BusDetails bus;
		if(so.equals("")||des.equals("")||bname.equals("")||seats.getText().equals("")||deptime.equals("")||arrtime.equals(""))
			JOptionPane.showConfirmDialog(this, "Fields should not be empty");
		
		else
		{
			try{		
		if(f.exists())
		{
		try {
				
				FileInputStream fis=new FileInputStream("BusDetails.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);
				List<BusDetails> buslist1=new ArrayList<BusDetails>();
				while((obj=ois.readObject())!=null){
					buslist1=(List<BusDetails>)obj;
			        for(BusDetails bus1:buslist1)
			        {	
			        buslist1.add(bus1);
			        }
				}   
		       ois.close();
		       fis.close();
		     }
		  catch(EOFException e1){
			   
		   }
		  catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		  catch (IOException e1) {
				e1.printStackTrace();
			}
		  catch (ClassNotFoundException e1) {
				
				e1.printStackTrace();
			}
		try
		 {  int se=Integer.parseInt(seats.getText());
		    FileOutputStream fos=new FileOutputStream("BusDetails.dat");
	        ObjectOutputStream oos=new ObjectOutputStream(fos);
	        bus=new BusDetails(bname,broute,btype,se,deptime,arrtime);
	        buslist.add(bus);
	        oos.writeObject(buslist);
	        JOptionPane.showMessageDialog(this,"New route is added succesfully");
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
		else
		{
			try
			 {  int se=Integer.parseInt(seats.getText());
			    FileOutputStream fos=new FileOutputStream("BusDetails.dat");
		        ObjectOutputStream oos=new ObjectOutputStream(fos);
		        bus=new BusDetails(bname,broute,btype,se,deptime,arrtime);
		        buslist.add(bus);
		        oos.writeObject(buslist);
		        JOptionPane.showMessageDialog(this,"New route is added succesfully");
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
		catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(this,"Seats should be in integer form");
			seats.setText("");
			
		}
	  }
    }
}

	
