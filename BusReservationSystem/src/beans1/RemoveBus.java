package beans1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import beans1.BusDetails;


@SuppressWarnings("serial")
public class RemoveBus extends JFrame implements ActionListener{
	Container con;
	static String route1;
	JComboBox busname,bustype;
	JLabel l1,l2;
	JButton remove;
	String type[]={"AC","Non-AC"};
	@SuppressWarnings("unchecked")
	public RemoveBus()
	{    String route1 ="Hyderabad";
		int i=0;
		con=getContentPane();
	    setLayout(new FlowLayout());
		try{
			
			Object obj;
			FileInputStream fis=new FileInputStream("BusDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<BusDetails> buslist=new ArrayList<BusDetails>();
			while((obj=ois.readObject())!=null){
				buslist=(List<BusDetails>)obj;
				String arrayname[]=new String[buslist.size()];
		        for(BusDetails bus:buslist)
		        {	if(bus.getBusroute().equalsIgnoreCase(route1))
		        	 {
		        	  arrayname[i]=bus.getBusname();
		        	 
		        	  i++;
		        	  buslist.remove(i);
		        	 }
		        }
		        busname=new JComboBox(arrayname);
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
		  if(i==0)
	        	JOptionPane.showConfirmDialog(this, "Route does not exists ");
		  else
		  {
		  l1=new JLabel("Choose bus name");
		  con.add(l1);
		  con.add(busname);
		  l2=new JLabel("Choose bus type");
		  bustype=new JComboBox(type);
		  con.add(l2);
		  con.add(bustype);
		  remove=new JButton("Remove Bus Service");
		  con.add(remove);
		  remove.addActionListener(this);
		  setVisible(true);
		  setSize(170,200);
	      setResizable(false);
		  }
	}
		  public static void main(String args[])
		  {
			 new RemoveBus() ;
		  }
		
	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int i=0;
		List<BusDetails> buslist=new ArrayList<BusDetails>();
		String name=(String)(busname.getSelectedItem());
		String type=(String)(bustype.getSelectedItem());
		try{
			
			Object obj;
			FileInputStream fis=new FileInputStream("BusDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			List<BusDetails> buslist1=new ArrayList<BusDetails>();
			String arraybusname[]=new String[buslist.size()];
			while((obj=ois.readObject())!=null){
				buslist1=(List<BusDetails>)obj;
		        for(BusDetails bus:buslist1)
		        {
		        	if(bus.getBusname().equals(name)&&bus.getBustype().equals(type)&&bus.getBusroute().equalsIgnoreCase(route1))
		        	 {
		        	  JOptionPane.showMessageDialog(this,"Existing route is succesfully removed with bus name");
		        	  i++;
		        	 }
		        	else
		        	 buslist.remove(bus);
	
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
		       if(i==0)
		        	JOptionPane.showConfirmDialog(this, "Choosen bus or bus type does not exist");
		        else
				{
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
      }
	           

