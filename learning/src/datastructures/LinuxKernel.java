package datastructures;
import java.util.*;

class MsgNode 
{
    public String severity;
    public String username;
    public Date date;
    public String msgcontent;
    private MsgNode link;
    MsgNode(String s, String u ,String msg){
    	severity = s;
    	username = u;
    	date = new Date(System.currentTimeMillis());
    	msgcontent = msg;
    }
    
    public MsgNode getLink()
    {
        return link;
    }    
    
    
    /*  Function to set link to next MsgNode  */
    public void setLink(MsgNode n)
    {
        link = n;
    }    
}

/*Class circular queue extends linked 
 * queue and overrides the enQueue method
 */

class CircularQueue{
	
	protected MsgNode front, rear;
    public int size,maxsize;
 
    /* Constructor */
    public CircularQueue(int n)
    {
        front = null;
        rear = null;
        size = 0;
        maxsize = n;
    }
	public boolean isQueueFull(){
		return size == maxsize;
	}
	/*Check emptiness */
	 public boolean isQueueEmpty()
	    {
	        return front == null || size == 0;
	}  
    /*  Function to remove front element from the queue */
    public void deQueue()
    {
        if (isQueueEmpty() ){
            throw new NoSuchElementException("Queue underflow");
        }
        else{
        	 MsgNode ptr = front;
             front = ptr.getLink();  
             size-- ;
             if (front == null){
                 rear = null;
             }
             System.out.print(ptr.severity+" ");
	            System.out.print(ptr.username+" ");
	            System.out.print(ptr.date+" ");
	            System.out.print(ptr.msgcontent+" ");
             
        }
    }    
    /* Display the linked list */
	 public void listQueueElements()
	    {
	        System.out.print("\nQueue = ");
	        if (size == 0)
	        {
	            System.out.print("Empty\n");
	            return ;
	        }
	        MsgNode ptr = front;
	        while (ptr != rear.getLink() )
	        {
	            System.out.print(ptr.severity+"    ");
	            System.out.print(ptr.username+"    ");
	            System.out.print(ptr.date+"      ");
	            System.out.println(ptr.msgcontent+" ");
	            
	            ptr = ptr.getLink();
	        }
	        System.out.println();        
	    }
	 

	//Overload enQueue method
	public void enQueue(String s,String u, String msg) throws Exception
    {
        MsgNode nptr = new MsgNode(s,u,msg);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
            size++;
        }
        else if (isQueueFull() ){
        	if(!front.severity.equals("error")){
        		rear.setLink(nptr);
                rear = rear.getLink();
                front = front.getLink();
                rear.setLink(front);
        	}
        	else{
        		MsgNode temp = front;
        		MsgNode ptr = front.getLink();
        		int count = 0;
        		rear.setLink(nptr);
                rear = rear.getLink();
                rear.setLink(front);
                while(ptr.severity.equals("error")){
               		count++;
                   	temp = temp.getLink();
                   	ptr = ptr.getLink();
                   	if(count == size){
                   		throw new Exception("Couldnot found non Error severity messages");
                   	}
                }
               	temp.setLink(ptr.getLink());
               	ptr = null;
               	temp = null;
               
                  
        		
        	}
                 
        }
        else
        {
            rear.setLink(nptr);
            rear = rear.getLink();
            size++ ;
        }
        
    }    
	
	
}
public class LinuxKernel {
	 public static void main(String[] args)
	    {
	        Scanner scan = new Scanner(System.in);
	        System.out.println("Enter Size of Integer Queue ");
	        int maxsize = scan.nextInt();
	        CircularQueue q = new CircularQueue(maxsize);
	        int choice;
	        do
	        {
	        	System.out.println("\nQueue Operations");
	            System.out.println("1. enQueue message");
	            System.out.println("2. deQueue message");
	            System.out.println("3. display message");
	            System.out.println("4. check empty");
	            System.out.println("5. check full");
	            System.out.println("0. To exit");
	            choice = scan.nextInt();
	            switch (choice)
	            {
	            case 1 : 
	            	scan.nextLine();
	                System.out.println("Enter severity of the message");
	            	String s = scan.nextLine();
	            	System.out.println("Enter the username");
	            	String u = scan.nextLine();
	            	System.out.println("Enter the actual message content");
	            	String msg = scan.nextLine();
	                try
	                {
	                   q.enQueue(s,u,msg);
	                }
	                catch(Exception e)
	                {
	                    e.printStackTrace();
	                }                         
	                break;                         
	            case 2 : 
	                try
	                {
	                    q.deQueue();
	                }
	                catch(Exception e)
	                {
	                	e.printStackTrace();
	                }
	                break;                         
	            case 3 : 
	            	q.listQueueElements();
	                break;                            
	            case 4 : 
	                System.out.println("Empty status = "+q.isQueueEmpty());
	                break;                
	            case 5 : 
	                System.out.println("Full status = "+q.isQueueFull());
	                break;       
	            case 0 :
	            	System.out.println("End of program");
	            	break;
	            default :
	            	System.out.println("Invalid Entry please try again. ");
	                break;
	            }                       
	        } while (choice !=0);      
	        scan.close();
	    } 
}
