package learningjava;
import java.util.Scanner;
public class UserInputArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = new int[10];
		int counter;
		Scanner input;
		input = new Scanner(System.in);
		for ( counter=0; counter< array.length; counter++){
			array[counter]= input.nextInt();
		}
		
		System.out.println("you entered list");
		for (counter=0; counter< array.length;counter++){
			System.out.println(array[counter]);
		}
		
		input.close();
		

	}

}
