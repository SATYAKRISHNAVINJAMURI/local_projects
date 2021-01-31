package assignments;
import java.util.PriorityQueue;
import java.util.Scanner;

class Job {
	private String name;
	private int length;
	private int priority;
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setLength(int length){
		this.length = length;
	}
	public int getLength(){
		return length;
	}
	public void setPriority( int priority){
		this.priority = priority;
	}
	public int getPriority(){
		return priority;
	}
	
}

public class JobScheduling{
	Scanner input = new Scanner(System.in);
	PriorityQueue<Job> tasks = new PriorityQueue<>();
	public void execute(){
		int count = 0;
		int choice = 0;
		while(count < getLength()){
			System.out.println("Enter\n 1 -To execute add job name with length n and priority p\n2 -no new job this slice");
			choice = input.nextInt();
			if(choice == 1){
				Job j = new Job();
				System.out.println("Enter name of the job");
				j.setName(input.nextLine());
				System.out.println("Enter length of the line");
				j.setLength( input.nextInt());
				System.out.println("Enter priority of the task");
				j.setPriority(input.nextInt());
				tasks.add(j);
				
			}
			count++;
			
		}
	}
	
}
