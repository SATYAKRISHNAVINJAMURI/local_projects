package assignment3;

public abstract class Animal {
	public abstract void move(Animal[] river) ;
	public abstract String getName();
	public abstract void kill(Animal[] array);
	public abstract  void die(Animal[] array);
	public abstract void giveBirth(Animal[] array,int index);
	
}
