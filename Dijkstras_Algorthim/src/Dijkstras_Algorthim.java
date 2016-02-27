/*Authors: Dan Dudley & Derry O'Hanlon
 * 
 * 
 */

import java.util.Scanner;
import java.util.Random;

public class Dijkstras_Algorthim 
{
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);	//create the scanner
		int number_of_nodes;	//int to store the inputed value for the number of nodes		Dijkstras_Algorthim
		int max_length;			//int to store the inputed max range for the arc lengths
		
		System.out.println("Enter the number of vertices.");
		
		number_of_nodes = scan.nextInt();	//store the number of nodes being used
		
		System.out.println("Enter the max length of the arcs.");
		max_length = scan.nextInt();		//store the max arc length
		
		int[][] matrix = new int[number_of_nodes][number_of_nodes];	//create multidimensional matrix
		int[] distance = new int[number_of_nodes];	//create distance array
		int[] visited = new int[number_of_nodes];	//creates int that tracks current visited nodes
		int[] preD = new int[number_of_nodes];		//create int that stores path
		int min;
		int nextNode = 0;
		
		Random randomGenerator = new Random();	//create random number generator
		
		for(int i = 0; i < number_of_nodes; i++) {
			
			
			visited[i] = 0;	//enitalise visited to 0
			
			preD[i] = 0;	//initalise to 0
			
			for(int j = 0; j < number_of_nodes; j++) {	//fillout matrix table with values
				int randomInt = randomGenerator.nextInt(max_length);	//set the max length of the random number generator
				matrix[i][j] = randomInt;
				
				if(matrix[i][j] == 0)
					matrix[i][j] = 999;
			}
		}
		
		distance = matrix[0];
		distance[0] = 0;
		visited[0] = 1;
		
		//start the algorithm
		
		for(int i = 0; i < number_of_nodes; i++){	//run length depending on entered number of nodes
			
			min = 999;
			
			for(int j =0; j < number_of_nodes; j++){
				
				if(min > distance[j] && visited[j]!=1){
					
					min = distance[j];
					nextNode = j;
					
					
				}
			}
			
			visited[nextNode] = 1;
			
			for(int c = 0; c < number_of_nodes; c++) {
				
				if(visited[c]!=1){
					
					if(min+matrix[nextNode][c]<distance[c]){
						
					distance[c]=min+matrix[nextNode][c];
					preD[c] = nextNode;
					
					}
				}
			}
		}
		
		for(int i = 0; i < number_of_nodes; i++){	//print out the path from 0 to each node
			
			int j;
			
			System.out.print("Path = " + i);
			
			j = i;
			
			do{
				
				j = preD[j];
				System.out.print(" <- " + j);
				
			}while(j != 0);
			
			System.out.println();
		}
		
	}
}