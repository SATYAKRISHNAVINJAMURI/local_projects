package assignment3;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class EBookReader {
	private List<String> purchasedBooks = new ArrayList<>();
	private String directoryName;
	private File dir;
	private File[] files;
	EBookReader(String path){
		directoryName = path;
		dir = new File(directoryName);
		files = dir.listFiles();//Contains the list of files in the directory
	}
	/*
	 * Display the list of EBooks Available
	 */
	public void display(){
	    System.out.println("Listing All the EBooks");
	    for(File list: files){
	    	System.out.println(list.getName());
	    }
	    System.out.println("End of List");
	}
	/*
	 * Display the list of purchased books of an user
	 */
	public void displayPurchasedBooks(){
		if(purchasedBooks.isEmpty()){
			System.out.println("You havenot purchased any Books");
		}
		else{
			System.out.println("Purchased Books:");
			for(String book: purchasedBooks){
	    		System.out.println(book);
	    		
	    	}
			System.out.println("End of list");
		}
	}
	/*
	 * Purchases the book and add the book to the purchased list of the user.
	 * 
	 */
	public void purchase(String bookName){
		int flag = 0;
	    for(File list: files){
	  	    	if(list.getName().equalsIgnoreCase(bookName)){
	    		purchasedBooks.add(list.getName());
	    		System.out.println("Succesfully purchased the book");
	    		flag++;
	    		
	    	}
	    }
	    if(flag == 0){
	    	System.out.println("Couldn't find the Book");
	    }
	}
	/*
	 * Opens the file if the URI  of the file is give as an argument to the method.
	 * Uses the system default app to open the file
	 * throws IOException if file not found.
	 */
	public static void open(File document) throws IOException {
	    Desktop dt = Desktop.getDesktop();  //returns the desktop instance of current browser context
	    dt.open(document);
	}
	/*
	 * Reads the file using a default app(of that particular file) of that system.
	 * If it able to find the file in the purchased section then it reads the file.
	 * throws exception if couldn't read the file
	 */
	public void read(String bookName){
		int flag = 0;
		for(String book: purchasedBooks){
  	    	if(book.equalsIgnoreCase(bookName)){
    		System.out.println("Succesfully opened the book");
    		File file = new File("C:\\Users\\SATYA KRISHNA VINJAM\\Desktop\\java\\"+bookName);
    		try{
    			open(file);
    		}
    		catch(Exception e){
    			System.out.println("Error occured while reading the given file" + e);
    		}
    		flag++;
    		
    	}
    }
	if(flag == 0){
    	System.out.println("You haven't purchased the book. \nKindly puchase the book inorder to read it");
    }
	}
	public static void main(String[]args){
		int c;
		Scanner input = new Scanner(System.in);
		String path = "C:\\Users\\SATYA KRISHNA VINJAM\\Desktop\\java";
		EBookReader user1 = new EBookReader(path);
		do{
			System.out.println("Enter:\n1) - To show the list of EBooks Available.\n2) - Purchase a Book.\n3) - Read an EBook\n4) - To display the purchased books list\n0) -  To Exit");
			c = input.nextInt();
			switch(c){
				case 1:
					user1.display();
				break;
				case 2:
					String book;
					System.out.println("Enter the name of the book you want to purchase");
					input.nextLine();
					book = input.nextLine();
					try{
						user1.purchase(book);
					}
					catch(Exception e){
						System.out.println("Error occrred during purchasing the book" + e);
					}
				break;
				case 3:
					System.out.println("Enter the name of the book you want to Read");
					input.nextLine();
					book = input.nextLine();
					try{
						user1.read(book);	
					}
					catch (Exception e){
						System.out.println("Error occured in opening the file" + e);
					}
				break;
				case 4:
					user1.displayPurchasedBooks();
				break;
				case 0:
						System.out.println("Meet you next time.\nGood Bye!");
					
				break;
				default :
					System.out.println("Invalid input");
			}
		}while(c != 0);
		input.close();
		
	}
	
}
