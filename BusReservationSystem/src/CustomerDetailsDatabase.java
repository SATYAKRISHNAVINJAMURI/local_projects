import java.awt.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import beans.CustomerDetails;
@SuppressWarnings("serial")
public class CustomerDetailsDatabase extends JFrame{
	JTable customerTable;
	String cols[]={"Name","Address","Contact number","E-mail","Password"};
	String[][] rows;
	@SuppressWarnings("unchecked")
	public CustomerDetailsDatabase(){
		File f=new File("CustomerDetails.dat");
		Container con=getContentPane();
		setLayout(new BorderLayout());
		int r=0;
		if(f.exists())
		{
		try {
			FileInputStream fis=new FileInputStream("CustomerDetails.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object obj;
	        List<CustomerDetails> clist=new ArrayList<CustomerDetails>();
	        while((obj=ois.readObject())!=null){
		        clist=(List<CustomerDetails>)obj;
		        rows=new String[clist.size()][cols.length];
		        for(CustomerDetails c:clist)
		        {rows[r][0]=c.getName();
				rows[r][1]=c.getAdd();
				rows[r][2]=c.getPhno();
				rows[r][3]=c.getEmail();
				rows[r][4]=String.valueOf(c.getPass());
				r++;
				}
		        }
	        
	       ois.close();
	       fis.close();
	       }
	   catch(EOFException e){
		   
	   }
	   catch (FileNotFoundException e) {
		   JOptionPane.showConfirmDialog(this, "Database not created");
		   
		   
		} 
	   catch (IOException e) {
			e.printStackTrace();
		} 
	   catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
		else
			  JOptionPane.showConfirmDialog(this, "Database is not created");
		customerTable=new JTable(rows,cols);
		JScrollPane pane=new JScrollPane(customerTable);
		con.add(pane,"Center");
		setVisible(true);
		setSize(800,240);
		setLocation(250,200);
		setResizable(false);		
		}
}
