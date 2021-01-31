package learningjava;

import java.io.File;

public class FileDemo {
	public void main (String[]args){
		File f = null;
		String[] strs = {"test1.txt","test2.txt"};
		try{
			//for each string in string array
			for(String s:strs){
				//create new file
				f = new File(s);
				//true if the File is executable
				boolean bool = f.canExecute();
				//find the absolute path
				String a =f.getAbsolutePath();
				//prints a absolute path
				System.out.print(a);
				System.out.println("is executable: "+bool);
				
			}
			}
			
			catch (Exception e){
				//fi nay I/o error occurs
				e.printStackTrace();
			}
		}
		
	}

