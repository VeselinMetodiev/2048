package veselin_metodiev;

import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int[] array = new int[16];
		boolean[] taken = new boolean[16];
		Random generator = new Random();
		Scanner input = new Scanner(System.in);
		
	//	for(int j = 0; j < 100; j++)
		while(true)
		{
			
			System.out.println();
			System.out.println();
			
		int place = generator.nextInt(array.length);
		    if(taken[place]) {
		    	//j--;
		    	continue;
		    }
		    
		   	    
		    	
		//System.out.println(place);
		int twoOrFour = generator.nextInt(2);
		if(twoOrFour == 0)
			twoOrFour = 2;
		else
			twoOrFour = 4;
		
		if(!taken[place]) {
		array[place] = twoOrFour;
		taken[place] = true;
		}
		
		 
		    
		
		for(int i = 0; i < array.length; i++) {
			if( i == 4 || i == 8 || i == 12)
				System.out.println();
			System.out.printf("%4d", array[i]);
		}
		System.out.println();
		System.out.println();
		
		if(checkWin(array)) {
			System.out.println("Congratulations! You won! You are genius!");
		    break;
		}
		
		if(checkLose(array, taken)) {
			System.out.println("Game Over");
		    break;
		}
		
	
		System.out.println("Do you want to move right or left, up or down?");
	    char userInput = input.next().charAt(0);
		
		
	   if(userInput == 'l' )
	    {	
	moveLeft(array, taken);
	addLeft(array,taken);
    moveLeft(array, taken);
	
		}
	    else if(userInput == 'r')
	    {	
	moveRight(array, taken);
	addRight(array,taken);
    moveRight(array, taken);
	    }
	    
	    else if(userInput == 'd')
	    {	
	moveDown(array, taken);
	addDown(array,taken);
    moveDown(array, taken);
	
		}
	    
	    else if(userInput == 'u')
	    {	
	moveUp(array, taken);
	addUp(array,taken);
   moveUp(array, taken);
	
		}
	    else {
	    	System.out.println("Invalid move! Try again!");
	    }
	    
		//moveRight(array, taken);
		//addRight(array,taken);
		//moveRight(array, taken);
	    
	    
		for(int i = 0; i < array.length; i++) {
			if( i == 4 || i == 8 || i == 12)
				System.out.println();
			System.out.printf("%4d", array[i]);
		}
		
		
		}
	}
	
	static void moveRight(int array[], boolean[] taken) {
		for(int k = 0; k < 3; k++) {
		for(int j = 0; j < 16; j += 4) {
			for(int i = 0; i < 3; i++) {
			if(taken[i+j] && !taken[i+j+1]) {
				array[i+j+1] = array[i+j];
				taken[i+j+1] = true;
				array[i+j] = 0;
				taken[i+j] = false;
			}
			
			}
			
		}
		
		}	
		
								
				
			}
	
	static void moveLeft(int array[], boolean[] taken) {
		for(int k = 0; k < 3; k++) {
		for(int j = 0; j < 16; j += 4) {
			for(int i = 3; i > 0; i--) {
			if(taken[i+j] && !taken[i+j-1]) {
				array[i+j-1] = array[i+j];
				taken[i+j-1] = true;
				array[i+j] = 0;
				taken[i+j] = false;
			}
			
			}
			
		}
		}
								
				
			}
	
	static void moveDown(int array[], boolean[] taken) {
		for(int k = 0; k < 3; k++) {
		for(int i = 0; i < 16-4; i++) {
			if(taken[i] && !taken[i+4]) {
				array[i+4] = array[i];
				array[i] = 0;
				taken[i] = false;
				taken[i+4] = true;			}
		}
		}				
				
			}
	
	static void moveUp(int array[], boolean[] taken) {
		for(int k = 0; k < 3; k++) {
		for(int i = 0; i < 16-4; i++) {
			if(taken[i+4] && !taken[i]) {
				array[i] = array[i+4];
				array[i+4] = 0;
				taken[i+4] = false;
				taken[i] = true;			}
		}
		}				
				
			}
	
	static void addUp(int array[], boolean[] taken) {
		for(int j = 0; j < 16-4; j ++) {
			if(taken[j] && taken[j+4] && array[j] == array[j+4]) {
				array[j] = 2 * array[j+4];
			    array[j+4] = 0;
			    taken[j+4] = false;
			}
		}
		}
	
	static void addDown(int array[], boolean[] taken) {
		for(int j = 0; j < 16-4; j ++) {
			if(taken[j] && taken[j+4] && array[j] == array[j+4]) {
				array[j+4] = 2 * array[j];
			    array[j] = 0;
			    taken[j] = false;
			}
		}
		}
	
	
	static void addRight(int array[], boolean[] taken) {
		for(int j = 0; j < 16; j += 4) {
		for(int i = 3; i > 0; i--) {
			if(taken[i+j] && taken[i-1+j] && array[i+j] == array[i-1+j]) {
				array[i+j] = 2 * array[i-1+j];
			    array[i-1+j] = 0;
			    taken[i-1+j] = false;
			}
		}
		}
	}
	
	static void addLeft(int array[], boolean[] taken) {
		for(int j = 0; j < 16; j += 4) {
		for(int i = 3; i > 0; i--) {
			if(taken[i+j] && taken[i-1+j] && array[i+j] == array[i-1+j]) {
				array[i+j] = 2 * array[i-1+j];
			    array[i-1+j] = 0;
			    taken[i-1+j] = false;
			}
		}
		}
	}		
		

static boolean checkLose(int array[], boolean[] taken) {
	int count = 0;
	for(int i = 0; i < array.length; i++) {
		   if(taken[i])
			count++;
		}
		
	
	
	
	return nothingLeft(array,taken) && nothingLeft2(array,taken) && count == 16;
	
	
	
}

private static boolean nothingLeft2(int[] array, boolean[] taken) {
	for(int i = 0; i < array.length-4; i++) {
		if(array[i] != array[i+4])
			continue;
		else
			return false;
	}
	return true;
}

private static boolean nothingLeft(int[] array, boolean[] taken) {
	for(int i = 0; i < array.length-1; i++) {
		if(array[i] != array[i+1] && ( i != 3 || i != 7 || i != 11))
			continue;
		else
			return false;
	}
	return true;
}

private static boolean checkWin(int[] array) {
	for(int i = 0; i < array.length; i++) {
		if(array[i] == 2048)
	return true;
}
	return false;
}
}
	
	
