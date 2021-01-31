package assignments;
import java.util.Scanner;


public class OctalToDecimal {

	public static void main(String[] konda) {
		String num;
		// TODO Auto-generated method stub
		try{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the octal number");
		num=input.nextLine();
		int decimaloutput=Integer.parseInt(num,8);
		System.out.println("You entered - "+ decimaloutput);
		input.close();
		}
		catch(Exception ne){
		System.out.println(ne);
		}
		
		//What happens if we don't close the Scanner.
	}

}
