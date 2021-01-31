package learningjava;

public class Enums {
	enum Coke{SMALL,MEDIUM,LARGE,EXTRALARGE}
	public static void main(String []args){
		/*The method values() returns all the values that a enum can take.
		 * We can catch this values  in an array.
		 */
		Coke[] possibilities=Coke.values();
		Coke order=Coke.SMALL;
		Coke value=Coke.valueOf("MEDIUM");
		/*It returns the item Coke.MEDIUM
		 * 
		 */
		System.out.println(value);
		int num=Coke.LARGE.ordinal();
		/*It returns the ordinal value of that particular enum value.
		 * Here in this example SMALL=0;
		 * MEDIUM=1;
		 * LARGE=2;
		 * EXTRALARGE=3;
		 */
		System.out.println(num);
		for(Coke print:possibilities){
			System.out.println(print);
		}
		System.out.println(order);
	}

}
/*Enums also can be used in switch case statements.*/