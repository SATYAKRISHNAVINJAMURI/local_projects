package assignment3;

public class Bear extends Animal {
	private int houseno;
	private String name = "Bear";
	Bear(int index){
		houseno = index;
	}
	public String getName(){
		return name;
	}
	public void move(Animal[] array){
		array[houseno - 1] = array[houseno];
		array[houseno] = null;
		houseno = houseno - 1;
		System.out.println("Bear was moved to the adjacent cell");
		
	}
	public void giveBirth(Animal[] array,int index){
		array[index] = new Bear(index);
		System.out.println("New Bear was Born");
	}
	public void kill(Animal[] array){
		array[houseno - 1] = array[houseno];
		array[houseno] = null;
		houseno = houseno - 1;
		System.out.println("Bear killed the fish in the adjacent cell");
	}
	public void die(Animal[] array){
		array[houseno] = null;
		System.out.println("Bear died");
	}
}
