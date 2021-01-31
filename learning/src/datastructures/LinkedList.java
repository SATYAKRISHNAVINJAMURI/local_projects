package datastructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class MyNode
{
	private String name;
	private String dob;
    /*  Function to set data to current Node  */
    public void setData(String n,String d)
    {
    	name = n;
    	dob = d;
    }    
    /*Method to get name */
    public String getName()
    {
        return name;
    } 
    /*method to get dob*/
    public String getDob()
    {
        return dob;
    } 
}
public class LinkedList {
	public static void main(String[]args){
		int choice = 0;
		 Collection<MyNode> list = new ArrayList<>();       //usage of generics
		 Scanner scan = new Scanner(System.in); 
		   do
	        {
	        	System.out.println("\nQueue Operations");
	            System.out.println("1. To insert Data");
	            System.out.println("2. Search");
	            System.out.println("3. Display");
	            System.out.println("0. To exit");
	            choice = scan.nextInt();
	            switch (choice)
	            {
	            case 1 : 
	            	String n = null;
	            	String d = null;
	                scan.nextLine();
	            	while(true){
	            		MyNode nptr = new MyNode();
	            		System.out.println("Enter Data to be inserted.");
	            		n = scan.nextLine();
	            		if(n.equals("ENDOFINPUT")){
	            				break;
	            		}
	            		d = scan.nextLine();
	            		nptr.setData(n, d);
	            		list.add(nptr);
	            	}
	                
	                break;                         
	            case 2 : 
	                System.out.println("Enter a name to search");
	                scan.nextLine();
	                String s = scan.nextLine();
	                int flag = 0;
	                for(MyNode z:list){
	                	if(z.getName().equals(s)){
	                		flag++;
	                		System.out.println("Name: " + z.getName());
	                		System.out.println("Dob: " + z.getDob());
	                	}
	                }
	                if(flag == 0){
	                	System.out.println("User name not found in the list");
	                }
	                break;                         
	            case 3 : 
	            	 for(MyNode z:list){
		                   		System.out.println("Name: " + z.getName());
		                		System.out.println("Dob: " + z.getDob());
		            }
	            	System.out.println("End of List");
	                break;                              
	            case 0 :
	            	System.out.println("End of program");
	            	break;
	            default :
	            	System.out.println("Invalid Entry please try again. ");
	                break;
	            }                       
	        } while (choice != 0);      
	        scan.close();
	}
	
	
	
}
