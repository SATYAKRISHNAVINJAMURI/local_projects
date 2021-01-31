package learningjava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {

	Employee e = new Employee("IIITDM");
	e.address = "phokka kuan, Ambehta peer";
	e.ID =12345;
	
	try {
		FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.defaultWriteObject();
		out.close();
		fileOut.close();
		System.out.println("Serialized data is saved in /tmp/employee.ser");
	}catch(IOException i){
		i.printStackTrace();
	}
}

}