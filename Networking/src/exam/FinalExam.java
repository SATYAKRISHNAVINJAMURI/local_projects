package exam;

import java.io.File;
import java.util.Scanner;

public class FinalExam {
	
	public void DetermineFileEntries (String DirPath, String Filename) {
		 File[] faFiles = new File(DirPath).listFiles();
			  for(File file: faFiles){
			    if(file.getName().matches(Filename)){
			      System.out.println(file.getAbsolutePath());
			    }
			    if(file.isDirectory()){
			      DetermineFileEntries(file.getAbsolutePath(),Filename);
			   }
			  }
	}
		 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the directory path");
		String dirpath = scan.nextLine();
		System.out.println("Enter the file name or regex");
		String filename = scan.nextLine();
		FinalExam obj = new FinalExam();
		obj.DetermineFileEntries(dirpath, filename);
		
		

	}

}
