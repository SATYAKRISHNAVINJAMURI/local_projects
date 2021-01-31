package learningjava;
import javax.swing.JOptionPane;

public class Dialog {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name=JOptionPane.showInputDialog(null,"What is your name\n");
		String message= String.format("Hello %s. Welcome\n",name);
		JOptionPane.showMessageDialog(null,message);
		System.out.println("hello this is konda\n");

	}

}
