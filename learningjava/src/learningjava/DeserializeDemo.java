package learningjava;
import java.io.*;
import java.io.ObjectInputStream;
public class DeserializeDemo{
	
	try{
		FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		e =(Employee) in.readObject();
		in.close();
		fileIn.close();
	}catch(IOException i){
		i.printStackTrace();
		return;
	}catch(ClassNotFoundException c){
		System.out.println("Employee class not found");
		c.printStackTrace();
		return;
	}
	System.out.prinln("Deserilizaton Employee....");
	System.out.prinln("Name:" + e.name);
	System.out.println("Address :" + e.address);
	System.out.println("IO;" + e.ID);

}

