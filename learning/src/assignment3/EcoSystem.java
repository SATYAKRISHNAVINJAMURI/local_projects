package assignment3;
import java.util.Random;

public class EcoSystem {
	public static int size = 100;
	public  Animal[] river = new Animal[size];
	public static Random rand = new Random();
	
	/*
	 * Finds an empty house to place the new born animal
	 * throws an exception if no empty house was found
	 * 	 */
	public  int findEmptyHouse()throws Exception{ 
		int k = 0;
		int flag = 1;
		
		do{
		k = rand.nextInt(size);
		}while(river[k] != null && flag < size);
		if (flag > size){
			System.out.println("Couldn't find an empty house");
			throw new Exception("Couldn't find empty house exception");
		}
		return k;
	}
	
	/*
	 * Display the entire list of the animals present in the river
	 * 
	 */
	public  void display(){
		int i = 0;
		for(Animal obj : river){
			if(obj == null){
				System.out.println("HouseNo - "+ i +"; Animal - Null ");
			}
			else{
				System.out.println("HouseNo - " + i +"; Animal - " + obj.getName());
			}
		i++;
		}
		System.out.println("End of river");
	}
	
	/*
	 * Orders the animals either to move or stay in the same cell depending on the arbitary output (ie either 1 or 0)
	 * 
	 */
	public void timeStep(){
		int k = 0;
		for(int i = 1 ; i < size ; i++){
			k = rand.nextInt(2); 
			if(k == 0 && river[i] != null){  //if the animal is ordered to move and the animal is present at that houseno
				System.out.println("The animal at houseno - " + i + " is ordered to move");
				if(river[i-1] == null){ //if the adjacent house is empty
					river[i].move(river);
				}
				else{    //if the adjacent house is not empty
					if(river[i] instanceof Bear){ // if Bear is present 
						if(river[i-1] instanceof Fish){ //if Fish is present in the adjacent house
							river[i-1].die(river);
							river[i].kill(river);
						}
						else{       //if Bear is present in teh adjacent to another bear
							try{
								int house = findEmptyHouse();
								river[i].giveBirth(river,house);
							}
							catch(Exception e){
								System.out.println("Error in finding the new house" + e);
							}
						}
					}
					else{ //if Fish is present in the house
						if(river[i-1] instanceof Bear){ //if Bear is present adjacent to Fish
							river[i].die(river);
						}
						else{ // if Fish is present adjacent to Fish
							try{
								int house = findEmptyHouse();
								river[i].giveBirth(river,house);
							}
							catch(Exception e){
								System.out.println("Error in finding the new house" + e);
							}
						}
					}
				
				}
				display(); //display the animals in the river at different housenumbers
			}
		}
	}
	public static void main(String[]args){
	
	//Filling the rivers with animals arbitarily
		EcoSystem system1 = new EcoSystem();
	for(int i = 0; i < size ; i++){
		int k = rand.nextInt(3);
		if(k == 0){
			system1.river[i] = null; //no animal is placed
		}
		else if(k == 1){
			system1.river[i] =  new Bear(i);
		}
		else{
			system1.river[i] = new Fish(i);
		}
	}
	system1.display();
	system1.timeStep();
	}
	
}
