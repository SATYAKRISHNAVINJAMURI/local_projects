package assignments;
import java.util.Scanner;
import java.io.*;
public class NoOfWordsInFile {
	public static void main(String[]args){
		int count =0;
		
		try{File file = new File(args[0]);
		/*Creating a input object of Scanner class to get
		 *  the input through Fileinput Stream
		 */
		Scanner input = new Scanner( new FileInputStream(file));
			while(input.hasNext()){//loop run until it founds the EOF is reached
				input.next();
				count++;
			}
			input.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("Number of Words in the given file"+ " are " + count);
	}
}
