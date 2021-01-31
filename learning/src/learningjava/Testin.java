package learningjava;
import java.awt.Desktop;
import java.io.*;
public class Testin {
	public static void open(File document) throws IOException {
	    Desktop dt = Desktop.getDesktop();
	    dt.open(document);
	}
public static void main(String args[]) throws IOException
{
File file = new File("C:\\Users\\SATYA KRISHNA VINJAM\\Desktop\\lecture.pdf");
open(file);
}
}