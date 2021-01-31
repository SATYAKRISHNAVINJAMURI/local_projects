package datastructures;
/*Here I used Graph as  my datastructure which is represented using 
 * a adjacent matrix as taking each suburban as a node i can consider the distance between them as
 * length of the edges and i can apply algorithm's to find the shortest path. Graph is the best
 * datastructure to find the distance between two paths and also finding the shortest path in 
 * the cirucuit
 * 
 * Then I started finding the minimum distances from one suburban to the other suburban.
 * 
 */





import java.util.Scanner;


class Distance{
	
	Scanner input = new Scanner(System.in);
	int[][] adjacent_matrix = new int[6][6];
	//constructor to get the distance between different suburbans.
	Distance(){           
		for(int i=0; i< 6; i++){
			for(int j=0;j<6;j++){
				if(i==j){
					adjacent_matrix[i][j] = 0;
				}
				if(i<j){
					System.out.println("Enter the distance Between the Suburbs - S" + i +" to S" +j);
					adjacent_matrix[i][j] = input.nextInt();
					adjacent_matrix[j][i] = adjacent_matrix[i][j];
					
				}
				
			}	
		}
		
			
	}
	
	/*This method will find the shortest distances between the different nodes 
	*and returns an multidimensional array.
	*In this method a new array as of same size of 
	*the adjacent_matrix is created and filled 
	*with shortest distances into corresponding places.
	*and the remaining places are filled with 0;
	*
	*/
	public int[][] find(){
		int[][] shortest = new int[6][6];
		int[] minimum = new int[6];
		int min;
		int i = 0,j = 0;
		for(i=0; i< 6; i++){
			min = 2147483647;
			for( j=0;j<6;j++){
				if(i!=j){
					
					if(min > adjacent_matrix[i][j]){
						min = adjacent_matrix[i][j];
					}
				}	
			}
			minimum[i] = min;
		}
		for(i=0; i< 6; i++){
			for( j=0;j<6;j++){
				if(adjacent_matrix[i][j] == minimum[i]){
					shortest[i][j] = adjacent_matrix[i][j];
				}
				else{
					shortest[i][j] = 0;
				}
			}	
		}
		return shortest;
		
	}
	
		
	//Find the lenght of the edge.
	
    public int getEdge(int to, int from) 
    {
        try 
        {
            return adjacent_matrix[to][from];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }
}
public class FlyOver {
	
	public static void main (String[] args){
		int total = 0;
		 Distance dist = new Distance();
		 System.out.println("The adjacency matrix for the given graph is: ");
         System.out.print("  ");
         for (int i = 0; i < 6; i++)
             System.out.print("S"+i + " ");
         System.out.println();

         for (int i = 0; i < 6; i++) 
         {
             System.out.print("S"+i + " ");
             for (int j = 0; j < 6; j++) 
                 System.out.print(dist.getEdge(i, j) + "  ");
             System.out.println();
         }
         
         
         /*Algorithm to find the flyovers that can be constructed with minimum cost
          * here the resultant connections produce the final result.
          */
         
         
         System.out.println("The  flyovers can be build be following suburbans");
        int[][] answer =  dist.find();
        for(int i=0; i< 6; i++){
			for(int j=0;j<6;j++){
				
					if(answer[i][j] != 0){
						System.out.println("S"+i +" to S" +j+ "   or   S"+j+ " to S"+ i +"   Distance -  " + answer[i][j]);
						total = total +answer[i][j];
						break;
					}	
			}	
		}
        System.out.println("By constructing the flyovers across the above suburbans the government meets the ovjective of least total constructions");
        System.out.println("Total minimum distance:" + total); //prints the total distance
         
	}
	

}

