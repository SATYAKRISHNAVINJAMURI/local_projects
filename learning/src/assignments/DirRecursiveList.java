package assignments;
import java.io.File;
public class DirRecursiveList{
	public static void main(String[] args) {
		File currentDir = new File("E:\\Programmes\\java\\learningjava","src"); 
		displayList(currentDir);
	}
	public static void displayList(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getName());
					displayList(file);
				} else {
					System.out.println("     file:" + file.getName());
				}
			}
		} catch (Exception e) {
                    System.out.println(e);
		}
	}

}