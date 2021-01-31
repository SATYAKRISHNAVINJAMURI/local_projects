package assignments;
import java.util.Scanner;
import java.io.*;
public class UniqueWordCount {
	public static void main(String[]args){
		int count =0;
		String check = null;
		StopWatch stopwatch = new StopWatch();
		
		try{
			File file = new File(args[0]);
		/*Creating a input object of Scanner class to get
		 *  the input through Fileinput Stream
		 */
			Scanner input = new Scanner( new FileInputStream(file));
			stopwatch.start();
				while(input.hasNext()){//loop runs until EOF is reached
					check = input.next();
					if(check.contentEquals(args[1])){ //If the word is found
						count++;
					}
				}
			stopwatch.stop();
			input.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println("Number of Words in the given file"+ " are " + count);
		System.out.println("Time taken to find words - " + stopwatch.getElapsedTime()+" milliseconds" );
	}
}

