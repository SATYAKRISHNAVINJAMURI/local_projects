package assignment3;

public class Fish extends Animal {
	int houseno;
	public String name = "Fish";
	Fish(int index){
		houseno = index;
	}
	public String getName(){
		return name;
	}
	public void move(Animal[] array){
		array[houseno - 1] = array[houseno];
		array[houseno] = null;
		houseno = houseno - 1;
		System.out.println("Fish was moved to the adjacent cell");
		
	}
	public void giveBirth(Animal[] array,int index){
		array[index] = new Fish(index);
		System.out.println("New Fish was Born");
	}
	public  void kill(Animal[] array){
		array[houseno - 1] = array[houseno];
		array[houseno] = null;
		houseno = houseno - 1;
		System.out.println("Fish killed the Bear in the adjacent cell");
	}
	public void die(Animal[] array){
		array[houseno] = null;
		System.out.println("Fish died");
	}
}
