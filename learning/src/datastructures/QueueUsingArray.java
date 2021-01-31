package datastructures; 
import java.util.*;
class Queue
{
    private int Queue[] ;
    private int front, rear, size, length;
    //constructor
    public Queue(int n) 
    {
        size = n;
        length = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }    
    //  Checks whether queue is empty or not 
    public boolean isQueueEmpty() 
    {
        return (front == -1);
    }    
    //  Checks whether queue is full or not 
    public boolean isQueueFull() 
    {
        return (front == 0 && rear == size -1) ;
    }
    
    // Function to insert an element to the queue 
    public void enQueue(int i) 
    {
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)
            throw new IndexOutOfBoundsException("Queue Overflow");
        else if ( rear + 1 < size)
            Queue[++rear] = i;    
        length++ ;    
    }    
    //  Function to remove front element from the queue 
    public int deQueue() 
    {
        if (isQueueEmpty())
           throw new NoSuchElementException("Underflow Exception");
        else 
        {
            length-- ;
            int element = Queue[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else
                front++;                
            return element;
        }        
    }
    //  Function to display the status of the queue 
    public void listQueueElements()
    {
        System.out.print("\nQueue = ");
        if (length == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(Queue[i]+" ");
        System.out.println();        
    }
}
 
//Class QueueImplement 
public class QueueUsingArray
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Array Queue Test\n");
        System.out.println("Enter Size of Integer Queue ");
        int n = scan.nextInt();
        Queue q = new Queue(n);            
        int choice;
        do{
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
 
        } while (choice != 0);   
        scan.close();
    }    
}