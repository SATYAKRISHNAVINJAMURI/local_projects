package learningjava;
import java.util.*;
public class HelloWorld{
	public static void main(String []args){
		String S="satya";
		
		String A;
		System.out.println("Enter a Sentence to print");
		Scanner input =new Scanner(System.in);
		input.nextDouble();
		input.next();
		A=input.nextLine();
		input.nextDouble();
		input.nextInt();
		
		A="Satya";
		System.out.println("You entered "+S +A);
		input.close();
	}
	
}