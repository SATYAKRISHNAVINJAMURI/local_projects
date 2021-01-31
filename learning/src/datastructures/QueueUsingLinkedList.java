package datastructures;
 
import java.util.*;
import java.util.NoSuchElementException;

 
/*  Class Node  */
class Node
{
    private int data;
    private Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }    
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}




/*  Class linkedQueue  */
class LinkedQueue
{
    protected Node front, rear;
    public int size,maxsize;
 
    /* Constructor */
    public LinkedQueue(int n)
    {
        front = null;
        rear = null;
        size = 0;
        maxsize = n;
    }    
    /*  Function to check if queue is empty */
    public boolean isQueueEmpty()
    {
        return front == null;
    }    
    /* Check whether Queue is full or not */
    public boolean isQueueFull() 
    {
        return size == maxsize;
    }
    
    /*  Function to get the size of the queue */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element to the queue */
    public void enQueue(int data)
    {
        Node nptr = new Node(data, null);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
        }
        else if (isQueueFull() ){
            throw new IndexOutOfBoundsException("Queue Overflow");
        }
        else
        {
            rear.setLink(nptr);
            rear = rear.getLink();
        }
        size++ ;
    }    
    /*  Function to remove front element from the queue */
    public int deQueue()
    {
        if (isQueueEmpty() )
            throw new NoSuchElementException("Queue underflow");
        Node ptr = front;
        front = ptr.getLink();        
        if (front == null)
            rear = null;
        size-- ;        
        return ptr.getData();
    }    
       
    /*  Function to display the status of the queue */
    public void listQueueElements()
    {
        System.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        Node ptr = front;
        while (ptr != rear.getLink() )
        {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getLink();
        }
        System.out.println();        
    }
}


 

 
/*  Class LinkedQueueImplement  */
public class QueueUsingLinkedList
{    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in); 
        /* Creating object of class linkedQueue */     
        System.out.println("Enter Size of Integer Queue ");
        int maxsize = scan.nextInt();
        LinkedQueue q = new LinkedQueue(maxsize);
        int choice;
        do
        {
        	System.out.println("\nQueue Operations");
            System.out.println("1. enQueue");
            System.out.println("2. deQueue");
            System.out.println("3. display");
            System.out.println("4. check empty");
            System.out.println("5. check full");
            System.out.println("0. To exit");
            choice = scan.nextInt();
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                try
                {
                    q.enQueue( scan.nextInt() );
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }                         
                break;                         
            case 2 : 
                try
                {
                    System.out.println("Removed Element = "+q.deQueue());
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